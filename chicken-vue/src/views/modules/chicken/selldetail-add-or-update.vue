<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="销售单号" prop="outNo">
      <el-input v-model="dataForm.outNo" placeholder="销售单号"></el-input>
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
          id: 0,
          outNo: '',
          chickenNo: '',
          category: '',
          sellNum: '',
          sellSum: '',
          eggsPrice: '',
          price: ''
        },
        dataRule: {
          outNo: [
            { required: true, message: '销售单号不能为空', trigger: 'blur' }
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
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/chicken/selldetail/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.outNo = data.selldetail.outNo
                this.dataForm.chickenNo = data.selldetail.chickenNo
                this.dataForm.category = data.selldetail.category
                this.dataForm.sellNum = data.selldetail.sellNum
                this.dataForm.sellSum = data.selldetail.sellSum
                this.dataForm.eggsPrice = data.selldetail.eggsPrice
                this.dataForm.price = data.selldetail.price
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
              url: this.$http.adornUrl(`/chicken/selldetail/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'outNo': this.dataForm.outNo,
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
