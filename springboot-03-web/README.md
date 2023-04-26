# 工程简介

# 延伸阅读

4.员工列表展示
- 提取公共页面
    - th:fragment="sidebar"
    - th:replace="~{commons/commons::topbar}"
    - 如果要传递参数，可以直接使用()传参，接收判断即可
- 查询操作(列表循环展示)
```html
<tr th:each="emp:${emps}">
    <td th:text="${emp.getId()}"></td>
    <td th:text="${emp.getLastName()}">]</td>
    <td th:text="${emp.getEmail()}"></td>
    <td th:text="${emp.getGender()==0?'女':'男'}"></td>
    <td th:text="${emp.department.getDepartment()}"></td>
    <td th:text="${#dates.format(emp.getBirth(),'yyy-MM-dd HH:mm:ss')}"></td>
    <td>
      <button class="btn btn-sm btn-primary">编辑</button>
      <button class="btn btn-sm btn-danger">删除</button>
    </td>
</tr>
```
还可以使用[[${emp.getLastName()}]]代替,但此方法没有提示

