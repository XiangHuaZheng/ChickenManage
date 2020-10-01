<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="销售单号" prop="outNo">
      <el-input v-model="dataForm.outNo" placeholder="销售单号"></el-input>
    </el-form-item>
    <el-form-item label="销售日期" prop="outDate">
      <el-input v-model="dataForm.outDate" placeholder="销售日期"></el-input>
    </el-form-item>
    <el-form-item label="销售类型" prop="outCategory">
      <el-input v-model="dataForm.outCategory" placeholder="销售类型"></el-input>
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
    <el-form-item label="鸡舍号" prop="chickenNo">
      <el-input v-model="dataForm.chickenNo" placeholder="鸡舍号"></el-input>
    </el-form-item>
    <el-form-item label="种类" prop="category">
      <el-input v-model="dataForm.category" placeholder="种类"></el-input>
    </el-form-item>
    <el-form-item label="销售数量" prop="sellNum">
      <el-input v-model="dataForm.sellNum" placeholder="销售数量"></el-input>
    </el-form-item>
    <el-form-item label="单价" prop="eggsPrice">
      <el-input v-model="dataForm.eggsPrice" placeholder="单价"></el-input>
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
          outNo: '',
          outDate: '',
          outCategory: '',
          supplierNo: '',
          supplierName: '',
          agent: '',
          chickenNo: '',
          category: '',
          sellNum: '',
          eggsPrice: '',
          sumPay: '',
          hasPay: '',
          noPay: '',
          remarks: ''
        },
        dataRule: {
          outNo: [
            { required: true, message: '销售单号不能为空', trigger: 'blur' }
          ],
          outDate: [
            { required: true, message: '销售日期不能为空', trigger: 'blur' }
          ],
          outCategory: [
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
          chickenNo: [
            { required: true, message: '鸡舍号不能为空', trigger: 'blur' }
          ],
          category: [
            { required: true, message: '种类不能为空', trigger: 'blur' }
          ],
          sellNum: [
            { required: true, message: '销售数量不能为空', trigger: 'blur' }
          ],
          eggsPrice: [
            { required: true, message: '单价不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/chicken/eggsout/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.outNo = data.eggsout.outNo
                this.dataForm.outDate = data.eggsout.outDate
                this.dataForm.outCategory = data.eggsout.outCategory
                this.dataForm.supplierNo = data.eggsout.supplierNo
                this.dataForm.supplierName = data.eggsout.supplierName
                this.dataForm.agent = data.eggsout.agent
                this.dataForm.chickenNo = data.eggsout.chickenNo
                this.dataForm.category = data.eggsout.category
                this.dataForm.sellNum = data.eggsout.sellNum
                this.dataForm.eggsPrice = data.eggsout.eggsPrice
                this.dataForm.sumPay = data.eggsout.sumPay
                this.dataForm.hasPay = data.eggsout.hasPay
                this.dataForm.noPay = data.eggsout.noPay
                this.dataForm.remarks = data.eggsout.remarks
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
              url: this.$http.adornUrl(`/chicken/eggsout/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'outNo': this.dataForm.outNo,
                'outDate': this.dataForm.outDate,
                'outCategory': this.dataForm.outCategory,
                'supplierNo': this.dataForm.supplierNo,
                'supplierName': this.dataForm.supplierName,
                'agent': this.dataForm.agent,
                'chickenNo': this.dataForm.chickenNo,
                'category': this.dataForm.category,
                'sellNum': this.dataForm.sellNum,
                'eggsPrice': this.dataForm.eggsPrice,
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
