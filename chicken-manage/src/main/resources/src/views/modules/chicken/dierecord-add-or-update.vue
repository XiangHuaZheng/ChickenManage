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
    <el-form-item label="死亡数量" prop="dieNum">
      <el-input v-model="dataForm.dieNum" placeholder="死亡数量"></el-input>
    </el-form-item>
    <el-form-item label="死亡原因" prop="dieReason">
      <el-input v-model="dataForm.dieReason" placeholder="死亡原因"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remarks">
      <el-input v-model="dataForm.remarks" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="登记员" prop="recorder">
      <el-input v-model="dataForm.recorder" placeholder="登记员"></el-input>
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
          dieNum: '',
          dieReason: '',
          remarks: '',
          recorder: ''
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
          dieNum: [
            { required: true, message: '死亡数量不能为空', trigger: 'blur' }
          ],
          dieReason: [
            { required: true, message: '死亡原因不能为空', trigger: 'blur' }
          ],
          remarks: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          recorder: [
            { required: true, message: '登记员不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/chicken/dierecord/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.chickenName = data.dierecord.chickenName
                this.dataForm.category = data.dierecord.category
                this.dataForm.dailyDate = data.dierecord.dailyDate
                this.dataForm.dieNum = data.dierecord.dieNum
                this.dataForm.dieReason = data.dierecord.dieReason
                this.dataForm.remarks = data.dierecord.remarks
                this.dataForm.recorder = data.dierecord.recorder
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
              url: this.$http.adornUrl(`/chicken/dierecord/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'chickenName': this.dataForm.chickenName,
                'category': this.dataForm.category,
                'dailyDate': this.dataForm.dailyDate,
                'dieNum': this.dataForm.dieNum,
                'dieReason': this.dataForm.dieReason,
                'remarks': this.dataForm.remarks,
                'recorder': this.dataForm.recorder
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
