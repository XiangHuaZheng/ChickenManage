<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="销售日期" prop="sellDate">
      <el-input v-model="dataForm.sellDate" placeholder="销售日期"></el-input>
    </el-form-item>
    <el-form-item label="销售类型" prop="sellCategory">
      <el-input v-model="dataForm.sellCategory" placeholder="销售类型"></el-input>
    </el-form-item>
    <el-form-item label="客户编号" prop="supplierNo">
      <el-input v-model="dataForm.supplierNo" placeholder="客户编号"></el-input>
    </el-form-item>
    <el-form-item label="客户名称" prop="supplierName">
      <el-input v-model="dataForm.supplierName" placeholder="客户名称"></el-input>
    </el-form-item>
    <el-form-item label="鸡舍号" prop="chickenNo">
      <el-input v-model="dataForm.chickenNo" placeholder="鸡舍号"></el-input>
    </el-form-item>
    <el-form-item label="类别" prop="category">
      <el-input v-model="dataForm.category" placeholder="类别"></el-input>
    </el-form-item>
    <el-form-item label="销售数量" prop="sellNum">
      <el-input v-model="dataForm.sellNum" placeholder="销售数量"></el-input>
    </el-form-item>
    <el-form-item label="总重量" prop="sellSum">
      <el-input v-model="dataForm.sellSum" placeholder="总重量"></el-input>
    </el-form-item>
    <el-form-item label="销售单价" prop="eggsPrice">
      <el-input v-model="dataForm.eggsPrice" placeholder="销售单价"></el-input>
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
          sellNo: 0,
          sellDate: '',
          sellCategory: '',
          supplierNo: '',
          supplierName: '',
          chickenNo: '',
          category: '',
          sellNum: '',
          sellSum: '',
          eggsPrice: '',
          price: ''
        },
        dataRule: {
          sellDate: [
            { required: true, message: '销售日期不能为空', trigger: 'blur' }
          ],
          sellCategory: [
            { required: true, message: '销售类型不能为空', trigger: 'blur' }
          ],
          supplierNo: [
            { required: true, message: '客户编号不能为空', trigger: 'blur' }
          ],
          supplierName: [
            { required: true, message: '客户名称不能为空', trigger: 'blur' }
          ],
          chickenNo: [
            { required: true, message: '鸡舍号不能为空', trigger: 'blur' }
          ],
          category: [
            { required: true, message: '类别不能为空', trigger: 'blur' }
          ],
          sellNum: [
            { required: true, message: '销售数量不能为空', trigger: 'blur' }
          ],
          sellSum: [
            { required: true, message: '总重量不能为空', trigger: 'blur' }
          ],
          eggsPrice: [
            { required: true, message: '销售单价不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '金额不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.sellNo = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.sellNo) {
            this.$http({
              url: this.$http.adornUrl(`/chicken/sellsummery/info/${this.dataForm.sellNo}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.sellDate = data.sellsummery.sellDate
                this.dataForm.sellCategory = data.sellsummery.sellCategory
                this.dataForm.supplierNo = data.sellsummery.supplierNo
                this.dataForm.supplierName = data.sellsummery.supplierName
                this.dataForm.chickenNo = data.sellsummery.chickenNo
                this.dataForm.category = data.sellsummery.category
                this.dataForm.sellNum = data.sellsummery.sellNum
                this.dataForm.sellSum = data.sellsummery.sellSum
                this.dataForm.eggsPrice = data.sellsummery.eggsPrice
                this.dataForm.price = data.sellsummery.price
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
              url: this.$http.adornUrl(`/chicken/sellsummery/${!this.dataForm.sellNo ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'sellNo': this.dataForm.sellNo || undefined,
                'sellDate': this.dataForm.sellDate,
                'sellCategory': this.dataForm.sellCategory,
                'supplierNo': this.dataForm.supplierNo,
                'supplierName': this.dataForm.supplierName,
                'chickenNo': this.dataForm.chickenNo,
                'category': this.dataForm.category,
                'sellNum': this.dataForm.sellNum,
                'sellSum': this.dataForm.sellSum,
                'eggsPrice': this.dataForm.eggsPrice,
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
