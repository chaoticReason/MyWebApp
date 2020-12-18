<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String error = (String)request.getAttribute("error");
%>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" href="../static/css/bootstrap.min.css"/>
</head>
<body>
<div class="row h-100"><div class="w-25 mx-auto my-auto">
    <h2 class="text-success">Error: <%=error%></h2>
    <img src="../static/images/logo4.jpg" width="225"/>
</div></div>

</body>
</html>
