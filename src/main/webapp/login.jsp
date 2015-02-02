<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>ავტორიზაცია</title>
</head>
<body>
<c:if test="${"fail" eq param.auth}">
    <div style="color:red">
        Login Failed!!!<br/>
        Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
    </div>
</c:if>

<form action="${pageContext.request.contextPath}/loginProcess" method="POST">
    <table>
        <tr>
            <td>Username:</td>
            <td><input type='text' name='username'/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password'></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Submit"></td>
        </tr>
    </table>
</form>
</body>
</html>