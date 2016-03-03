<%--suppress ALL --%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<t:template>
    <form:form action="/addbook" method="post" modelAttribute="newBook">
        <table>
            <tr>
                <td><form:label path="title">
                    title
                </form:label></td>
                <td><form:input path="title"/></td>
                <td class="error"><form:errors path="title"/></td>
            </tr>
            <tr>
                <td><form:label path="author">
                    author
                </form:label></td>
                <td><form:input path="author"/></td>
            </tr>
            <tr>
                <td><form:label path="numberOfPages">
                    number of pages
                </form:label></td>
                <td><form:input path="numberOfPages"/></td>
            </tr>
            <tr>
                <td><form:label path="language">
                    language
                </form:label></td>
                <td><form:input path="language"/></td>
            </tr>
            <tr>
                <td><form:label path="publishYear">
                    publish year
                </form:label></td>
                <td><form:input path="publishYear"/></td>
            </tr>
            <tr>
                <td><form:label path="isbn">
                    isbn
                </form:label></td>
                <td><form:input path="isbn"/></td>
            </tr>
            <tr>
                <td><form:label path="genre">
                    genre
                </form:label></td>
                <td><form:input path="genre"/></td>
            </tr>
            <tr>
                <td><form:label path="price">
                    price
                </form:label></td>
                <td><form:input path="price"/></td>
            </tr>
            <tr>
                <td><form:label path="annotation">
                    annotation
                </form:label></td>
                <td><form:input path="annotation"/></td>
            </tr>
            <tr>
                <td><form:label path="purchases">
                    purchases
                </form:label></td>
                <td><form:input path="purchases"/></td>
            </tr>
            <tr>
                <td><form:label path="publisher">
                    publisher
                </form:label></td>
                <td><form:input path="publisher"/></td>
            </tr>
            <tr><td colspan="2">
                <input type="submit" value="Add book"/>
            </td>
            </tr>
        </table>
    </form:form>
</t:template>