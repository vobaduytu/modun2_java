<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2/1/2021
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>ten: ${requestScope["student"].name}</p>
<p>age: ${requestScope["student"].age}</p>
</body>
</html>
