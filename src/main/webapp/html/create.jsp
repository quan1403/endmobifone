<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Create new customer</title>
  <style>
    .message {
      color: green;
    }
  </style>
</head>
<body>
<h1>Create new user</h1>
<p>
  <c:if test='${requestScope["message"] != null}'>
    <span class="message">${requestScope["message"]}</span>
  </c:if>
</p>
<p>
  <a href="/account">Back to account list</a>
</p>

<form action="/account?action=create" method="post">
  <fieldset>
    <legend>account information</legend>
    <table>
<%--      <tr>--%>
<%--        <td>Id:</td>--%>
<%--        <td><input type="text" name="id" > </td>--%>
<%--      </tr>--%>

      <tr>
        <td>userName:</td>
        <td><input type="text" name="userName" ></td>
      </tr>
      <tr>
        <td>passWord:</td>
        <td><input type="text" name="pasWord" ></td>
      </tr>
<%--      <tr>--%>
<%--        <td>passWord:</td>--%>
<%--        <td><input type="password" name="confirmPassWord" ></td>--%>
<%--      </tr>--%>
      <tr>
        <td>role:</td>
        <td><select name="role_acc">
          <option value="user">user</option>
          <option value="admin">admin</option>
        </select></td>
      </tr>
      <tr >
      <td>status</td>
        <td><select name="status">
          <option value="normal">Normal</option>
          <option value="Lock">Lock</option>
        </select></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Create customer"></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>
