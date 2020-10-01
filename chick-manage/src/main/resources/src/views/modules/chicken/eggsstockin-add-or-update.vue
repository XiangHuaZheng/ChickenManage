<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="入库单号" prop="inNo">
      <el-input v-model="dataForm.inNo" placeholder="入库单号"></el-input>
    </el-form-item>
    <el-form-item label="鸡舍号" prop="chickenNo">
      <el-input v-model="dataForm.chickenNo" placeholder="鸡舍号"></el-input>
    </el-form-item>
    <el-form-item label="入库类型" prop="inCategory">
      <el-input v-model="dataForm.inCategory" placeholder="入库类型"></el-input>
    </el-form-item>
    <el-form-item label="经办人" prop="agent">
      <el-input v-model="dataForm.agent" placeholder="经办人"></el-input>
    </el-form-item>
    <el-form-item label="种类" prop="category">
      <el-input v-model="dataForm.category" placeholder="种类"></el-input>
    </el-form-item>
    <el-form-item label="产蛋个数" prop="eggsNum">
      <el-input v-model="dataForm.eggsNum" placeholder="产蛋个数"></el-input>
    </el-form-item>
    <el-form-item label="产蛋重量" prop="eggsWeight">
      <el-input v-model="dataForm.eggsWeight" placeholder="产蛋重量"></el-input>
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
          chickenNo: '',
          inCategory: '',
          agent: '',
          category: '',
          eggsNum: '',
          eggsWeight: '',
          remarks: ''
        },
        dataRule: {
          inNo: [
            { required: true, message: '入库单号不能为空', trigger: 'blur' }
          ],
          chickenNo: [
            { required: true, message: '鸡舍号不能为空', trigger: 'blur' }
          ],
          inCategory: [
            { required: true, message: '入库类型不能为空', trigger: 'blur' }
          ],
          agent: [
            { required: true, message: '经办人不能为空', trigger: 'blur' }
          ],
          category: [
            { required: true, message: '种类不能为空', trigger: 'blur' }
          ],
          eggsNum: [
            { required: true, message: '产蛋个数不能为空', trigger: 'blur' }
          ],
          eggsWeight: [
            { required: true, message: '产蛋重量不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/chicken/eggsstockin/info/${this.dataForm.inDate}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.inNo = data.eggsstockin.inNo
                this.dataForm.chickenNo = data.eggsstockin.chickenNo
                this.dataForm.inCategory = data.eggsstockin.inCategory
                this.dataForm.agent = data.eggsstockin.agent
                this.dataForm.category = data.eggsstockin.category
                this.dataForm.eggsNum = data.eggsstockin.eggsNum
                this.dataForm.eggsWeight = data.eggsstockin.eggsWeight
                this.dataForm.remarks = data.eggsstockin.remarks
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
              url: this.$http.adornUrl(`/chicken/eggsstockin/${!this.dataForm.inDate ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'inDate': this.dataForm.inDate || undefined,
                'inNo': this.dataForm.inNo,
                'chickenNo': this.dataForm.chickenNo,
                'inCategory': this.dataForm.inCategory,
                'agent': this.dataForm.agent,
                'category': this.dataForm.category,
                'eggsNum': this.dataForm.eggsNum,
                'eggsWeight': this.dataForm.eggsWeight,
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
