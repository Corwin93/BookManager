<%--suppress ALL --%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<t:adminPage>
    <form:form method="POST" commandName="newBook">
        <form:errors cssClass="error" path="*" element="div"/>
        <table>
            <tr>
                <td><form:label path="title" cssErrorClass="error">
                    title
                </form:label></td>
                <td><form:input path="title" cssErrorClass="error"/></td>
                <td class="error">
            </tr>
            <tr>
                <td><form:label path="author" cssErrorClass="error">
                    author
                </form:label></td>
                <td><form:input path="author" cssErrorClass="error"/></td>
            </tr>
            <tr>
                <td><form:label path="numberOfPages" cssErrorClass="error">
                    number of pages
                </form:label></td>
                <td><form:input path="numberOfPages" cssErrorClass="error"/></td>
            </tr>
            <tr>
                <td><form:label path="language" cssErrorClass="error">
                    language
                </form:label></td>
                <td><form:input path="language" cssErrorClass="error"/></td>
            </tr>
            <tr>
                <td><form:label path="publishYear" cssErrorClass="error">
                    publish year
                </form:label></td>
                <td><form:input path="publishYear" cssErrorClass="error"/></td>
            </tr>
            <tr>
                <td><form:label path="isbn" cssErrorClass="error">
                    isbn
                </form:label></td>
                <td><form:input path="isbn" cssErrorClass="error"/></td>
            </tr>
            <tr>
                <td><form:label path="genre" cssErrorClass="error">
                    genre
                </form:label></td>
                <td><form:input path="genre" cssErrorClass="error"/></td>
            </tr>
            <tr>
                <td><form:label path="price" cssErrorClass="error">
                    price
                </form:label></td>
                <td><form:input path="price" cssErrorClass="error"/></td>
            </tr>
            <tr>
                <td><form:label path="annotation" cssErrorClass="error">
                    annotation
                </form:label></td>
                <td><form:input path="annotation" cssErrorClass="error"/></td>
            </tr>
            <tr>
                <td><form:label path="purchases" cssErrorClass="error">
                    purchases
                </form:label></td>
                <td><form:input path="purchases" cssErrorClass="error"/></td>
            </tr>
            <tr>
                <td><form:label path="publisher" cssErrorClass="error">
                    publisher
                </form:label></td>
                <td><form:input path="publisher" cssErrorClass="error"/></td>
            </tr>
            <tr><td colspan="2">
                <input type="submit" value="Add book"/>
            </td>
            </tr>
        </table>
    </form:form>
</t:adminPage>