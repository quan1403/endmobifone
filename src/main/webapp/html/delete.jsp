<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting account</title>
</head>
<body>
<h1>Delete account</h1>
<p>
    <a href="/account">Back to Account list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Account information</legend>
        <table>
            <tr>
                <td>UserName: </td>
                <td>${requestScope["accounts"].getUserName()}</td>
            </tr>
            <tr>
                <td>PassWord: </td>
                <td>${requestScope["accounts"].getPasWord()}</td>
            </tr>
            <tr>
                <td>Role: </td>
                <td>${requestScope["accounts"].getRole_acc()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete account"></td>
                <td><a href="/account">Back to staff list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
