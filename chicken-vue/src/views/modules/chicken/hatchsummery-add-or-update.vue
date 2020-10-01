<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="批次号" prop="batchNo">
      <el-input v-model="dataForm.batchNo" placeholder="批次号"></el-input>
    </el-form-item>
    <el-form-item label="箱号" prop="caseNo">
      <el-input v-model="dataForm.caseNo" placeholder="箱号"></el-input>
    </el-form-item>
    <el-form-item label="上箱时间" prop="caseTime">
      <el-input v-model="dataForm.caseTime" placeholder="上箱时间"></el-input>
    </el-form-item>
    <el-form-item label="照蛋数量" prop="eggNum">
      <el-input v-model="dataForm.eggNum" placeholder="照蛋数量"></el-input>
    </el-form-item>
    <el-form-item label="受精率" prop="fertilizationRate">
      <el-input v-model="dataForm.fertilizationRate" placeholder="受精率"></el-input>
    </el-form-item>
    <el-form-item label="预计出鸡数" prop="chikenNum">
      <el-input v-model="dataForm.chikenNum" placeholder="预计出鸡数"></el-input>
    </el-form-item>
    <el-form-item label="出鸡率" prop="chickenRate">
      <el-input v-model="dataForm.chickenRate" placeholder="出鸡率"></el-input>
    </el-form-item>
    <el-form-item label="出鸡时间" prop="chickenTime">
      <el-input v-model="dataForm.chickenTime" placeholder="出鸡时间"></el-input>
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
          batchNo: '',
          caseNo: '',
          caseTime: '',
          eggNum: '',
          fertilizationRate: '',
          chikenNum: '',
          chickenRate: '',
          chickenTime: '',
          remarks: ''
        },
        dataRule: {
          batchNo: [
            { required: true, message: '批次号不能为空', trigger: 'blur' }
          ],
          caseNo: [
            { required: true, message: '箱号不能为空', trigger: 'blur' }
          ],
          caseTime: [
            { required: true, message: '上箱时间不能为空', trigger: 'blur' }
          ],
          eggNum: [
            { required: true, message: '照蛋数量不能为空', trigger: 'blur' }
          ],
          fertilizationRate: [
            { required: true, message: '受精率不能为空', trigger: 'blur' }
          ],
          chikenNum: [
            { required: true, message: '预计出鸡数不能为空', trigger: 'blur' }
          ],
          chickenRate: [
            { required: true, message: '出鸡率不能为空', trigger: 'blur' }
          ],
          chickenTime: [
            { required: true, message: '出鸡时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/chicken/hatchsummery/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.batchNo = data.hatchsummery.batchNo
                this.dataForm.caseNo = data.hatchsummery.caseNo
                this.dataForm.caseTime = data.hatchsummery.caseTime
                this.dataForm.eggNum = data.hatchsummery.eggNum
                this.dataForm.fertilizationRate = data.hatchsummery.fertilizationRate
                this.dataForm.chikenNum = data.hatchsummery.chikenNum
                this.dataForm.chickenRate = data.hatchsummery.chickenRate
                this.dataForm.chickenTime = data.hatchsummery.chickenTime
                this.dataForm.remarks = data.hatchsummery.remarks
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
              url: this.$http.adornUrl(`/chicken/hatchsummery/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'batchNo': this.dataForm.batchNo,
                'caseNo': this.dataForm.caseNo,
                'caseTime': this.dataForm.caseTime,
                'eggNum': this.dataForm.eggNum,
                'fertilizationRate': this.dataForm.fertilizationRate,
                'chikenNum': this.dataForm.chikenNum,
                'chickenRate': this.dataForm.chickenRate,
                'chickenTime': this.dataForm.chickenTime,
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
