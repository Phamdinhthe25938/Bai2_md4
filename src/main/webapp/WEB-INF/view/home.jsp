<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 13/07/2022
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        select {
            width: 200px;
            height: 20px;
        }
    </style>
</head>
<body style="display: flex;justify-content: center;margin-top: 100px">
    <div>
        <table border="1px">
            <div>
                <form action="/search" method="post">
                    <input type="text" name="search">
                    <button type="submit">Tim kiem</button>
                </form>
            </div>
            <a href="/add">Add product</a>
            <c:forEach var="p" items="${products}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.name}</td>
                    <td>${p.price}</td>
                    <td><img src="${p.img}" width="30" height="30"></td>
                    <td><a href="/delele?idDelete=${p.id}"><button>Delete</button></a></td>
                    <td><a href="/edit/${p.id}"><button>Edit</button></a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="/timtudien" method="post">
            <input type="text" name="timtudien">
            <button type="submit">Tim kiem</button>
            <input type="submit" value="">
        </form>
        <i>${kq}</i>
        <h1>Email Validate</h1>
        <h3 style="color:red">${message}</h3>
        <form action="/validate" method="post">
            <input type="text" name="email"><br>
            <button type="submit">Validate</button>
        </form>
        <h2>Current Local Times Around the World</h2>
        <span>Current time in ${city}: <strong>${date}</strong></span>
        <form id="locale" action="/worldclock" method="get">
            <select name="city" onchange="document.getElementById('locale').submit()">
                <option value="Asia/Ho_Chi_Minh">Select a city</option>
                <option value="Asia/Ho_Chi_Minh" selected>Ho Chi Minh</option>
                <option value="Singapore">Singapore</option>
                <option value="Asia/Hong_Kong">Hong Kong</option>
                <option value="Asia/Tokyo">Tokyo</option>
                <option value="Asia/Seoul">Seoul</option>
                <option value="Europe/London">London</option>
                <option value="Europe/Madrid">Madrid</option>
                <option value="America/New_York">New York</option>
                <option value="Australia/Sydney">Sydney</option>
                <option value="Argentina/Buenos_Aires">Buenos Aires</option>
            </select>
        </form>
        <form action="/saveCheckBox" method="get">
            <input type="checkbox" name="hello" id="lettuce" value="lettuce">
            <label for="lettuce"></label> lettuce
            <input type="checkbox" name="hello" id="tomato" value="tomato">
            <label for="tomato"></label> tomato
            <input type="checkbox" name="hello" id="murstard" value="murstard">
            <label for="murstard"></label> murstard
            <input type="checkbox" name="hello" id="sprout" value="sprout">
            <label for="sprout"></label> sprout
            <button type="submit" value="anhhau" name="a">Save</button>
        </form>
        <c:forEach items="${condiment}" var="c">
            <h4>${c}</h4>
        </c:forEach>
        <form action="/tinhtoan" method="get">
            <input type="text" name="input1" value="${value1}">
            <input type="text" name="input2" value="${value2}">
            <button type="submit" name="Caculate" value="cong">Addition(+)</button>
            <button type="submit" name="Caculate" value="tru">Subtraction(-)</button>
            <button type="submit" name="Caculate" value="nhan">Multiplication(x)</button>
            <button type="submit" name="Caculate" value="chia"> Division(/)</button>
        </form>
        <h3>${kq}</h3>
    </div>
</body>
</html>
