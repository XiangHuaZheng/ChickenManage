<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="单号" prop="enterNo">
      <el-input v-model="dataForm.enterNo" placeholder="单号"></el-input>
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
          id: 0,
          enterNo: '',
          category: '',
          eggsNum: '',
          eggsWeight: '',
          remarks: ''
        },
        dataRule: {
          enterNo: [
            { required: true, message: '单号不能为空', trigger: 'blur' }
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
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/chicken/eggsenterdetail/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.enterNo = data.eggsenterdetail.enterNo
                this.dataForm.category = data.eggsenterdetail.category
                this.dataForm.eggsNum = data.eggsenterdetail.eggsNum
                this.dataForm.eggsWeight = data.eggsenterdetail.eggsWeight
                this.dataForm.remarks = data.eggsenterdetail.remarks
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
              url: this.$http.adornUrl(`/chicken/eggsenterdetail/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'enterNo': this.dataForm.enterNo,
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
