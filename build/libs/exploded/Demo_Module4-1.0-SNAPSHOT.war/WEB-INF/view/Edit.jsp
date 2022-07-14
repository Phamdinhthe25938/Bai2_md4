<%--
  Created by IntelliJ IDEA.
  User: phamd
  Date: 7/13/2022
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="display: flex;justify-content: center;margin-top: 100px">
<div>
    <form action="/editPost/${id}" method="post">
        <div>
            <i>Id product: </i>
            <input value="${product.id}" readonly type="text" name="id">
        </div>
        <div>
            <i>Name product: </i>
            <input type="text" value="${product.name}" name="name">
        </div>
        <div>
            <i>Link img product: </i>
            <input type="text" value="${product.img}" name="img">
        </div>
        <div>
            <i>Price product: </i>
            <input type="text" value="${product.price}" name="price">
        </div>
        <button type="submit">Edit</button>
    </form>
</div>
</body>
</html>
