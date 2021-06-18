首先我们来看Order 客户端需要什么？

```
service dao impl 都是不要的,毕竟用户不可能使用app 的数据库吧  所以直接用controller就够了.
同时现在是2个服务 2个端口的调用
```











RunDashboard如果没有的话 就再`.idea` 中的`workspace.xml` 加入一下字段就好了.新版本后 RunDashboard 改名为services

```
  <component name="RunDashboard">
    <option name="configurationTypes">
      <set>
        <option value="SpringBootApplicationConfigurationType" />
      </set>
    </option>
  </component>
```

