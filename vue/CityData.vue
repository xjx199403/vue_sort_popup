<template>
<div>
  <a-card :bordered="false">
      <a-form layout="inline" :confirmLoading="confirmLoading">

      <a-button type="primary" @click="handleSortEdit()" icon='sort-descending' style="width:120px;margin-left:12px;">自定义排序</a-button>
      </a-form>
  </a-card>
      <sort-component
      ref="sortComponent"
      :sortParamsModel="sortParamsModel"
      :numberOfSorts="numberOfSorts"
      @sortOk="handleSortOk"
    />
 <div class="ant-table-wrapper">
  <s-table
    ref="table"
    size="default"
    :columns="columns"
    :data="loadData"
  >
  </s-table>
  </div>
</div>
  
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import { STable } from '@/components'
import SortComponent from './component/SortComponent.vue'
import { axios, axiosBlob } from '@/utils/request'
@Component({
  components: {
    STable,
    SortComponent
  }
})
export default class CityData extends Vue {

  // 查询参数
  private queryParam = {};
  private loading = false;

  // 排序参数
  private numberOfSorts = 3;
  private sortParamsModel: any =
  [{value: 'grade', text: '等级'}, {value: 'income', text: '收入'}, {value: 'tariff', text: '资费'}];
  // 表头
  private columns = [
    {
      title: '地市',
      dataIndex: 'sendCity',
      align: 'center',
      sorter: true,
      width: 100
    },
    {
      title: '等级',
      dataIndex: 'grade',
      align: 'center',
      sorter: true,
      width: 100
    },
    {
      title: '收入',
      dataIndex: 'income',
      align: 'center',
      sorter: true,
      width: 100
    },
    {
      title: '资费',
      dataIndex: 'tariff',
      align: 'center',
      sorter: true,
      width: 100
    }
  ]



   
 
  protected loadData(parameter: any) {
    console.log(parameter);
    const sortComponent: SortComponent = this.$refs.sortComponent as SortComponent
    // if use s-table sort, clear the sortComponent
    if (parameter.sortField !== undefined) {
      delete (this.queryParam as any).orders;
      sortComponent.sortParamInit();
    }
    const clonedQueryParam = Object.assign(parameter, this.queryParam)
    console.log("loadDataParam:" + JSON.stringify(clonedQueryParam));
    return axios.post(`/getData`, clonedQueryParam).then(res => {
      return res;
    })
  }
  protected handleOk() {
    const stable: STable = this.$refs.table as STable
    stable.refresh()
  }
 
  /**
   * for sortComponent
   */
  protected handleSortOk(sortParams: string) {
    this.queryParam = Object.assign(this.queryParam, {orders: sortParams});
    const stable: STable = this.$refs.table as STable
    stable.refresh()
  }
  protected handleSortEdit() {
    const sortComponent: SortComponent = this.$refs.sortComponent as SortComponent
    sortComponent.editSort();
  }
}
</script>
