# user_demo #
整合前面几篇的博客，这样一个简单的demo已经做好啦，源码已经上传github,地址:[https://github.com/shinyjunjun/user_demo](https://github.com/shinyjunjun/user_demo)
## 1、项目结构
![](http://i.imgur.com/oLd4H1C.png)
## 2、登录界面
这里使用了拦截器，如果没有登录，直接进入user/showAllUser界面，会被拦截至登录页
![](http://i.imgur.com/zrrxbUq.png)
## 3、注册界面
注册登录，都采用了ajax方法，检验登录和注册的数据和数据库中的匹配，这里注册一个"测试用户"。有一种叫做shiro的验证框架，我只是了解了下，但是并没有使用。[shiro学习博客](http://blog.csdn.net/linxingliang/article/details/52263781)
![](http://i.imgur.com/5vlzV5y.png)
## 4、showAllUser界面
登录成功之后，即可进入到用户显示列表，已经实现了翻页，找到刚才注册的"测试用户"
![](http://i.imgur.com/tZnRPii.png)
## 5、修改页面
修改"测试用户"
![](http://i.imgur.com/1Oa6Sie.png)
## 6、查询及结果
查询
![](http://i.imgur.com/iBhFhgD.png)
查询结果
![](http://i.imgur.com/HPnFe8x.png)
## 7、删除用户
![](http://i.imgur.com/tk2ZbXn.jpg)
## 8、数据库
经过刚才的操作，"测试用户",已经被删除,数据库表如下:
![](http://i.imgur.com/sIO5rF4.png)
## 9、总结
一个简单的user_demo已经完成，使用了springboot,mybatis。我只是完成了最基本的一个表结构的增删改查，就当做是先熟悉熟悉怎么个基本操作吧，后面，我再想怎么设计一个自己的博客系统，边学边做，有收货就行。

csdn的user_demo下载地址:[user_demo](http://download.csdn.net/detail/jj1273365548/9802115)




