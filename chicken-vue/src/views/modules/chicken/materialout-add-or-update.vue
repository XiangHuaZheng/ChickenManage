<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="出库单号" prop="outNo">
      <el-input v-model="dataForm.outNo" placeholder="出库单号"></el-input>
    </el-form-item>
    <el-form-item label="出库日期" prop="outDate">
      <el-input v-model="dataForm.outDate" placeholder="出库日期"></el-input>
    </el-form-item>
    <el-form-item label="出库类型" prop="outCategory">
      <el-input v-model="dataForm.outCategory" placeholder="出库类型"></el-input>
    </el-form-item>
    <el-form-item label="供商编号" prop="supplierNo">
      <el-input v-model="dataForm.supplierNo" placeholder="供商编号"></el-input>
    </el-form-item>
    <el-form-item label="供商名称" prop="supplierName">
      <el-input v-model="dataForm.supplierName" placeholder="供商名称"></el-input>
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
    <el-form-item label="未付金额" prop="noPay">
      <el-input v-model="dataForm.noPay" placeholder="未付金额"></el-input>
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
          outNo: '',
          outDate: '',
          outCategory: '',
          supplierNo: '',
          supplierName: '',
          agent: '',
          sumPay: '',
          hasPay: '',
          noPay: '',
          remarks: ''
        },
        dataRule: {
          outNo: [
            { required: true, message: '出库单号不能为空', trigger: 'blur' }
          ],
          outDate: [
            { required: true, message: '出库日期不能为空', trigger: 'blur' }
          ],
          outCategory: [
            { required: true, message: '出库类型不能为空', trigger: 'blur' }
          ],
          supplierNo: [
            { required: true, message: '供商编号不能为空', trigger: 'blur' }
          ],
          supplierName: [
            { required: true, message: '供商名称不能为空', trigger: 'blur' }
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
            { required: true, message: '未付金额不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/chicken/materialout/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.outNo = data.materialout.outNo
                this.dataForm.outDate = data.materialout.outDate
                this.dataForm.outCategory = data.materialout.outCategory
                this.dataForm.supplierNo = data.materialout.supplierNo
                this.dataForm.supplierName = data.materialout.supplierName
                this.dataForm.agent = data.materialout.agent
                this.dataForm.sumPay = data.materialout.sumPay
                this.dataForm.hasPay = data.materialout.hasPay
                this.dataForm.noPay = data.materialout.noPay
                this.dataForm.remarks = data.materialout.remarks
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
              url: this.$http.adornUrl(`/chicken/materialout/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'outNo': this.dataForm.outNo,
                'outDate': this.dataForm.outDate,
                'outCategory': this.dataForm.outCategory,
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
