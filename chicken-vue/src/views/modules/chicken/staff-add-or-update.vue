<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="员工编号" prop="staffNo">
      <el-input v-model="dataForm.staffNo" placeholder="员工编号"></el-input>
    </el-form-item>
    <el-form-item label="姓名" prop="name">
      <el-input v-model="dataForm.name" placeholder="姓名"></el-input>
    </el-form-item>
    <el-form-item label="0:男性  1:女性" prop="gender">
      <el-input v-model="dataForm.gender" placeholder="0:男性  1:女性"></el-input>
    </el-form-item>
    <el-form-item label="联系方式" prop="phone">
      <el-input v-model="dataForm.phone" placeholder="联系方式"></el-input>
    </el-form-item>
    <el-form-item label="职务" prop="job">
      <el-input v-model="dataForm.job" placeholder="职务"></el-input>
    </el-form-item>
    <el-form-item label="负责鸡舍" prop="henhouse">
      <el-input v-model="dataForm.henhouse" placeholder="负责鸡舍"></el-input>
    </el-form-item>
    <el-form-item label="入职日期" prop="jobDate">
      <el-input v-model="dataForm.jobDate" placeholder="入职日期"></el-input>
    </el-form-item>
    <el-form-item label="0:在职  1:离职" prop="status">
      <el-input v-model="dataForm.status" placeholder="0:在职  1:离职"></el-input>
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
          staffNo: '',
          name: '',
          gender: '',
          phone: '',
          job: '',
          henhouse: '',
          jobDate: '',
          status: '',
          remarks: ''
        },
        dataRule: {
          staffNo: [
            { required: true, message: '员工编号不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '姓名不能为空', trigger: 'blur' }
          ],
          gender: [
            { required: true, message: '0:男性  1:女性不能为空', trigger: 'blur' }
          ],
          phone: [
            { required: true, message: '联系方式不能为空', trigger: 'blur' }
          ],
          job: [
            { required: true, message: '职务不能为空', trigger: 'blur' }
          ],
          henhouse: [
            { required: true, message: '负责鸡舍不能为空', trigger: 'blur' }
          ],
          jobDate: [
            { required: true, message: '入职日期不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '0:在职  1:离职不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/chicken/staff/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.staffNo = data.staff.staffNo
                this.dataForm.name = data.staff.name
                this.dataForm.gender = data.staff.gender
                this.dataForm.phone = data.staff.phone
                this.dataForm.job = data.staff.job
                this.dataForm.henhouse = data.staff.henhouse
                this.dataForm.jobDate = data.staff.jobDate
                this.dataForm.status = data.staff.status
                this.dataForm.remarks = data.staff.remarks
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
              url: this.$http.adornUrl(`/chicken/staff/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'staffNo': this.dataForm.staffNo,
                'name': this.dataForm.name,
                'gender': this.dataForm.gender,
                'phone': this.dataForm.phone,
                'job': this.dataForm.job,
                'henhouse': this.dataForm.henhouse,
                'jobDate': this.dataForm.jobDate,
                'status': this.dataForm.status,
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
