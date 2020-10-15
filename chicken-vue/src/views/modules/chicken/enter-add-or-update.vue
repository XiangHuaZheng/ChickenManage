<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="批次号" prop="batchNo">
      <el-input v-model="dataForm.batchNo" placeholder="批次号"></el-input>
    </el-form-item>
    <el-form-item label="进鸡日期" prop="enterDate">
      <el-input v-model="dataForm.enterDate" placeholder="进鸡日期"></el-input>
    </el-form-item>
    <el-form-item label="供商编号" prop="supplierNo">
      <el-input v-model="dataForm.supplierNo" placeholder="供商编号"></el-input>
    </el-form-item>
    <el-form-item label="供商名称" prop="supplierName">
      <el-input v-model="dataForm.supplierName" placeholder="供商名称"></el-input>
    </el-form-item>
    <el-form-item label="品种" prop="varieties">
      <el-input v-model="dataForm.varieties" placeholder="品种"></el-input>
    </el-form-item>
    <el-form-item label="数量" prop="num">
      <el-input v-model="dataForm.num" placeholder="数量"></el-input>
    </el-form-item>
    <el-form-item label="单价" prop="price">
      <el-input v-model="dataForm.price" placeholder="单价"></el-input>
    </el-form-item>
    <el-form-item label="应付金额" prop="sumPay">
      <el-input v-model="dataForm.sumPay" placeholder="应付金额"></el-input>
    </el-form-item>
    <el-form-item label="已付金额" prop="hasPay">
      <el-input v-model="dataForm.hasPay" placeholder="已付金额"></el-input>
    </el-form-item>
    <el-form-item label="未付金额" prop="noPay">
      <el-input v-model="dataForm.noPay" placeholder="未付金额"></el-input>
    </el-form-item>
    <el-form-item label="成长天数" prop="growDays">
      <el-input v-model="dataForm.growDays" placeholder="成长天数"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remarks">
      <el-input v-model="dataForm.remarks" placeholder="备注"></el-input>
    </el-form-item>
    明细信息<hr>
    <el-form-item label="鸡舍号" prop="remarks">
      <el-input v-model="dataForm.chickenNo" placeholder="鸡舍号"></el-input>
    </el-form-item>
    <el-form-item label="存储量" prop="remarks">
      <el-input v-model="dataForm.storeNum" placeholder="存储量"></el-input>
    </el-form-item>
    <el-form-item label="类别" prop="remarks">
      <el-input v-model="dataForm.category" placeholder="类别"></el-input>
    </el-form-item>
    <el-form-item label="明细备注" prop="remarks">
      <el-input v-model="dataForm.remarks2" placeholder="明细备注"></el-input>
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
          batchNo: '',
          enterDate: '',
          supplierNo: '',
          supplierName: '',
          varieties: '',
          num: '',
          price: '',
          sumPay: '',
          hasPay: '',
          noPay: '',
          growDays: '',
          remarks: '',
          chickenNo:'',
          storeNum:'',
          category:'',
          remarks2:''
        },
        dataRule: {
          batchNo: [
            { required: true, message: '批次号不能为空', trigger: 'blur' }
          ],
          enterDate: [
            { required: true, message: '进鸡日期不能为空', trigger: 'blur' }
          ],
          supplierNo: [
            { required: true, message: '供商编号不能为空', trigger: 'blur' }
          ],
          supplierName: [
            { required: true, message: '供商名称不能为空', trigger: 'blur' }
          ],
          varieties: [
            { required: true, message: '品种不能为空', trigger: 'blur' }
          ],
          num: [
            { required: true, message: '数量不能为空', trigger: 'blur' }
          ],
          price: [
            { required: true, message: '单价不能为空', trigger: 'blur' }
          ],
          sumPay: [
            { required: true, message: '应付金额不能为空', trigger: 'blur' }
          ],
          hasPay: [
            { required: true, message: '已付金额不能为空', trigger: 'blur' }
          ],
          noPay: [
            { required: true, message: '未付金额不能为空', trigger: 'blur' }
          ],
          growDays: [
            { required: true, message: '成长天数不能为空', trigger: 'blur' }
          ],
          remarks: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          chickenNo: [
            { required: true, message: '鸡舍号不能为空', trigger: 'blur' }
          ],
          storeNum: [
            { required: true, message: '存储量不能为空', trigger: 'blur' }
          ],
          category: [
            { required: true, message: '目录不能为空', trigger: 'blur' }
          ],
          remarks2: [
            { required: true, message: '明细备注不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/chicken/enter/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.batchNo = data.enter.batchNo
                this.dataForm.enterDate = data.enter.enterDate
                this.dataForm.supplierNo = data.enter.supplierNo
                this.dataForm.supplierName = data.enter.supplierName
                this.dataForm.varieties = data.enter.varieties
                this.dataForm.num = data.enter.num
                this.dataForm.price = data.enter.price
                this.dataForm.sumPay = data.enter.sumPay
                this.dataForm.hasPay = data.enter.hasPay
                this.dataForm.noPay = data.enter.noPay
                this.dataForm.growDays = data.enter.growDays
                this.dataForm.remarks = data.enter.remarks
                this.dataForm.chickenNo=data.enter.chickenNo
                this.dataForm.storeNum=data.enter.storeNum
                this.dataForm.category=data.enter.category
                this.dataForm.remarks2=data.enter.remarks2
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
              url: this.$http.adornUrl(`/chicken/enter/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'batchNo': this.dataForm.batchNo,
                'enterDate': this.dataForm.enterDate,
                'supplierNo': this.dataForm.supplierNo,
                'supplierName': this.dataForm.supplierName,
                'varieties': this.dataForm.varieties,
                'num': this.dataForm.num,
                'price': this.dataForm.price,
                'sumPay': this.dataForm.sumPay,
                'hasPay': this.dataForm.hasPay,
                'noPay': this.dataForm.noPay,
                'growDays': this.dataForm.growDays,
                'remarks': this.dataForm.remarks,
                'chickenNo': this.dataForm.chickenNo,
                'storeNum': this.dataForm.storeNum,
                'category': this.dataForm.category,
                'remarks2': this.dataForm.remarks2,
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
