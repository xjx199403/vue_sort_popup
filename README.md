vue + spring mvc

前端：  
-----多条件排序的vue组件，传入一个存放排序参数的json对象，可以在任何父组件中使用;

--从0开始使用请看这里：https://pro.antdv.com/docs/getting-started ，跟着他搭建一个简单的ant-vue-design项目;
--只需要排序组件的可以直接取走 sortComponent.vue这个子组件。

  UI：
    -----本例子组件用了ant-design-vue的ui:https://www.antdv.com/docs/vue/introduce-cn/
    -----测试用父组件 使用的是它升级版的表格组件****** s-table ****** : https://pro.antdv.com/components/s-table
  package.json：
    "dependencies": {
      "@antv/data-set": "^0.10.2",
      "ant-design-vue": "1.4.2",
      "axios": "^0.19.2",
      "vue": "^2.6.10",
      "typescript": "~3.5.3",
      }

后台：
-----后台就是一个返回分页对象的 普通查询接口
--后台接收的映射对象 继承PageBeanWithSorters类；这个类里面使用spring封装的Order类，能自动切入到查询sql中，返回正确的排序结果。
