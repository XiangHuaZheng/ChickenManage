<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="时间" prop="hatchTime">
      <el-input v-model="dataForm.hatchTime" placeholder="时间"></el-input>
    </el-form-item>
    <el-form-item label="温度" prop="hatchTemp">
      <el-input v-model="dataForm.hatchTemp" placeholder="温度"></el-input>
    </el-form-item>
    <el-form-item label="湿度" prop="hatchHumidity">
      <el-input v-model="dataForm.hatchHumidity" placeholder="湿度"></el-input>
    </el-form-item>
    <el-form-item label="风门位置" prop="doorLocation">
      <el-input v-model="dataForm.doorLocation" placeholder="风门位置"></el-input>
    </el-form-item>
    <el-form-item label="翻单次数及位置" prop="numLocation">
      <el-input v-model="dataForm.numLocation" placeholder="翻单次数及位置"></el-input>
    </el-form-item>
    <el-form-item label="运转情况" prop="operation">
      <el-input v-model="dataForm.operation" placeholder="运转情况"></el-input>
    </el-form-item>
    <el-form-item label="机号" prop="machineNo">
      <el-input v-model="dataForm.machineNo" placeholder="机号"></el-input>
    </el-form-item>
    <el-form-item label="值班员" prop="duty">
      <el-input v-model="dataForm.duty" placeholder="值班员"></el-input>
    </el-form-item>
    <el-form-item label="接班时间" prop="changeDutyTime">
      <el-input v-model="dataForm.changeDutyTime" placeholder="接班时间"></el-input>
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
          hatchTime: '',
          hatchTemp: '',
          hatchHumidity: '',
          doorLocation: '',
          numLocation: '',
          operation: '',
          machineNo: '',
          duty: '',
          changeDutyTime: '',
          remarks: ''
        },
        dataRule: {
          hatchTime: [
            { required: true, message: '时间不能为空', trigger: 'blur' }
          ],
          hatchTemp: [
            { required: true, message: '温度不能为空', trigger: 'blur' }
          ],
          hatchHumidity: [
            { required: true, message: '湿度不能为空', trigger: 'blur' }
          ],
          doorLocation: [
            { required: true, message: '风门位置不能为空', trigger: 'blur' }
          ],
          numLocation: [
            { required: true, message: '翻单次数及位置不能为空', trigger: 'blur' }
          ],
          operation: [
            { required: true, message: '运转情况不能为空', trigger: 'blur' }
          ],
          machineNo: [
            { required: true, message: '机号不能为空', trigger: 'blur' }
          ],
          duty: [
            { required: true, message: '值班员不能为空', trigger: 'blur' }
          ],
          changeDutyTime: [
            { required: true, message: '接班时间不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/chicken/hatchrecordsummery/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.hatchTime = data.hatchrecordsummery.hatchTime
                this.dataForm.hatchTemp = data.hatchrecordsummery.hatchTemp
                this.dataForm.hatchHumidity = data.hatchrecordsummery.hatchHumidity
                this.dataForm.doorLocation = data.hatchrecordsummery.doorLocation
                this.dataForm.numLocation = data.hatchrecordsummery.numLocation
                this.dataForm.operation = data.hatchrecordsummery.operation
                this.dataForm.machineNo = data.hatchrecordsummery.machineNo
                this.dataForm.duty = data.hatchrecordsummery.duty
                this.dataForm.changeDutyTime = data.hatchrecordsummery.changeDutyTime
                this.dataForm.remarks = data.hatchrecordsummery.remarks
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
              url: this.$http.adornUrl(`/chicken/hatchrecordsummery/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'hatchTime': this.dataForm.hatchTime,
                'hatchTemp': this.dataForm.hatchTemp,
                'hatchHumidity': this.dataForm.hatchHumidity,
                'doorLocation': this.dataForm.doorLocation,
                'numLocation': this.dataForm.numLocation,
                'operation': this.dataForm.operation,
                'machineNo': this.dataForm.machineNo,
                'duty': this.dataForm.duty,
                'changeDutyTime': this.dataForm.changeDutyTime,
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
