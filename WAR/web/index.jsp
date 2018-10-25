<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Example JSP</title>
</head>
<body>
<p>Your random number: ${requestScope.random_number}</p>
<p>Cats:</p>
<ul>
    <c:forEach items="${requestScope.cats}" var="cat">
        <li>${cat}</li>
    </c:forEach>
</ul>
</body>
</html>
