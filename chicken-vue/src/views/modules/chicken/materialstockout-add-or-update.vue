<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="出库单号" prop="outNo">
      <el-input v-model="dataForm.outNo" placeholder="出库单号"></el-input>
    </el-form-item>
    <el-form-item label="出库类型" prop="outCategory">
      <el-input v-model="dataForm.outCategory" placeholder="出库类型"></el-input>
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
          outDate: 0,
          outNo: '',
          outCategory: '',
          supplierName: '',
          stockInNo: '',
          name: '',
          category: '',
          specifications: '',
          unit: '',
          unitNum: '',
          unitPrice: '',
          price: ''
        },
        dataRule: {
          outNo: [
            { required: true, message: '出库单号不能为空', trigger: 'blur' }
          ],
          outCategory: [
            { required: true, message: '出库类型不能为空', trigger: 'blur' }
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
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.outDate = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.outDate) {
            this.$http({
              url: this.$http.adornUrl(`/chicken/materialstockout/info/${this.dataForm.outDate}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.outNo = data.materialstockout.outNo
                this.dataForm.outCategory = data.materialstockout.outCategory
                this.dataForm.supplierName = data.materialstockout.supplierName
                this.dataForm.stockInNo = data.materialstockout.stockInNo
                this.dataForm.name = data.materialstockout.name
                this.dataForm.category = data.materialstockout.category
                this.dataForm.specifications = data.materialstockout.specifications
                this.dataForm.unit = data.materialstockout.unit
                this.dataForm.unitNum = data.materialstockout.unitNum
                this.dataForm.unitPrice = data.materialstockout.unitPrice
                this.dataForm.price = data.materialstockout.price
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
              url: this.$http.adornUrl(`/chicken/materialstockout/${!this.dataForm.outDate ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'outDate': this.dataForm.outDate || undefined,
                'outNo': this.dataForm.outNo,
                'outCategory': this.dataForm.outCategory,
                'supplierName': this.dataForm.supplierName,
                'stockInNo': this.dataForm.stockInNo,
                'name': this.dataForm.name,
                'category': this.dataForm.category,
                'specifications': this.dataForm.specifications,
                'unit': this.dataForm.unit,
                'unitNum': this.dataForm.unitNum,
                'unitPrice': this.dataForm.unitPrice,
                'price': this.dataForm.price
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
