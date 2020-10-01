<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="支出金额合计" prop="expendPrice">
      <el-input v-model="dataForm.expendPrice" placeholder="支出金额合计"></el-input>
    </el-form-item>
    <el-form-item label="开始日期" prop="beginTime">
      <el-input v-model="dataForm.beginTime" placeholder="开始日期"></el-input>
    </el-form-item>
    <el-form-item label="截止日期" prop="endTime">
      <el-input v-model="dataForm.endTime" placeholder="截止日期"></el-input>
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
          expendCategory: 0,
          expendPrice: '',
          beginTime: '',
          endTime: ''
        },
        dataRule: {
          expendPrice: [
            { required: true, message: '支出金额合计不能为空', trigger: 'blur' }
          ],
          beginTime: [
            { required: true, message: '开始日期不能为空', trigger: 'blur' }
          ],
          endTime: [
            { required: true, message: '截止日期不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.expendCategory = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.expendCategory) {
            this.$http({
              url: this.$http.adornUrl(`/chicken/expend/info/${this.dataForm.expendCategory}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.expendPrice = data.expend.expendPrice
                this.dataForm.beginTime = data.expend.beginTime
                this.dataForm.endTime = data.expend.endTime
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
              url: this.$http.adornUrl(`/chicken/expend/${!this.dataForm.expendCategory ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'expendCategory': this.dataForm.expendCategory || undefined,
                'expendPrice': this.dataForm.expendPrice,
                'beginTime': this.dataForm.beginTime,
                'endTime': this.dataForm.endTime
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
