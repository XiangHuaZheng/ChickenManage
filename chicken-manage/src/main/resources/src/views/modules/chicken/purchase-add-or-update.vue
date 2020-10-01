<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="进鸡日期" prop="enterDate">
      <el-input v-model="dataForm.enterDate" placeholder="进鸡日期"></el-input>
    </el-form-item>
    <el-form-item label="品种" prop="varieties">
      <el-input v-model="dataForm.varieties" placeholder="品种"></el-input>
    </el-form-item>
    <el-form-item label="供商名称" prop="supplierName">
      <el-input v-model="dataForm.supplierName" placeholder="供商名称"></el-input>
    </el-form-item>
    <el-form-item label="鸡舍号" prop="chickenNo">
      <el-input v-model="dataForm.chickenNo" placeholder="鸡舍号"></el-input>
    </el-form-item>
    <el-form-item label="存储量" prop="storeNum">
      <el-input v-model="dataForm.storeNum" placeholder="存储量"></el-input>
    </el-form-item>
    <el-form-item label="类别" prop="category">
      <el-input v-model="dataForm.category" placeholder="类别"></el-input>
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
          batchNo: 0,
          enterDate: '',
          varieties: '',
          supplierName: '',
          chickenNo: '',
          storeNum: '',
          category: '',
          remarks: ''
        },
        dataRule: {
          enterDate: [
            { required: true, message: '进鸡日期不能为空', trigger: 'blur' }
          ],
          varieties: [
            { required: true, message: '品种不能为空', trigger: 'blur' }
          ],
          supplierName: [
            { required: true, message: '供商名称不能为空', trigger: 'blur' }
          ],
          chickenNo: [
            { required: true, message: '鸡舍号不能为空', trigger: 'blur' }
          ],
          storeNum: [
            { required: true, message: '存储量不能为空', trigger: 'blur' }
          ],
          category: [
            { required: true, message: '类别不能为空', trigger: 'blur' }
          ],
          remarks: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.batchNo = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.batchNo) {
            this.$http({
              url: this.$http.adornUrl(`/chicken/purchase/info/${this.dataForm.batchNo}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterDate = data.purchase.enterDate
                this.dataForm.varieties = data.purchase.varieties
                this.dataForm.supplierName = data.purchase.supplierName
                this.dataForm.chickenNo = data.purchase.chickenNo
                this.dataForm.storeNum = data.purchase.storeNum
                this.dataForm.category = data.purchase.category
                this.dataForm.remarks = data.purchase.remarks
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
              url: this.$http.adornUrl(`/chicken/purchase/${!this.dataForm.batchNo ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'batchNo': this.dataForm.batchNo || undefined,
                'enterDate': this.dataForm.enterDate,
                'varieties': this.dataForm.varieties,
                'supplierName': this.dataForm.supplierName,
                'chickenNo': this.dataForm.chickenNo,
                'storeNum': this.dataForm.storeNum,
                'category': this.dataForm.category,
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
