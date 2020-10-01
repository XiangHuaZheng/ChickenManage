<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="鸡舍名称" prop="chickenName">
      <el-input v-model="dataForm.chickenName" placeholder="鸡舍名称"></el-input>
    </el-form-item>
    <el-form-item label="批次号" prop="batchId">
      <el-input v-model="dataForm.batchId" placeholder="批次号"></el-input>
    </el-form-item>
    <el-form-item label="日期" prop="dailyDate">
      <el-input v-model="dataForm.dailyDate" placeholder="日期"></el-input>
    </el-form-item>
    <el-form-item label="饲养员" prop="breeder">
      <el-input v-model="dataForm.breeder" placeholder="饲养员"></el-input>
    </el-form-item>
    <el-form-item label="日龄" prop="raiseDays">
      <el-input v-model="dataForm.raiseDays" placeholder="日龄"></el-input>
    </el-form-item>
    <el-form-item label="存栏鸡数" prop="chickenNum">
      <el-input v-model="dataForm.chickenNum" placeholder="存栏鸡数"></el-input>
    </el-form-item>
    <el-form-item label="死亡数" prop="dieNum">
      <el-input v-model="dataForm.dieNum" placeholder="死亡数"></el-input>
    </el-form-item>
    <el-form-item label="淘汰数" prop="outNum">
      <el-input v-model="dataForm.outNum" placeholder="淘汰数"></el-input>
    </el-form-item>
    <el-form-item label="出售数" prop="sellNum">
      <el-input v-model="dataForm.sellNum" placeholder="出售数"></el-input>
    </el-form-item>
    <el-form-item label="转入数" prop="inNum">
      <el-input v-model="dataForm.inNum" placeholder="转入数"></el-input>
    </el-form-item>
    <el-form-item label="产蛋数" prop="eggNum">
      <el-input v-model="dataForm.eggNum" placeholder="产蛋数"></el-input>
    </el-form-item>
    <el-form-item label="早温度" prop="earlyTemp">
      <el-input v-model="dataForm.earlyTemp" placeholder="早温度"></el-input>
    </el-form-item>
    <el-form-item label="中温度" prop="medTemp">
      <el-input v-model="dataForm.medTemp" placeholder="中温度"></el-input>
    </el-form-item>
    <el-form-item label="晚温度" prop="lateTemp">
      <el-input v-model="dataForm.lateTemp" placeholder="晚温度"></el-input>
    </el-form-item>
    <el-form-item label="早湿度" prop="earlyHumidity">
      <el-input v-model="dataForm.earlyHumidity" placeholder="早湿度"></el-input>
    </el-form-item>
    <el-form-item label="中湿度" prop="medHumidity">
      <el-input v-model="dataForm.medHumidity" placeholder="中湿度"></el-input>
    </el-form-item>
    <el-form-item label="晚湿度" prop="lateHumidity">
      <el-input v-model="dataForm.lateHumidity" placeholder="晚湿度"></el-input>
    </el-form-item>
    <el-form-item label="防疫记录" prop="epidemicPreventionRecord">
      <el-input v-model="dataForm.epidemicPreventionRecord" placeholder="防疫记录"></el-input>
    </el-form-item>
    <el-form-item label="用药记录" prop="medicationRecord">
      <el-input v-model="dataForm.medicationRecord" placeholder="用药记录"></el-input>
    </el-form-item>
    <el-form-item label="采食量" prop="feedIntake">
      <el-input v-model="dataForm.feedIntake" placeholder="采食量"></el-input>
    </el-form-item>
    <el-form-item label="消毒情况" prop="disinfect">
      <el-input v-model="dataForm.disinfect" placeholder="消毒情况"></el-input>
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
          chickenName: '',
          batchId: '',
          dailyDate: '',
          breeder: '',
          raiseDays: '',
          chickenNum: '',
          dieNum: '',
          outNum: '',
          sellNum: '',
          inNum: '',
          eggNum: '',
          earlyTemp: '',
          medTemp: '',
          lateTemp: '',
          earlyHumidity: '',
          medHumidity: '',
          lateHumidity: '',
          epidemicPreventionRecord: '',
          medicationRecord: '',
          feedIntake: '',
          disinfect: '',
          remarks: ''
        },
        dataRule: {
          chickenName: [
            { required: true, message: '鸡舍名称不能为空', trigger: 'blur' }
          ],
          batchId: [
            { required: true, message: '批次号不能为空', trigger: 'blur' }
          ],
          dailyDate: [
            { required: true, message: '日期不能为空', trigger: 'blur' }
          ],
          breeder: [
            { required: true, message: '饲养员不能为空', trigger: 'blur' }
          ],
          raiseDays: [
            { required: true, message: '日龄不能为空', trigger: 'blur' }
          ],
          chickenNum: [
            { required: true, message: '存栏鸡数不能为空', trigger: 'blur' }
          ],
          dieNum: [
            { required: true, message: '死亡数不能为空', trigger: 'blur' }
          ],
          outNum: [
            { required: true, message: '淘汰数不能为空', trigger: 'blur' }
          ],
          sellNum: [
            { required: true, message: '出售数不能为空', trigger: 'blur' }
          ],
          inNum: [
            { required: true, message: '转入数不能为空', trigger: 'blur' }
          ],
          eggNum: [
            { required: true, message: '产蛋数不能为空', trigger: 'blur' }
          ],
          earlyTemp: [
            { required: true, message: '早温度不能为空', trigger: 'blur' }
          ],
          medTemp: [
            { required: true, message: '中温度不能为空', trigger: 'blur' }
          ],
          lateTemp: [
            { required: true, message: '晚温度不能为空', trigger: 'blur' }
          ],
          earlyHumidity: [
            { required: true, message: '早湿度不能为空', trigger: 'blur' }
          ],
          medHumidity: [
            { required: true, message: '中湿度不能为空', trigger: 'blur' }
          ],
          lateHumidity: [
            { required: true, message: '晚湿度不能为空', trigger: 'blur' }
          ],
          epidemicPreventionRecord: [
            { required: true, message: '防疫记录不能为空', trigger: 'blur' }
          ],
          medicationRecord: [
            { required: true, message: '用药记录不能为空', trigger: 'blur' }
          ],
          feedIntake: [
            { required: true, message: '采食量不能为空', trigger: 'blur' }
          ],
          disinfect: [
            { required: true, message: '消毒情况不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/chicken/dailysituation/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.chickenName = data.dailysituation.chickenName
                this.dataForm.batchId = data.dailysituation.batchId
                this.dataForm.dailyDate = data.dailysituation.dailyDate
                this.dataForm.breeder = data.dailysituation.breeder
                this.dataForm.raiseDays = data.dailysituation.raiseDays
                this.dataForm.chickenNum = data.dailysituation.chickenNum
                this.dataForm.dieNum = data.dailysituation.dieNum
                this.dataForm.outNum = data.dailysituation.outNum
                this.dataForm.sellNum = data.dailysituation.sellNum
                this.dataForm.inNum = data.dailysituation.inNum
                this.dataForm.eggNum = data.dailysituation.eggNum
                this.dataForm.earlyTemp = data.dailysituation.earlyTemp
                this.dataForm.medTemp = data.dailysituation.medTemp
                this.dataForm.lateTemp = data.dailysituation.lateTemp
                this.dataForm.earlyHumidity = data.dailysituation.earlyHumidity
                this.dataForm.medHumidity = data.dailysituation.medHumidity
                this.dataForm.lateHumidity = data.dailysituation.lateHumidity
                this.dataForm.epidemicPreventionRecord = data.dailysituation.epidemicPreventionRecord
                this.dataForm.medicationRecord = data.dailysituation.medicationRecord
                this.dataForm.feedIntake = data.dailysituation.feedIntake
                this.dataForm.disinfect = data.dailysituation.disinfect
                this.dataForm.remarks = data.dailysituation.remarks
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
              url: this.$http.adornUrl(`/chicken/dailysituation/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'chickenName': this.dataForm.chickenName,
                'batchId': this.dataForm.batchId,
                'dailyDate': this.dataForm.dailyDate,
                'breeder': this.dataForm.breeder,
                'raiseDays': this.dataForm.raiseDays,
                'chickenNum': this.dataForm.chickenNum,
                'dieNum': this.dataForm.dieNum,
                'outNum': this.dataForm.outNum,
                'sellNum': this.dataForm.sellNum,
                'inNum': this.dataForm.inNum,
                'eggNum': this.dataForm.eggNum,
                'earlyTemp': this.dataForm.earlyTemp,
                'medTemp': this.dataForm.medTemp,
                'lateTemp': this.dataForm.lateTemp,
                'earlyHumidity': this.dataForm.earlyHumidity,
                'medHumidity': this.dataForm.medHumidity,
                'lateHumidity': this.dataForm.lateHumidity,
                'epidemicPreventionRecord': this.dataForm.epidemicPreventionRecord,
                'medicationRecord': this.dataForm.medicationRecord,
                'feedIntake': this.dataForm.feedIntake,
                'disinfect': this.dataForm.disinfect,
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
