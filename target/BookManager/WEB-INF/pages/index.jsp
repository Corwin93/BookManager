<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<t:clientPage>
            <c:if test="${!empty books}">
            <c:forEach items="${books}" var="book" varStatus="status">
                <c:set var="annotation" value="${book.annotation}"/>
                <c:if test="${book.annotation.length() gt 60}">
                <c:set var="annotation" value="${book.annotation.substring(0, 60)}"/>
                </c:if>
                <div class="templatemo_product_box">
                    <h1><c:out value="${book.title}"/></h1>
                    <img height="128px" width="80px" src="<c:url value="/resources/images/${book.id}.jpg"/>" alt="image" />
                    <div class="product_info">
                        <p>${annotation}</p>
                        <h3>$${book.price}</h3>
                        <div class="buy_now_button"><a href="subpage.html">Buy</a></div>
                        <div class="detail_button"><a href="/${book.id}">Details</a></div>
                    </div>
                    <div class="cleaner">&nbsp;</div>
                </div>
            </c:forEach>
            </c:if>
            <a href="subpage.html"><img src="<c:url value="/resources/images/templatemo_ads.jpg"/>" alt="ads" /></a>
</t:clientPage>