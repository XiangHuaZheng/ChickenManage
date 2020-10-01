<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="批次号" prop="batchNo">
      <el-input v-model="dataForm.batchNo" placeholder="批次号"></el-input>
    </el-form-item>
    <el-form-item label="鸡舍号" prop="chickenNo">
      <el-input v-model="dataForm.chickenNo" placeholder="鸡舍号"></el-input>
    </el-form-item>
    <el-form-item label="存储量" prop="storeNum">
      <el-input v-model="dataForm.storeNum" placeholder="存储量"></el-input>
    </el-form-item>
    <el-form-item label="类别" prop="category">
      <el-input v-model="dataForm.category" placeholder="类别"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remarks">
      <el-input v-model="dataForm.remarks" placeholder="备注"></el-input>
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
          id: 0,
          batchNo: '',
          chickenNo: '',
          storeNum: '',
          category: '',
          remarks: ''
        },
        dataRule: {
          batchNo: [
            { required: true, message: '批次号不能为空', trigger: 'blur' }
          ],
          chickenNo: [
            { required: true, message: '鸡舍号不能为空', trigger: 'blur' }
          ],
          storeNum: [
            { required: true, message: '存储量不能为空', trigger: 'blur' }
          ],
          category: [
            { required: true, message: '类别不能为空', trigger: 'blur' }
          ],
          remarks: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/chicken/enterdetail/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.batchNo = data.enterdetail.batchNo
                this.dataForm.chickenNo = data.enterdetail.chickenNo
                this.dataForm.storeNum = data.enterdetail.storeNum
                this.dataForm.category = data.enterdetail.category
                this.dataForm.remarks = data.enterdetail.remarks
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
              url: this.$http.adornUrl(`/chicken/enterdetail/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'batchNo': this.dataForm.batchNo,
                'chickenNo': this.dataForm.chickenNo,
                'storeNum': this.dataForm.storeNum,
                'category': this.dataForm.category,
                'remarks': this.dataForm.remarks
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
