<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String message = null;
    String sessionID = null;
    String user;

    Cookie[] cookies = request.getCookies();

    if(cookies != null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("message")) message = cookie.getValue();
            if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
        }
    }
    user = (String)session.getAttribute("user");
%>
<html>
<head>
    <title>Vegan store</title>
    <link rel="stylesheet" href="../static/css/bootstrap.min.css"/>
</head>
<body>

<%@include file="headerLogout.jsp"%>
<div class="alert alert-primary" role="alert">
    <%=message%>, <%=user%>!
</div>


<div class="row h-50"><div class="w-75 mx-auto">
    <div class="w-25 mx-auto"><img src="../static/images/logo3.jpg" class="w-100"></div>
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
    <form action="LoadDataServlet" method="post" class="row g-3" style="margin-top: 50px; margin-left: 50px;">
        <div class="col-auto">
            <label for="file" class="visually-hidden">File name</label>
            <input type="text" readonly class="form-control-plaintext" id="file" value="File name">
        </div>
        <div class="col-auto">
            <label for="file2" class="visually-hidden">name.xml</label>
            <input type="text" class="form-control" id="file2" name="fileName" value="products.xml">
        </div>
        <div class="col-auto">
            <button type="submit" class="btn btn-success mb-3">Load</button>
        </div>
    </form>
</div></div>
</body>
</html>
