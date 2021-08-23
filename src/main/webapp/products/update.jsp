<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 8/23/2021
  Time: 11:36 PM
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
            width: 180px;
        }

        td {
            text-align: center;
            border: 1px;
            border-style: solid;
            width: 180px;
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

        input {
            width: 100%;
            box-sizing: border-box;
        }
    </style>
</head>
<body>
<c:if test='${message !=null}'>
    <span class="message">${message}</span>
</c:if>
<form method="post">
    <fieldset>
        <table>
            <tr>
                <th>
                    ID
                </th>
                <th>
                    Tên sản phẩn
                </th>
                <th>
                    Hình ảnh
                </th>
                <th>
                    Giá
                </th>
            </tr>
            <tr>
                <td>
                    ${product.id}
                </td>
                <td>
                    <input type="text" name="name" value="${product.name}"/>
                </td>
                <td>
                    <input type="text" name="url" value="${product.url}"/>
                </td>
                <td>
                    <input type="number" name="price" value="${product.price}"/>
                </td>
            </tr>
        </table>
        <button type="submit">Cập nhật</button>
    </fieldset>
</form>
<a href="Products">
    <button>Quay về trang chủ</button>
</a>
</body>
</html>
