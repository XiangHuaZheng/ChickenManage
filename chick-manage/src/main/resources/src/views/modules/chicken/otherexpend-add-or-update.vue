<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="支出日期" prop="expendTime">
      <el-input v-model="dataForm.expendTime" placeholder="支出日期"></el-input>
    </el-form-item>
    <el-form-item label="支出类型" prop="incomeCategory">
      <el-input v-model="dataForm.incomeCategory" placeholder="支出类型"></el-input>
    </el-form-item>
    <el-form-item label="支出金额" prop="incomePrice">
      <el-input v-model="dataForm.incomePrice" placeholder="支出金额"></el-input>
    </el-form-item>
    <el-form-item label="经办人" prop="agent">
      <el-input v-model="dataForm.agent" placeholder="经办人"></el-input>
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
          expendTime: '',
          incomeCategory: '',
          incomePrice: '',
          agent: '',
          remarks: ''
        },
        dataRule: {
          expendTime: [
            { required: true, message: '支出日期不能为空', trigger: 'blur' }
          ],
          incomeCategory: [
            { required: true, message: '支出类型不能为空', trigger: 'blur' }
          ],
          incomePrice: [
            { required: true, message: '支出金额不能为空', trigger: 'blur' }
          ],
          agent: [
            { required: true, message: '经办人不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/chicken/otherexpend/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.expendTime = data.otherexpend.expendTime
                this.dataForm.incomeCategory = data.otherexpend.incomeCategory
                this.dataForm.incomePrice = data.otherexpend.incomePrice
                this.dataForm.agent = data.otherexpend.agent
                this.dataForm.remarks = data.otherexpend.remarks
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
              url: this.$http.adornUrl(`/chicken/otherexpend/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'expendTime': this.dataForm.expendTime,
                'incomeCategory': this.dataForm.incomeCategory,
                'incomePrice': this.dataForm.incomePrice,
                'agent': this.dataForm.agent,
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
