<template>
<div>      
  <a-modal
      v-model="visible"
      title="自定义排序"
      @ok="modelhandleOk"
      @cancel="modelhandleCancel"
    >
    <a-button type="primary" @click="addSort()" style="" icon="plus" >添加条件</a-button>
    <a-button type="primary" @click="delSort()" style="margin-left:10%;margin-top:-5%;" icon="minus" >删除条件</a-button>
    <a-card style="width: 100%;margin-top:2%;" >
    <div class="table-page-search-wrapper">
      <a-form layout="inline" v-for="(item,index) in sortParamsList" :key="item.key">
        <a-row :gutter="48" v-if="item.sort">
          <a-col :md="12" :sm="14">
              <a-form-item :label="index === 0 ? '主要关键字' : '次要关键字'">
               <a-select v-model="item.property" :disabled="item.disabled">
                  <a-select-option v-for="sortParam in sortParamOptions" :key="sortParam.value">
                      {{ sortParam.text }}
                  </a-select-option>
               </a-select>
              </a-form-item>
          </a-col> 
          <a-col :md="8" :sm="14" style="margin-left:50px;">
              <a-form-item label="次序">
               <a-select v-model="item.direction">
                  <a-select-option value="ASC" >
                    升序
                  </a-select-option>
                  <a-select-option value="DESC">
                    降序
                  </a-select-option>
               </a-select>
              </a-form-item>
          </a-col> 
        </a-row>
      </a-form>
    </div>
  </a-card>
 </a-modal>
</div>
</template>

<script lang="ts">
import { Component, Vue, Prop } from 'vue-property-decorator'
// auther xjx
@Component
export default class SortComponent extends Vue {

  // <select sortParamsList[0] /> <select sortParamsList[1] /> ......
  private sortParamsList: any = [];

  // <select> <option sortParamOptions[0] /> <option sortParamOptions[1] /> ...... </select>
  private sortParamOptions: any = [];

  private sortTempQueue: any = new Array();

  private visible: boolean = false;

  private currentSortPointer: number = 0;

  /**
   * Dynamic configuration
   */
  @Prop({ default: 3 })
  private numberOfSorts: any;

  @Prop({ default: [{value: 'xjx1', text: 'text1'}, {value: 'xjx2', text: 'text2'}] })
  private sortParamsModel?: [];

  public editSort() {
    this.visible = true;
  }

  public sortParamInit() {
    this.sortParamOptions = this.deepClone(this.sortParamsModel);
    this.currentSortPointer = 0;
    this.sortParamsList = [];
    for (let i = 0; i < this.numberOfSorts; i++) {
      if (i === 0) {
        this.sortParamsList.push({property: "", direction: "ASC", sort: true, disabled: false});
      } else {
        this.sortParamsList.push({property: "", direction: "ASC", sort: false, disabled: false});
      }
    }
  }

  private created() {
    this.sortParamInit();
  }

  private addSort() {
    if (this.currentSortPointer === this.numberOfSorts - 1) {
      return;
    }
    const sortParamValue = this.sortParamsList[this.currentSortPointer].property;
    if (sortParamValue === '') {
      this.$notification.warn({ message: '您好', description: '请至少选择一个排序项！' })
      return;
    }
    for (const i in this.sortParamOptions) {
      if (this.sortParamOptions[i].value === sortParamValue) {
        this.sortTempQueue.push(this.sortParamOptions[i]);
        this.sortParamOptions.splice(Number(i), 1);
        break;
      }
    }
    this.sortParamsList[this.currentSortPointer].disabled = true;
    this.currentSortPointer++;
    this.sortParamsList[this.currentSortPointer].sort = true;
  }
  private delSort() {
    if (this.currentSortPointer === 0) {
      return;
    }
    this.sortParamsList[this.currentSortPointer].sort = false;
    this.currentSortPointer--;
    this.sortParamsList[this.currentSortPointer].disabled = false;
    const sortParam = this.sortTempQueue.pop();
    this.sortParamOptions.push(sortParam as any);
  }
  private modelhandleOk(e: any) {
      // because server doesnt support '' in orders
      const querySelected = this.deepClone(this.sortParamsList);
      for (let i = 0; i < querySelected.length; i++) {
        if (querySelected[i].property === "") {
          querySelected.splice(i, 1);
          i--;
　　    }
      }
      console.log("===========query with sorted params:" + querySelected);
      this.visible = false;
      this.$emit('sortOk', querySelected);
  }
  private modelhandleCancel(e: any) {
      console.log("===========sort dialog closed");
      this.visible = false;
      this.sortParamInit();
  }
  private deepClone(data: any) {
    const DataStr = JSON.stringify(data);
    return JSON.parse(DataStr);
  }
}
</script>
<style lang="less" scoped>
/deep/ .ant-table-title {
    text-align: center;
    font-size: 14px;
    font-weight: 600;
    padding:7px;
}
/deep/ .ant-modal-header {
    padding: 7px 16px;
    color: rgba(0, 0, 0, 0.65);
    background: #fff;
    border-bottom: 1px solid #e8e8e8;
    border-radius: 4px 4px 0 0;
}
</style>
