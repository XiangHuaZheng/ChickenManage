<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="当前库存" prop="stockNum">
      <el-input v-model="dataForm.stockNum" placeholder="当前库存"></el-input>
    </el-form-item>
    <el-form-item label="累计入库" prop="stockIn">
      <el-input v-model="dataForm.stockIn" placeholder="累计入库"></el-input>
    </el-form-item>
    <el-form-item label="累计出库" prop="stockOut">
      <el-input v-model="dataForm.stockOut" placeholder="累计出库"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          category: 0,
          stockNum: '',
          stockIn: '',
          stockOut: ''
        },
        dataRule: {
          stockNum: [
            { required: true, message: '当前库存不能为空', trigger: 'blur' }
          ],
          stockIn: [
            { required: true, message: '累计入库不能为空', trigger: 'blur' }
          ],
          stockOut: [
            { required: true, message: '累计出库不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.category = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.category) {
            this.$http({
              url: this.$http.adornUrl(`/chicken/eggsstock/info/${this.dataForm.category}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.stockNum = data.eggsstock.stockNum
                this.dataForm.stockIn = data.eggsstock.stockIn
                this.dataForm.stockOut = data.eggsstock.stockOut
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/chicken/eggsstock/${!this.dataForm.category ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'category': this.dataForm.category || undefined,
                'stockNum': this.dataForm.stockNum,
                'stockIn': this.dataForm.stockIn,
                'stockOut': this.dataForm.stockOut
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
