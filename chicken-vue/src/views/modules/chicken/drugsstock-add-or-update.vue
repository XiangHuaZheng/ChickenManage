<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="名称"></el-input>
    </el-form-item>
    <el-form-item label="类别" prop="category">
      <el-input v-model="dataForm.category" placeholder="类别"></el-input>
    </el-form-item>
    <el-form-item label="规格" prop="specifications">
      <el-input v-model="dataForm.specifications" placeholder="规格"></el-input>
    </el-form-item>
    <el-form-item label="单价" prop="unitPrice">
      <el-input v-model="dataForm.unitPrice" placeholder="单价"></el-input>
    </el-form-item>
    <el-form-item label="计量单位" prop="unit">
      <el-input v-model="dataForm.unit" placeholder="计量单位"></el-input>
    </el-form-item>
    <el-form-item label="当前库存" prop="stockNum">
      <el-input v-model="dataForm.stockNum" placeholder="当前库存"></el-input>
    </el-form-item>
    <el-form-item label="累计入库" prop="stockIn">
      <el-input v-model="dataForm.stockIn" placeholder="累计入库"></el-input>
    </el-form-item>
    <el-form-item label="累计出库" prop="stockOut">
      <el-input v-model="dataForm.stockOut" placeholder="累计出库"></el-input>
    </el-form-item>
    <el-form-item label="批准文号" prop="approvalNumber">
      <el-input v-model="dataForm.approvalNumber" placeholder="批准文号"></el-input>
    </el-form-item>
    <el-form-item label="生产厂家" prop="manufacturer">
      <el-input v-model="dataForm.manufacturer" placeholder="生产厂家"></el-input>
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
          name: '',
          category: '',
          specifications: '',
          unitPrice: '',
          unit: '',
          stockNum: '',
          stockIn: '',
          stockOut: '',
          approvalNumber: '',
          manufacturer: ''
        },
        dataRule: {
          name: [
            { required: true, message: '名称不能为空', trigger: 'blur' }
          ],
          category: [
            { required: true, message: '类别不能为空', trigger: 'blur' }
          ],
          specifications: [
            { required: true, message: '规格不能为空', trigger: 'blur' }
          ],
          unitPrice: [
            { required: true, message: '单价不能为空', trigger: 'blur' }
          ],
          unit: [
            { required: true, message: '计量单位不能为空', trigger: 'blur' }
          ],
          stockNum: [
            { required: true, message: '当前库存不能为空', trigger: 'blur' }
          ],
          stockIn: [
            { required: true, message: '累计入库不能为空', trigger: 'blur' }
          ],
          stockOut: [
            { required: true, message: '累计出库不能为空', trigger: 'blur' }
          ],
          approvalNumber: [
            { required: true, message: '批准文号不能为空', trigger: 'blur' }
          ],
          manufacturer: [
            { required: true, message: '生产厂家不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/chicken/drugsstock/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.drugsstock.name
                this.dataForm.category = data.drugsstock.category
                this.dataForm.specifications = data.drugsstock.specifications
                this.dataForm.unitPrice = data.drugsstock.unitPrice
                this.dataForm.unit = data.drugsstock.unit
                this.dataForm.stockNum = data.drugsstock.stockNum
                this.dataForm.stockIn = data.drugsstock.stockIn
                this.dataForm.stockOut = data.drugsstock.stockOut
                this.dataForm.approvalNumber = data.drugsstock.approvalNumber
                this.dataForm.manufacturer = data.drugsstock.manufacturer
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
              url: this.$http.adornUrl(`/chicken/drugsstock/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'category': this.dataForm.category,
                'specifications': this.dataForm.specifications,
                'unitPrice': this.dataForm.unitPrice,
                'unit': this.dataForm.unit,
                'stockNum': this.dataForm.stockNum,
                'stockIn': this.dataForm.stockIn,
                'stockOut': this.dataForm.stockOut,
                'approvalNumber': this.dataForm.approvalNumber,
                'manufacturer': this.dataForm.manufacturer
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
