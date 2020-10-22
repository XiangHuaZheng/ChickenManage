<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="入库单号" prop="enterNo">
      <el-input v-model="dataForm.enterNo" placeholder="入库单号"></el-input>
    </el-form-item>
    <el-form-item label="入库日期" prop="enterDate">
      <el-input v-model="dataForm.enterDate" placeholder="入库日期"></el-input>
    </el-form-item>
    <el-form-item label="入库类型" prop="enterCategory">
      <el-input v-model="dataForm.enterCategory" placeholder="入库类型"></el-input>
    </el-form-item>
    <el-form-item label="供商编号" prop="supplierNo">
      <el-input v-model="dataForm.supplierNo" placeholder="供商编号"></el-input>
    </el-form-item>
    <el-form-item label="供商名称" prop="supplierName">
      <el-input v-model="dataForm.supplierName" placeholder="供商名称"></el-input>
    </el-form-item>
    <el-form-item label="经办人" prop="agent">
      <el-input v-model="dataForm.agent" placeholder="经办人"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remarks">
      <el-input v-model="dataForm.remarks" placeholder="备注"></el-input>
    </el-form-item>
    明细信息<hr>
    <el-form-item label="编号" prop="detailNo">
      <el-input v-model="dataForm.detailNo" placeholder="编号"></el-input>
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
          enterNo: '',
          enterDate: '',
          enterCategory: '',
          supplierNo: '',
          supplierName: '',
          agent: '',
          remarks: '',
          detailNo:'',
          name:'',
          category:'',
          specifications:'',
          unit:'',
          unitNum:'',
          unitPrice:''
        },
        dataRule: {
          enterNo: [
            { required: true, message: '入库单号不能为空', trigger: 'blur' }
          ],
          enterDate: [
            { required: true, message: '入库日期不能为空', trigger: 'blur' }
          ],
          enterCategory: [
            { required: true, message: '入库类型不能为空', trigger: 'blur' }
          ],
          supplierNo: [
            { required: true, message: '供商编号不能为空', trigger: 'blur' }
          ],
          supplierName: [
            { required: true, message: '供商名称不能为空', trigger: 'blur' }
          ],
          agent: [
            { required: true, message: '经办人不能为空', trigger: 'blur' }
          ],
          remarks: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
           detailNo: [
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
              url: this.$http.adornUrl(`/chicken/feedenter/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterNo = data.feedenter.enterNo
                this.dataForm.enterDate = data.feedenter.enterDate
                this.dataForm.enterCategory = data.feedenter.enterCategory
                this.dataForm.supplierNo = data.feedenter.supplierNo
                this.dataForm.supplierName = data.feedenter.supplierName
                this.dataForm.agent = data.feedenter.agent
                this.dataForm.remarks = data.feedenter.remarks
                this.dataForm.detailNo = data.feedout.detailNo
                this.dataForm.name = data.feedout.name
                this.dataForm.category = data.feedout.category
                this.dataForm.specifications = data.feedout.specifications
                this.dataForm.unit = data.feedout.unit
                this.dataForm.unitNum = data.feedout.unitNum
                this.dataForm.unitPrice = data.feedout.unitPrice
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
              url: this.$http.adornUrl(`/chicken/feedenter/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterNo': this.dataForm.enterNo,
                'enterDate': this.dataForm.enterDate,
                'enterCategory': this.dataForm.enterCategory,
                'supplierNo': this.dataForm.supplierNo,
                'supplierName': this.dataForm.supplierName,
                'agent': this.dataForm.agent,
                'remarks': this.dataForm.remarks,
                 'detailNo': this.dataForm.detailNo,
                'name': this.dataForm.name,
                'category': this.dataForm.category,
                'specifications': this.dataForm.specifications,
                'unit': this.dataForm.unit,
                'unitNum': this.dataForm.unitNum,
                'unitPrice': this.dataForm.unitPrice
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
