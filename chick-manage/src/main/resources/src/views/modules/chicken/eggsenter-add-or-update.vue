<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="单号" prop="enterNo">
      <el-input v-model="dataForm.enterNo" placeholder="单号"></el-input>
    </el-form-item>
    <el-form-item label="入库日期" prop="enterDate">
      <el-input v-model="dataForm.enterDate" placeholder="入库日期"></el-input>
    </el-form-item>
    <el-form-item label="鸡舍号" prop="chickenNo">
      <el-input v-model="dataForm.chickenNo" placeholder="鸡舍号"></el-input>
    </el-form-item>
    <el-form-item label="入库类型" prop="enterCategory">
      <el-input v-model="dataForm.enterCategory" placeholder="入库类型"></el-input>
    </el-form-item>
    <el-form-item label="经办人" prop="agent">
      <el-input v-model="dataForm.agent" placeholder="经办人"></el-input>
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
          enterNo: '',
          enterDate: '',
          chickenNo: '',
          enterCategory: '',
          agent: '',
          remarks: ''
        },
        dataRule: {
          enterNo: [
            { required: true, message: '单号不能为空', trigger: 'blur' }
          ],
          enterDate: [
            { required: true, message: '入库日期不能为空', trigger: 'blur' }
          ],
          chickenNo: [
            { required: true, message: '鸡舍号不能为空', trigger: 'blur' }
          ],
          enterCategory: [
            { required: true, message: '入库类型不能为空', trigger: 'blur' }
          ],
          agent: [
            { required: true, message: '经办人不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/chicken/eggsenter/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterNo = data.eggsenter.enterNo
                this.dataForm.enterDate = data.eggsenter.enterDate
                this.dataForm.chickenNo = data.eggsenter.chickenNo
                this.dataForm.enterCategory = data.eggsenter.enterCategory
                this.dataForm.agent = data.eggsenter.agent
                this.dataForm.remarks = data.eggsenter.remarks
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
              url: this.$http.adornUrl(`/chicken/eggsenter/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterNo': this.dataForm.enterNo,
                'enterDate': this.dataForm.enterDate,
                'chickenNo': this.dataForm.chickenNo,
                'enterCategory': this.dataForm.enterCategory,
                'agent': this.dataForm.agent,
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
