<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Template tag" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <link href='https://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet" type="text/css">
    <script src="<c:url value="/resources/scripts/bookUtil.js"/>"></script>
    <title>Book manager</title>
</head>
<body>
<div class="content">
    <h1 class="lobster-title"><b>Book Manager</b></h1>
    <jsp:doBody/>
</div>
</body>
</html>