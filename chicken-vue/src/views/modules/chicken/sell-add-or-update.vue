<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="销售单号" prop="sellNo">
      <el-input v-model="dataForm.sellNo" placeholder="销售单号"></el-input>
    </el-form-item>
    <el-form-item label="销售日期" prop="sellDate">
      <el-input v-model="dataForm.sellDate" placeholder="销售日期"></el-input>
    </el-form-item>
    <el-form-item label="销售类型" prop="sellCategory">
      <el-input v-model="dataForm.sellCategory" placeholder="销售类型"></el-input>
    </el-form-item>
    <el-form-item label="客户编号" prop="supplierNo">
      <el-input v-model="dataForm.supplierNo" placeholder="客户编号"></el-input>
    </el-form-item>
    <el-form-item label="客户名称" prop="supplierName">
      <el-input v-model="dataForm.supplierName" placeholder="客户名称"></el-input>
    </el-form-item>
    <el-form-item label="经办人" prop="agent">
      <el-input v-model="dataForm.agent" placeholder="经办人"></el-input>
    </el-form-item>
    <el-form-item label="应付金额" prop="sumPay">
      <el-input v-model="dataForm.sumPay" placeholder="应付金额"></el-input>
    </el-form-item>
    <el-form-item label="已付金额" prop="hasPay">
      <el-input v-model="dataForm.hasPay" placeholder="已付金额"></el-input>
    </el-form-item>
    <el-form-item label="欠收金额" prop="noPay">
      <el-input v-model="dataForm.noPay" placeholder="欠收金额"></el-input>
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
          sellNo: '',
          sellDate: '',
          sellCategory: '',
          supplierNo: '',
          supplierName: '',
          agent: '',
          sumPay: '',
          hasPay: '',
          noPay: '',
          remarks: ''
        },
        dataRule: {
          sellNo: [
            { required: true, message: '销售单号不能为空', trigger: 'blur' }
          ],
          sellDate: [
            { required: true, message: '销售日期不能为空', trigger: 'blur' }
          ],
          sellCategory: [
            { required: true, message: '销售类型不能为空', trigger: 'blur' }
          ],
          supplierNo: [
            { required: true, message: '客户编号不能为空', trigger: 'blur' }
          ],
          supplierName: [
            { required: true, message: '客户名称不能为空', trigger: 'blur' }
          ],
          agent: [
            { required: true, message: '经办人不能为空', trigger: 'blur' }
          ],
          sumPay: [
            { required: true, message: '应付金额不能为空', trigger: 'blur' }
          ],
          hasPay: [
            { required: true, message: '已付金额不能为空', trigger: 'blur' }
          ],
          noPay: [
            { required: true, message: '欠收金额不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/chicken/sell/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.sellNo = data.sell.sellNo
                this.dataForm.sellDate = data.sell.sellDate
                this.dataForm.sellCategory = data.sell.sellCategory
                this.dataForm.supplierNo = data.sell.supplierNo
                this.dataForm.supplierName = data.sell.supplierName
                this.dataForm.agent = data.sell.agent
                this.dataForm.sumPay = data.sell.sumPay
                this.dataForm.hasPay = data.sell.hasPay
                this.dataForm.noPay = data.sell.noPay
                this.dataForm.remarks = data.sell.remarks
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
              url: this.$http.adornUrl(`/chicken/sell/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'sellNo': this.dataForm.sellNo,
                'sellDate': this.dataForm.sellDate,
                'sellCategory': this.dataForm.sellCategory,
                'supplierNo': this.dataForm.supplierNo,
                'supplierName': this.dataForm.supplierName,
                'agent': this.dataForm.agent,
                'sumPay': this.dataForm.sumPay,
                'hasPay': this.dataForm.hasPay,
                'noPay': this.dataForm.noPay,
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
