<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="配方信息" prop="formulaNo">
      <el-input v-model="dataForm.formulaNo" placeholder="配方信息"></el-input>
    </el-form-item>
    <el-form-item label="原料编号" prop="materialNo">
      <el-input v-model="dataForm.materialNo" placeholder="原料编号"></el-input>
    </el-form-item>
    <el-form-item label="原料名称" prop="materialName">
      <el-input v-model="dataForm.materialName" placeholder="原料名称"></el-input>
    </el-form-item>
    <el-form-item label="配料量" prop="materialNum">
      <el-input v-model="dataForm.materialNum" placeholder="配料量"></el-input>
    </el-form-item>
    <el-form-item label="计量单位" prop="unit">
      <el-input v-model="dataForm.unit" placeholder="计量单位"></el-input>
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
          id: 0,
          formulaNo: '',
          materialNo: '',
          materialName: '',
          materialNum: '',
          unit: '',
          unitPrice: '',
          price: ''
        },
        dataRule: {
          formulaNo: [
            { required: true, message: '配方信息不能为空', trigger: 'blur' }
          ],
          materialNo: [
            { required: true, message: '原料编号不能为空', trigger: 'blur' }
          ],
          materialName: [
            { required: true, message: '原料名称不能为空', trigger: 'blur' }
          ],
          materialNum: [
            { required: true, message: '配料量不能为空', trigger: 'blur' }
          ],
          unit: [
            { required: true, message: '计量单位不能为空', trigger: 'blur' }
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
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/chicken/formuladetail/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.formulaNo = data.formuladetail.formulaNo
                this.dataForm.materialNo = data.formuladetail.materialNo
                this.dataForm.materialName = data.formuladetail.materialName
                this.dataForm.materialNum = data.formuladetail.materialNum
                this.dataForm.unit = data.formuladetail.unit
                this.dataForm.unitPrice = data.formuladetail.unitPrice
                this.dataForm.price = data.formuladetail.price
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
              url: this.$http.adornUrl(`/chicken/formuladetail/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'formulaNo': this.dataForm.formulaNo,
                'materialNo': this.dataForm.materialNo,
                'materialName': this.dataForm.materialName,
                'materialNum': this.dataForm.materialNum,
                'unit': this.dataForm.unit,
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
