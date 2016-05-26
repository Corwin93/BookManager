<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<t:adminPage>
    <c:if test="${!empty books}">
        <table class="book-table">
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
                    <td>
                        <a href="<c:url value="javascript:BookUtil.deleteBook(${book.id})"/>"><button class="btn btn-danger">Delete</button></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <br>
    <p><a href="<c:url value="/addBook"/>"><button class="btn btn-info">Add a book</button></a></p>
</t:adminPage>