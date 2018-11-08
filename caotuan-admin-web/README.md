前后端分离
如果前端http.post的Content-Type: 'application/x-www-form-urlencoded' ---表单请求
那么controller的处理类型直接去掉@RequestBody就可以

默认http.post的Content-Type是'application/json' 
@RequestBody是处理json数据的

不知道为什么,前端的application/json无法请求到后端,只能暂且改成表单提交
如果数据是简单、平面的key-value键值对，那么使用application/x-www-form-urlencoded简单实用，不需要额外的编解码
如果数据是复杂的嵌套关系，有多层数据，那么使用application/json会简化数据的处理

前后端分离,,,,,,
带来一个跨域请求的问题,,,如何解决????
正在跟进


浏览器application/x-www-form-urlencoded不存在跨域
json格式存在跨域问题
posman不存在跨域问题,所以能正常访问.


解决前后端分离跨域问题,自定义hread无法请求
非简单请求的CORS请求，会在正式通信之前，增加一次HTTP查询请求，称为”预检”请求（preflight）
解决方法:
在我们后台用了Spring Security作为安全框架，并且没有对Preflight这个请求做出相应的处理，那么这个请求会导致权限管控失败。 
处理起来也很简单，只需要在spring security配置类configure方法中增加放行preflight请求
// 所有 / 的所有请求 都放行
.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()    //对preflight放行