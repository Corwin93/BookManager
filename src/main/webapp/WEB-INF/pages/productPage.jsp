<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<t:clientPage>
            <div class="templatemo_product_box">
                <h1><c:out value="${book.title}"/></h1>
                <img height="128px" width="80px" src="<c:url value="/resources/images/${book.id}.jpg"/>" alt="image" />
                <div class="product_info">
                    <p>${book.annotation}</p>
                    <h3>$${book.price}</h3>
                    <div class="buy_now_button"><a href="subpage.html">Buy</a></div>
                </div>
                <div class="cleaner">&nbsp;</div>
            </div>
</t:clientPage>