<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
     <el-form-item>
        <el-button @click="getAllDataList()">全部数据</el-button>
        <el-button @click="getDataList()">当天数据</el-button>
        <el-button @click="getMonthDataList()">当月数据</el-button>
        <el-button @click="getYearDataList()">当年数据</el-button>
        <el-button v-if="isAuth('chicken:feedout:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('chicken:feedout:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
        <el-button type="danger" @click="getPassDataList()">待审核({{passNum}})</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      style="width: 100%;">
      <el-table-column
        type="selection"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>
      <el-table-column
        prop="enterNo"
        header-align="center"
        align="center"
        label="入库单号">
      </el-table-column>
      <el-table-column
        prop="enterDate"
        header-align="center"
        align="center"
        label="入库日期">
      </el-table-column>
      <el-table-column
        prop="enterCategory"
        header-align="center"
        align="center"
        label="入库类型">
      </el-table-column>
      <el-table-column
        prop="supplierNo"
        header-align="center"
        align="center"
        label="供商编号">
      </el-table-column>
      <el-table-column
        prop="supplierName"
        header-align="center"
        align="center"
        label="供商名称">
      </el-table-column>
      <el-table-column
        prop="agent"
        header-align="center"
        align="center"
        label="经办人">
      </el-table-column>
      <el-table-column
        prop="remarks"
        header-align="center"
        align="center"
        label="备注">
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="150"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.id)">修改</el-button>
          <el-button type="text" size="small" @click="deleteHandle(scope.row.id)">删除</el-button>
          <el-button v-if="scope.row.pass==0" style="color:red"  type="text" size="small" @click="passHandle(scope.row.id)">审核</el-button>
          <el-button v-if="scope.row.pass==1"  type="text" size="small" >已审核</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="sizeChangeHandle"
      @current-change="currentChangeHandle"
      :current-page="pageIndex"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="pageSize"
      :total="totalPage"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
  </div>
</template>

<script>
  import AddOrUpdate from './feedenter-add-or-update'
  export default {
    data () {
      return {
        dataForm: {
          key: ''
        },
        dataList: [],
        pageIndex: 1,
        pageSize: 10,
        totalPage: 0,
        dataListLoading: false,
        dataListSelections: [],
        addOrUpdateVisible: false,
        passNum:'',
        enterNo:'',
        no:'',
        name:'',
        category:'',
        size:'',
        per:'',
        num:'',
        perPrice:''
      }
    },
    components: {
      AddOrUpdate
    },
    activated () {
      this.getDataList()
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/chicken/feedenter/todayCertainList'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'key': this.dataForm.key
          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.page.list
            this.totalPage = data.page.totalCount
            this.passNum=data.size
          } else {
            this.dataList = []
            this.totalPage = 0
          }
          this.dataListLoading = false
        })
      },
      getAllDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/chicken/feedenter/certainList'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'key': this.dataForm.key
          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.page.list
            this.totalPage = data.page.totalCount
          } else {
            this.dataList = []
            this.totalPage = 0
          }
          this.dataListLoading = false
        })
      },
      getMonthDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/chicken/feedenter/monthCertainList'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'key': this.dataForm.key
          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.page.list
            this.totalPage = data.page.totalCount
          } else {
            this.dataList = []
            this.totalPage = 0
          }
          this.dataListLoading = false
        })
      },
      getYearDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/chicken/feedenter/yearCertainList'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'key': this.dataForm.key
          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.page.list
            this.totalPage = data.page.totalCount
          } else {
            this.dataList = []
            this.totalPage = 0
          }
          this.dataListLoading = false
        })
      },
      getPassDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/chicken/feedenter/passList'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'key': this.dataForm.key
          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.page.list
            this.totalPage = data.page.totalCount
          } else {
            this.dataList = []
            this.totalPage = 0
          }
          this.dataListLoading = false
        })
      },
      getDetail(id){
        this.$http({
          url: this.$http.adornUrl('/chicken/feedenter/detail'),
          method: 'get',
          params: this.$http.adornParams({
            'id': id
          })
        }).then(({data}) => {
          if (data&& data.code === 0) {
            this.no=data.detail.detailNo
            this.name=data.detail.name
            this.category=data.detail.category
            this.size=data.detail.specifications
            this.per=data.detail.unit
            this.num=data.detail.unitNum
            this.perPrice=data.detail.unitPrice
          } else {
            this.enterNo=''
            this.no=''
            this.name=''
            this.category=''
            this.size=''
            this.per=''
            this.num=''
            this.perPrice=''
          }
        })
      },
      // 每页数
      sizeChangeHandle (val) {
        this.pageSize = val
        this.pageIndex = 1
        this.getDataList()
      },
      // 当前页
      currentChangeHandle (val) {
        this.pageIndex = val
        this.getDataList()
      },
      // 多选
      selectionChangeHandle (val) {
        this.dataListSelections = val
      },
      // 新增 / 修改
      addOrUpdateHandle (id) {
        this.addOrUpdateVisible = true
        this.$nextTick(() => {
          this.$refs.addOrUpdate.init(id)
        })
      },
      // 删除
      deleteHandle (id) {
        var ids = id ? [id] : this.dataListSelections.map(item => {
          return item.id
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/chicken/feedenter/delete'),
            method: 'post',
            data: this.$http.adornData(ids, false)
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.getDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        })
      },
      //审核
       passHandle (id) {
        var ids = id ? [id] : this.dataListSelections.map(item => {
          return item.id
        })
        this.getDetail(id)
        this.$confirm(`确定进行确认操作? {入库单号:` + this.enterNo+ `,编号:`+ this.no +`,名称:`+ this.name +`,类别:`+ this.category +`,规格:`+ this.size +`,单位:`+ this.per +`,数量:`+ this.num +`,单价:`+ this.perPrice +`}`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/chicken/feedenter/pass'),
            method: 'post',
            data: this.$http.adornData(ids, false)
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: '审核成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.getPassDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        })
      }
    }
  }
</script>
