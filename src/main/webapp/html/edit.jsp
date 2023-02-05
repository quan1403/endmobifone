<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Account</title>
</head>
<body>
<h1>Edit Account</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/account">Back to account list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Account information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="userName" value="${requestScope["accounts"].getUserName()}"></td>
            </tr>
            <tr>
                <td>PassWord </td>
                <td><input type="text" name="passWord"  value="${requestScope["accounts"].getPassWord()}"></td>
            </tr>
            <tr>
                <td>Role: </td>
                <td><input type="text" name="role" readonly value="${requestScope["accounts"].getRole()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update Account"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
