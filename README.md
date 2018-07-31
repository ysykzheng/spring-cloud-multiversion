# spring-cloud-multiversion
spring-cloud-multiversion
此项目是为了演示spring cloud eureka 使用ribbon实现相同服务不同版本调用。

discovery-server 注册服务器

user-server1，user-server2：需要被调用的服务。为了方便演示，这里直接将相同工程代码复制了两份。不同的地方仅有test接口返回值，及metadataMap属性。

user-client 使用feign实现的调用客户端

test 用于演示调用。
通过控制配置文件中的属性，可以实现仅调用user-server1或user-server2
```
app:
  serviceId: test-user-server
  version: v1
```
