<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="客户编号" prop="customerNo">
      <el-input v-model="dataForm.customerNo" placeholder="客户编号"></el-input>
    </el-form-item>
    <el-form-item label="客户名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="客户名称"></el-input>
    </el-form-item>
    <el-form-item label="类别" prop="category">
      <el-input v-model="dataForm.category" placeholder="类别"></el-input>
    </el-form-item>
    <el-form-item label="联系人" prop="contacts">
      <el-input v-model="dataForm.contacts" placeholder="联系人"></el-input>
    </el-form-item>
    <el-form-item label="联系电话" prop="phone">
      <el-input v-model="dataForm.phone" placeholder="联系电话"></el-input>
    </el-form-item>
    <el-form-item label="传真" prop="fax">
      <el-input v-model="dataForm.fax" placeholder="传真"></el-input>
    </el-form-item>
    <el-form-item label="开户银行" prop="bank">
      <el-input v-model="dataForm.bank" placeholder="开户银行"></el-input>
    </el-form-item>
    <el-form-item label="银行账户" prop="account">
      <el-input v-model="dataForm.account" placeholder="银行账户"></el-input>
    </el-form-item>
    <el-form-item label="地址" prop="address">
      <el-input v-model="dataForm.address" placeholder="地址"></el-input>
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
          customerNo: '',
          name: '',
          category: '',
          contacts: '',
          phone: '',
          fax: '',
          bank: '',
          account: '',
          address: '',
          remarks: ''
        },
        dataRule: {
          customerNo: [
            { required: true, message: '客户编号不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '客户名称不能为空', trigger: 'blur' }
          ],
          category: [
            { required: true, message: '类别不能为空', trigger: 'blur' }
          ],
          contacts: [
            { required: true, message: '联系人不能为空', trigger: 'blur' }
          ],
          phone: [
            { required: true, message: '联系电话不能为空', trigger: 'blur' }
          ],
          fax: [
            { required: true, message: '传真不能为空', trigger: 'blur' }
          ],
          bank: [
            { required: true, message: '开户银行不能为空', trigger: 'blur' }
          ],
          account: [
            { required: true, message: '银行账户不能为空', trigger: 'blur' }
          ],
          address: [
            { required: true, message: '地址不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/chicken/customer/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.customerNo = data.customer.customerNo
                this.dataForm.name = data.customer.name
                this.dataForm.category = data.customer.category
                this.dataForm.contacts = data.customer.contacts
                this.dataForm.phone = data.customer.phone
                this.dataForm.fax = data.customer.fax
                this.dataForm.bank = data.customer.bank
                this.dataForm.account = data.customer.account
                this.dataForm.address = data.customer.address
                this.dataForm.remarks = data.customer.remarks
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
              url: this.$http.adornUrl(`/chicken/customer/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'customerNo': this.dataForm.customerNo,
                'name': this.dataForm.name,
                'category': this.dataForm.category,
                'contacts': this.dataForm.contacts,
                'phone': this.dataForm.phone,
                'fax': this.dataForm.fax,
                'bank': this.dataForm.bank,
                'account': this.dataForm.account,
                'address': this.dataForm.address,
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
