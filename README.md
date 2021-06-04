vue + spring mvc

多条件排序的vue组件，传入一个存放排序参数的json对象，可以在任何父组件中使用;
  本例用了ant-design-vue的ui:https://www.antdv.com/docs/vue/introduce-cn/
  以及它升级版的表格组件s-table:https://pro.antdv.com/components/s-table

后台接收的对象继承PageBeanWithSorters类即可，spring封装的Order类能自动切入到查询sql中，返回正确的排序结果。
参数前后台都封装好了，查询时带上即可。
