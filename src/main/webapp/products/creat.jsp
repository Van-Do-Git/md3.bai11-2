<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 8/23/2021
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Creat</title>
    <style>
        th {
            background-color: chartreuse;
            height: 50px;
            width: 128px;
        }

        td {
            text-align: center;
            border: 1px;
            border-style: solid;
            width: 150px;
            border-color: green;
        }

        tr {
            text-align: center;
        }

        input {
            border-style: none;
        }

        fieldset {
            background-color: lightcyan;
        }

        legend {
            color: green;;
        }

        button {
            width: 100px;
            background-color: cadetblue;
            height: 35px;
            color: lightcyan;
        }

        .message {
            color: green;
            font-size: 30px;
        }
    </style>
</head>
<body>
<c:if test='${message !=null}'>
    <span class="message">${message}</span>
</c:if>
<form method="post">
    <fieldset style="width: 300px;">
        <legend>Creat a new product</legend>
        <table>
            <tr>
                <td>
                    NameProduct:
                </td>
                <td>
                    <input type="text" name="name">
                </td>
            </tr>
            <tr>
                <td>
                    Dicreption:
                </td>
                <td>
                    <input type="text" name="url">
                </td>
            </tr>
            <tr>
                <td>
                    Quantity:
                </td>
                <td>
                    <input type="number" name="price">
                </td>
            </tr>
        </table>
        <button style="left: 198px;position: relative" type="submit">Tạo mới</button>

    </fieldset>
</form>
<a href="/Products">
    <button style="left: 215px;position: relative">Quay về trang chủ</button>
</a>
</body>
</html>
