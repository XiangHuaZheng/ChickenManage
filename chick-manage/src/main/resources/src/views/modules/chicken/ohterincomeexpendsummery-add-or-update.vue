<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="收入金额" prop="incomePrice">
      <el-input v-model="dataForm.incomePrice" placeholder="收入金额"></el-input>
    </el-form-item>
    <el-form-item label="支出金额" prop="expendPrice">
      <el-input v-model="dataForm.expendPrice" placeholder="支出金额"></el-input>
    </el-form-item>
    <el-form-item label="利润" prop="profit">
      <el-input v-model="dataForm.profit" placeholder="利润"></el-input>
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
          category: 0,
          incomePrice: '',
          expendPrice: '',
          profit: '',
          beginTime: '',
          endTime: ''
        },
        dataRule: {
          incomePrice: [
            { required: true, message: '收入金额不能为空', trigger: 'blur' }
          ],
          expendPrice: [
            { required: true, message: '支出金额不能为空', trigger: 'blur' }
          ],
          profit: [
            { required: true, message: '利润不能为空', trigger: 'blur' }
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
        this.dataForm.category = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.category) {
            this.$http({
              url: this.$http.adornUrl(`/chicken/ohterincomeexpendsummery/info/${this.dataForm.category}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.incomePrice = data.ohterincomeexpendsummery.incomePrice
                this.dataForm.expendPrice = data.ohterincomeexpendsummery.expendPrice
                this.dataForm.profit = data.ohterincomeexpendsummery.profit
                this.dataForm.beginTime = data.ohterincomeexpendsummery.beginTime
                this.dataForm.endTime = data.ohterincomeexpendsummery.endTime
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
              url: this.$http.adornUrl(`/chicken/ohterincomeexpendsummery/${!this.dataForm.category ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'category': this.dataForm.category || undefined,
                'incomePrice': this.dataForm.incomePrice,
                'expendPrice': this.dataForm.expendPrice,
                'profit': this.dataForm.profit,
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
