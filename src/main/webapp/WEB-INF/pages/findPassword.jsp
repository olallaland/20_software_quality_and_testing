<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>finfPassword</title>
</head>
<body>

<form action="/tm/web/client/findPassword.action" method="post">
    <label>用户名</label><input type="text" name="userName">
    <label>邮箱</label><input type="email" name="userEmail">
    <label>邮箱授权码</label><input type="password" name="emailPassword">
    <label>输入修改后的密码</label><input type="password" name="modifiedPassword">
    <input type="submit" value="发送">
</form>
</body>
</html>
