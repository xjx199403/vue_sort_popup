### vue + spring mvc

#### 前端： 
* 核心组件 SortComponent.vue
* 作为一个多条件排序的vue弹出框组件; 引入组件, 传入一个存放排序参数的json对象, 如：[{value: 'price', text: '价格'}, {value: 'num', text: '数量'}], 即可在弹出框中选择多个条件进行排序，可以在任何父组件中使用

##### UI：
* 本例子组件用了ant-design-vue的ui库:https://www.antdv.com/docs/vue/introduce-cn/
* 测试用父组件 使用的是它升级版的表格组件 s-table  : https://pro.antdv.com/components/s-table
* package.json 按需引入这个库, 不想用ant-design-vue的ui, 也可以替换组件中的html标签

#### 后台：
* 本例后台接收到前台的排序参数，如 [{property: "price", direction: "ASC", sort: true, disabled: false}...], 该参数可以映射到spring.data的Order对象, 可以直接使用该对象接收, 方便嵌入到sql中查询。
