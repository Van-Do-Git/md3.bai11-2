<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 8/23/2021
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show All Products</title>
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

        button.creat {
            width: 120px;
            background-color: cadetblue;
            height: 40px;
            color: lightcyan;
        }

        button {
            width: 100px;
            background-color: cadetblue;
            height: 30px;
            color: lightcyan;
        }

        .edit {
            background-color: orange;
        }

        .delete {
            background-color: red;
        }
    </style>
</head>
<body>
<h1>Danh sách các sản phẩm</h1>
<a href="/Products?action=creat">
    <button class='creat'> Thêm sản phẩm</button>
</a>
<table>
    <thead>
    <tr>
        <th>
            ID
        </th>
        <th>
            Tên sản phẩn
        </th>
        <th>
            Hình Ảnh
        </th>
        <th>
            Giá
        </th>
        <th>
            Sửa
        </th>
        <th>
            Xóa
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${productlist}" var="product">
        <tr>
            <td>
                    ${product.id}
            </td>
            <td>
                <a href="/Products?action=view&id=${product.getId()}"> ${product.name}</a>
            </td>
            <td>
                <img src="${product.url}" sizes="20" width='60' height='60'>
            </td>
            <td>
                    ${product.price}
            </td>
            <th>
                <a href="/Products?action=update&id=${product.getId()}">
                    <button class='edit'> Sửa</button>
                </a>
            </th>
            <th>
                <a href="/Products?action=delete&id=${product.getId()}">
                    <button class='delete'> Xóa</button>
                </a>
            </th>

        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/Products?action=search">
    <button class='edit'> Search</button>
</a>
</body>
</html>
