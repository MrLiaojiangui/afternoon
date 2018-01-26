<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: dllo
  Date: 18/1/25
  Time: 下午2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分页查询</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <td>学生编号</td>
        <td>学生姓名</td>
        <td>学生密码</td>
    </tr>
    </thead>
    <tbody>
    <s:iterator value="#session.pageBean.beanList" var="temp">
        <tr>
            <td>${temp.sid}</td>
            <td>${temp.sname}</td>
            <td>${temp.spassword}</td>
        </tr>
    </s:iterator>
    </tbody>
</table>

<div>
    <span>第${session.pageBean.pageNum}/${session.pageBean.totalPage}页</span>
    <a href="selectAll.action?pageNum=1&&pageSize=${session.pageBean.pageSize}">首页</a>
    <a href="selectAll.action?pageNum=${session.pageBean.pageNum-1}&&pageSize=${session.pageBean.pageSize}">上一页</a>
    <a href="selectAll.action?pageNum=${session.pageBean.pageNum+1}&&pageSize=${session.pageBean.pageSize}">下一页</a>
    <a href="selectAll.action?pageNum=${session.pageBean.totalPage}&&pageSize=${session.pageBean.pageSize}">尾页</a>
</div>
</body>
</html>
