<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Vegan store</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css"/>
</head>
<body>
<div class="row h-50"><div class="w-75 mx-auto">
    <div class="w-25 mx-auto"><img src="static/images/logo3.jpg" class="w-100"></div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Category</th>
            <th scope="col">Flavour</th>
            <th scope="col">Country</th>
            <th scope="col">Cost</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${products != null}">
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.category}</td>
                    <td>${product.flavour}</td>
                    <td>${product.country}</td>
                    <td>${product.cost}</td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
</div></div>
</body>
</html>
