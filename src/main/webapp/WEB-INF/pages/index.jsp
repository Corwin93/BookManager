<%--
  Created by IntelliJ IDEA.
  User: Corwin
  Date: 07.02.2016
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BookManager</title>
</head>
<body>
<div>
    <h1>Book Manager</h1>
    <c:if test="${!empty books}">
        <table>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Author</th>
                <th>Genre</th>
            </tr>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.genre}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
