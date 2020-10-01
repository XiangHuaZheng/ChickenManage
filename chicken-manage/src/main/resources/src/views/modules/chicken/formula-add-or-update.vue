<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="配方编号" prop="formulaNo">
      <el-input v-model="dataForm.formulaNo" placeholder="配方编号"></el-input>
    </el-form-item>
    <el-form-item label="配方名称" prop="name">
      <el-input v-model="dataForm.name" placeholder="配方名称"></el-input>
    </el-form-item>
    <el-form-item label="类别" prop="category">
      <el-input v-model="dataForm.category" placeholder="类别"></el-input>
    </el-form-item>
    <el-form-item label="配置规格" prop="specifications">
      <el-input v-model="dataForm.specifications" placeholder="配置规格"></el-input>
    </el-form-item>
    <el-form-item label="总金额" prop="sumPay">
      <el-input v-model="dataForm.sumPay" placeholder="总金额"></el-input>
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
          formulaNo: '',
          name: '',
          category: '',
          specifications: '',
          sumPay: '',
          remarks: ''
        },
        dataRule: {
          formulaNo: [
            { required: true, message: '配方编号不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '配方名称不能为空', trigger: 'blur' }
          ],
          category: [
            { required: true, message: '类别不能为空', trigger: 'blur' }
          ],
          specifications: [
            { required: true, message: '配置规格不能为空', trigger: 'blur' }
          ],
          sumPay: [
            { required: true, message: '总金额不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/chicken/formula/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.formulaNo = data.formula.formulaNo
                this.dataForm.name = data.formula.name
                this.dataForm.category = data.formula.category
                this.dataForm.specifications = data.formula.specifications
                this.dataForm.sumPay = data.formula.sumPay
                this.dataForm.remarks = data.formula.remarks
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
              url: this.$http.adornUrl(`/chicken/formula/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'formulaNo': this.dataForm.formulaNo,
                'name': this.dataForm.name,
                'category': this.dataForm.category,
                'specifications': this.dataForm.specifications,
                'sumPay': this.dataForm.sumPay,
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
