1.http请求报文格式
请求行(请求方法 路径 协议)
头信息(格式为 key:value)
空行
主体信息(可选)(发送的内容)

example:
POST /test1 HTTP/1.1
Host: localhost
Content-type: application/x-www-form-urlencode
Content-length: 5

Age=3

-----------

2.http响应报文格式
响应行(协议 状态码 状态文字)
响应头信息(格式为 key:value)
空行
主体信息(可能没有)

example:
HTTP/1.1 200 OK
Content-Type: text/plain;charset=UTF-8
Content-length: 5

hello

---------------

3.请求的方法类型
GET POST HEAD PUT TRACE DELETE OPTIONS...
注：部分请求方法web服务器未必支持
区别:
HEAD: 和GET基本一致,只是返回内容, 比如我们只是确认一个内容(比如照片)还正常存在, 不需要返回照片的内容
TRACE: 如果你用了代理上网, 用来判断代理是否修改了HTTP请求
OPTIONS: 返回服务器可用的方法

------------

4.状态码和状态文字
状态码: 用来反应服务器响应的情况, 如 200 OK、404 NOT FOUND
状态文字: 用来描述状态码
状态码 定义         说明
1XX   信息         接收到请求, 继续处理
2XX   成功         操作成功的接收到, 理解和接收
3XX   重定向       为了完成请求, 必须采取进一步的措施
4XX   客户端错误    请求的语法有错误或不能完全被满足
5XX   服务端错误    服务器无法完成明显有效的请求
example:
200 - 请求成功
301/2 - 永久/临时重定向
304 Not Modified - 未修改
307 - 重定向中保持原来的数据, post中可以使用
404 - 请求的网页不存在
500 - 服务器内部错误
501 - 网关错误
503 - 服务器暂时不可用
504 - 网关超时
