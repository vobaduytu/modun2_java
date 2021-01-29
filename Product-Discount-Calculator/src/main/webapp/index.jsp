<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/index" method="post">
    <h3>Mô tả của sản phẩm</h3>
    <input type="text" name="Product Description" >
    <h3>Giá niêm yết của sản phẩm</h3>
    <input type="text" name="List Price">
    <h3>Tỷ lệ chiết khấu (phần trăm)</h3>
    <input type="text" name="Discount Percent">
    <input type="submit">
</form>
<br/>
</body>
</html>