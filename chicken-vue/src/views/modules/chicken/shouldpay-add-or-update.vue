<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="费用类型 " prop="category">
      <el-input v-model="dataForm.category" placeholder="费用类型 "></el-input>
    </el-form-item>
    <el-form-item label="日期" prop="time">
      <el-input v-model="dataForm.time" placeholder="日期"></el-input>
    </el-form-item>
    <el-form-item label="应收金额" prop="incomePrice">
      <el-input v-model="dataForm.incomePrice" placeholder="应收金额"></el-input>
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
          name: 0,
          category: '',
          time: '',
          incomePrice: ''
        },
        dataRule: {
          category: [
            { required: true, message: '费用类型 不能为空', trigger: 'blur' }
          ],
          time: [
            { required: true, message: '日期不能为空', trigger: 'blur' }
          ],
          incomePrice: [
            { required: true, message: '应收金额不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.name = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.name) {
            this.$http({
              url: this.$http.adornUrl(`/chicken/shouldpay/info/${this.dataForm.name}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.category = data.shouldpay.category
                this.dataForm.time = data.shouldpay.time
                this.dataForm.incomePrice = data.shouldpay.incomePrice
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
              url: this.$http.adornUrl(`/chicken/shouldpay/${!this.dataForm.name ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'name': this.dataForm.name || undefined,
                'category': this.dataForm.category,
                'time': this.dataForm.time,
                'incomePrice': this.dataForm.incomePrice
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
