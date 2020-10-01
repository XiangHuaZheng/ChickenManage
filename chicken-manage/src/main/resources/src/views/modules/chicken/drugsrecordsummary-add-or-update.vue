<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="鸡舍名称" prop="chickenName">
      <el-input v-model="dataForm.chickenName" placeholder="鸡舍名称"></el-input>
    </el-form-item>
    <el-form-item label="类别" prop="category">
      <el-input v-model="dataForm.category" placeholder="类别"></el-input>
    </el-form-item>
    <el-form-item label="日期" prop="dailyDate">
      <el-input v-model="dataForm.dailyDate" placeholder="日期"></el-input>
    </el-form-item>
    <el-form-item label="饲料名称" prop="feedsName">
      <el-input v-model="dataForm.feedsName" placeholder="饲料名称"></el-input>
    </el-form-item>
    <el-form-item label="编号" prop="raiseNo">
      <el-input v-model="dataForm.raiseNo" placeholder="编号"></el-input>
    </el-form-item>
    <el-form-item label="规格" prop="specifications">
      <el-input v-model="dataForm.specifications" placeholder="规格"></el-input>
    </el-form-item>
    <el-form-item label="用药量" prop="drugNum">
      <el-input v-model="dataForm.drugNum" placeholder="用药量"></el-input>
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
    <el-form-item label="饲养员" prop="breeder">
      <el-input v-model="dataForm.breeder" placeholder="饲养员"></el-input>
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
          chickenName: '',
          category: '',
          dailyDate: '',
          feedsName: '',
          raiseNo: '',
          specifications: '',
          drugNum: '',
          unit: '',
          unitPrice: '',
          price: '',
          breeder: '',
          remarks: ''
        },
        dataRule: {
          chickenName: [
            { required: true, message: '鸡舍名称不能为空', trigger: 'blur' }
          ],
          category: [
            { required: true, message: '类别不能为空', trigger: 'blur' }
          ],
          dailyDate: [
            { required: true, message: '日期不能为空', trigger: 'blur' }
          ],
          feedsName: [
            { required: true, message: '饲料名称不能为空', trigger: 'blur' }
          ],
          raiseNo: [
            { required: true, message: '编号不能为空', trigger: 'blur' }
          ],
          specifications: [
            { required: true, message: '规格不能为空', trigger: 'blur' }
          ],
          drugNum: [
            { required: true, message: '用药量不能为空', trigger: 'blur' }
          ],
          unit: [
            { required: true, message: '计量单位不能为空', trigger: 'blur' }
          ],
          unitPrice: [
            { required: true, message: '单价不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '金额不能为空', trigger: 'blur' }
          ],
          breeder: [
            { required: true, message: '饲养员不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/chicken/drugsrecordsummary/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.chickenName = data.drugsrecordsummary.chickenName
                this.dataForm.category = data.drugsrecordsummary.category
                this.dataForm.dailyDate = data.drugsrecordsummary.dailyDate
                this.dataForm.feedsName = data.drugsrecordsummary.feedsName
                this.dataForm.raiseNo = data.drugsrecordsummary.raiseNo
                this.dataForm.specifications = data.drugsrecordsummary.specifications
                this.dataForm.drugNum = data.drugsrecordsummary.drugNum
                this.dataForm.unit = data.drugsrecordsummary.unit
                this.dataForm.unitPrice = data.drugsrecordsummary.unitPrice
                this.dataForm.price = data.drugsrecordsummary.price
                this.dataForm.breeder = data.drugsrecordsummary.breeder
                this.dataForm.remarks = data.drugsrecordsummary.remarks
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
              url: this.$http.adornUrl(`/chicken/drugsrecordsummary/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'chickenName': this.dataForm.chickenName,
                'category': this.dataForm.category,
                'dailyDate': this.dataForm.dailyDate,
                'feedsName': this.dataForm.feedsName,
                'raiseNo': this.dataForm.raiseNo,
                'specifications': this.dataForm.specifications,
                'drugNum': this.dataForm.drugNum,
                'unit': this.dataForm.unit,
                'unitPrice': this.dataForm.unitPrice,
                'price': this.dataForm.price,
                'breeder': this.dataForm.breeder,
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
