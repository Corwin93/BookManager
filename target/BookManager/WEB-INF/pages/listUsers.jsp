<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<t:adminPage>
    <c:if test="${!empty users}">
        <table class="user-table">
            <tr>
                <th>Nickname</th>
                <th>First name</th>
                <th>Last name</th>
                <th>E-mail</th>
                <th>Password</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.nickName}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                    <td>${user.password}</td>
                    <td>
                        <a href="<c:url value="/deleteUser/${user.nickName}"/>"><button class="btn btn-danger">Delete</button></a>
                        <%--<a href="<c:url value="javascript:UserUtil.deleteUser(${user.nickName})"/>"><button class="btn btn-danger">Delete</button></a>--%>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <br>
    <p><a href="<c:url value="/addUser"/>"><button class="btn btn-info">Add a user</button></a></p>
</t:adminPage>