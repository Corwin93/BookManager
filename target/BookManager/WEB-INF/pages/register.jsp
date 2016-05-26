<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<t:clientPage>
    <form:form method="post" commandName="newUser">
        <form:errors cssClass="error" path="*" element="div"/>
        <table>
            <tr>
                <td><form:label path="nickName" cssErrorClass="error">
                    Nickname
                </form:label></td>
                <td><form:input path="nickName" cssErrorClass="error"/></td>
            </tr>
            <tr>
                <td><form:label path="firstName" cssErrorClass="error">
                    First name
                </form:label></td>
                <td><form:input path="firstName" cssErrorClass="error"/></td>
            </tr>
            <tr>
                <td><form:label path="lastName" cssErrorClass="error">
                    Last name
                </form:label></td>
                <td><form:input path="lastName" cssErrorClass="error"/></td>
            </tr>
            <tr>
                <td><form:label path="email" cssErrorClass="error">
                    E-mail
                </form:label></td>
                <td><form:input path="email" cssErrorClass="error"/></td>
            </tr>
            <tr>
                <td><form:label path="password" cssErrorClass="error">
                    Password
                </form:label></td>
                <td><form:password path="password"  cssErrorClass="error"/></td>
            </tr>
        </table>
        <input type="submit" value="Add user">
    </form:form>
</t:clientPage>