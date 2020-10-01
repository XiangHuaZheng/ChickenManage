<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="编号" prop="drugsNo">
      <el-input v-model="dataForm.drugsNo" placeholder="编号"></el-input>
    </el-form-item>
    <el-form-item label="名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="名称"></el-input>
    </el-form-item>
    <el-form-item label="类别" prop="category">
      <el-input v-model="dataForm.category" placeholder="类别"></el-input>
    </el-form-item>
    <el-form-item label="规格" prop="specifications">
      <el-input v-model="dataForm.specifications" placeholder="规格"></el-input>
    </el-form-item>
    <el-form-item label="计量单位" prop="unit">
      <el-input v-model="dataForm.unit" placeholder="计量单位"></el-input>
    </el-form-item>
    <el-form-item label="单价" prop="unitPrice">
      <el-input v-model="dataForm.unitPrice" placeholder="单价"></el-input>
    </el-form-item>
    <el-form-item label="批准文号" prop="approvalNumber">
      <el-input v-model="dataForm.approvalNumber" placeholder="批准文号"></el-input>
    </el-form-item>
    <el-form-item label="用法用量" prop="usageDosage">
      <el-input v-model="dataForm.usageDosage" placeholder="用法用量"></el-input>
    </el-form-item>
    <el-form-item label="主要用途" prop="mainUse">
      <el-input v-model="dataForm.mainUse" placeholder="主要用途"></el-input>
    </el-form-item>
    <el-form-item label="生产厂家" prop="manufacturer">
      <el-input v-model="dataForm.manufacturer" placeholder="生产厂家"></el-input>
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
          drugsNo: '',
          name: '',
          category: '',
          specifications: '',
          unit: '',
          unitPrice: '',
          approvalNumber: '',
          usageDosage: '',
          mainUse: '',
          manufacturer: '',
          remarks: ''
        },
        dataRule: {
          drugsNo: [
            { required: true, message: '编号不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '名称不能为空', trigger: 'blur' }
          ],
          category: [
            { required: true, message: '类别不能为空', trigger: 'blur' }
          ],
          specifications: [
            { required: true, message: '规格不能为空', trigger: 'blur' }
          ],
          unit: [
            { required: true, message: '计量单位不能为空', trigger: 'blur' }
          ],
          unitPrice: [
            { required: true, message: '单价不能为空', trigger: 'blur' }
          ],
          approvalNumber: [
            { required: true, message: '批准文号不能为空', trigger: 'blur' }
          ],
          usageDosage: [
            { required: true, message: '用法用量不能为空', trigger: 'blur' }
          ],
          mainUse: [
            { required: true, message: '主要用途不能为空', trigger: 'blur' }
          ],
          manufacturer: [
            { required: true, message: '生产厂家不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/chicken/drugs/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.drugsNo = data.drugs.drugsNo
                this.dataForm.name = data.drugs.name
                this.dataForm.category = data.drugs.category
                this.dataForm.specifications = data.drugs.specifications
                this.dataForm.unit = data.drugs.unit
                this.dataForm.unitPrice = data.drugs.unitPrice
                this.dataForm.approvalNumber = data.drugs.approvalNumber
                this.dataForm.usageDosage = data.drugs.usageDosage
                this.dataForm.mainUse = data.drugs.mainUse
                this.dataForm.manufacturer = data.drugs.manufacturer
                this.dataForm.remarks = data.drugs.remarks
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
              url: this.$http.adornUrl(`/chicken/drugs/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'drugsNo': this.dataForm.drugsNo,
                'name': this.dataForm.name,
                'category': this.dataForm.category,
                'specifications': this.dataForm.specifications,
                'unit': this.dataForm.unit,
                'unitPrice': this.dataForm.unitPrice,
                'approvalNumber': this.dataForm.approvalNumber,
                'usageDosage': this.dataForm.usageDosage,
                'mainUse': this.dataForm.mainUse,
                'manufacturer': this.dataForm.manufacturer,
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
