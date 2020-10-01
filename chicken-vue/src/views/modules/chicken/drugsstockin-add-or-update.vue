<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="入库单号" prop="inNo">
      <el-input v-model="dataForm.inNo" placeholder="入库单号"></el-input>
    </el-form-item>
    <el-form-item label="入库类型" prop="inCategory">
      <el-input v-model="dataForm.inCategory" placeholder="入库类型"></el-input>
    </el-form-item>
    <el-form-item label="供商名称" prop="supplierName">
      <el-input v-model="dataForm.supplierName" placeholder="供商名称"></el-input>
    </el-form-item>
    <el-form-item label="编号" prop="stockInNo">
      <el-input v-model="dataForm.stockInNo" placeholder="编号"></el-input>
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
    <el-form-item label="单位" prop="unit">
      <el-input v-model="dataForm.unit" placeholder="单位"></el-input>
    </el-form-item>
    <el-form-item label="数量" prop="unitNum">
      <el-input v-model="dataForm.unitNum" placeholder="数量"></el-input>
    </el-form-item>
    <el-form-item label="单价" prop="unitPrice">
      <el-input v-model="dataForm.unitPrice" placeholder="单价"></el-input>
    </el-form-item>
    <el-form-item label="金额" prop="price">
      <el-input v-model="dataForm.price" placeholder="金额"></el-input>
    </el-form-item>
    <el-form-item label="失效日期" prop="expirationDate">
      <el-input v-model="dataForm.expirationDate" placeholder="失效日期"></el-input>
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
          inDate: 0,
          inNo: '',
          inCategory: '',
          supplierName: '',
          stockInNo: '',
          name: '',
          category: '',
          specifications: '',
          unit: '',
          unitNum: '',
          unitPrice: '',
          price: '',
          expirationDate: '',
          remarks: ''
        },
        dataRule: {
          inNo: [
            { required: true, message: '入库单号不能为空', trigger: 'blur' }
          ],
          inCategory: [
            { required: true, message: '入库类型不能为空', trigger: 'blur' }
          ],
          supplierName: [
            { required: true, message: '供商名称不能为空', trigger: 'blur' }
          ],
          stockInNo: [
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
            { required: true, message: '单位不能为空', trigger: 'blur' }
          ],
          unitNum: [
            { required: true, message: '数量不能为空', trigger: 'blur' }
          ],
          unitPrice: [
            { required: true, message: '单价不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '金额不能为空', trigger: 'blur' }
          ],
          expirationDate: [
            { required: true, message: '失效日期不能为空', trigger: 'blur' }
          ],
          remarks: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.inDate = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.inDate) {
            this.$http({
              url: this.$http.adornUrl(`/chicken/drugsstockin/info/${this.dataForm.inDate}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.inNo = data.drugsstockin.inNo
                this.dataForm.inCategory = data.drugsstockin.inCategory
                this.dataForm.supplierName = data.drugsstockin.supplierName
                this.dataForm.stockInNo = data.drugsstockin.stockInNo
                this.dataForm.name = data.drugsstockin.name
                this.dataForm.category = data.drugsstockin.category
                this.dataForm.specifications = data.drugsstockin.specifications
                this.dataForm.unit = data.drugsstockin.unit
                this.dataForm.unitNum = data.drugsstockin.unitNum
                this.dataForm.unitPrice = data.drugsstockin.unitPrice
                this.dataForm.price = data.drugsstockin.price
                this.dataForm.expirationDate = data.drugsstockin.expirationDate
                this.dataForm.remarks = data.drugsstockin.remarks
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
              url: this.$http.adornUrl(`/chicken/drugsstockin/${!this.dataForm.inDate ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'inDate': this.dataForm.inDate || undefined,
                'inNo': this.dataForm.inNo,
                'inCategory': this.dataForm.inCategory,
                'supplierName': this.dataForm.supplierName,
                'stockInNo': this.dataForm.stockInNo,
                'name': this.dataForm.name,
                'category': this.dataForm.category,
                'specifications': this.dataForm.specifications,
                'unit': this.dataForm.unit,
                'unitNum': this.dataForm.unitNum,
                'unitPrice': this.dataForm.unitPrice,
                'price': this.dataForm.price,
                'expirationDate': this.dataForm.expirationDate,
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
