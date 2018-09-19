# day 3

1. 什么是RESTFul API？

- 是一种编写API的架构风格
- 由Roy Thomas Fielding 提出
- 全称：Representational State Transfer（表现层状态转移）
- 通过http协议提供的方法对资源的状态进行改变

2. 一个RESTFul API主要由哪几部分组成？

- http 方法
- url

3. RESTFul API常见的四个HTTP动作是什么，它们分别代表什么含义？

- get 获取资源
- post 新建资源
- put 更新资源
- delete 删除资源

4. RESTFul API中最常用的Request和Response Body的Content-type是什么

- text/html
- image/jpeg
- image/png
- application/json

5. 什么是JSON？它的用途是什么，它有哪几种数据类型，分别对应Java中的类型是什么，请用代码例子说明？

- Javascript Object Notation
- 是一种轻量级的数据交换格式

- 可用于数据的传递，文件配置

```
json        Java
---------------
string      String
number      Number
object      Map
array       List
true        true
false       false
null        null
```

6. 请列出对User增删改查操作的RESTFul API （HTTP动作、URL、Request Body、Response Body）.

| method  | url  | request body  | response body  |
| ---     |---   |---            |---             |
| Get  | /users  |   | { "data": [{"id":1,"name":"zhang san"}], "status": 200 }|
| Post  | /users  | {"id":2,"name":"li si"}  | {"status":201}  |
| Put  | /users/1  | {"name":"wang wu"}  | {"status":200} |
| Delete  | /users/2  |   | {"status":200}  |