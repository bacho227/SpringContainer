<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<h2>Custom Form based Login Page</h2>
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
            <td>dg number:</td>
            <td><input type='text' name='dgNum'></td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Submit"></td>
        </tr>
    </table>
</form>
</body>
</html>