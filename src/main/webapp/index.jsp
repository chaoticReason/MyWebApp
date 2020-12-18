<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <title>Load data</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css"/>
</head>
<div class="row h-100">
<div class="w-50 mx-auto my-auto">
<form class="w-100" action="LoginServlet" method="post">
    <div class="mb-3">
        <label for="inputUsername" class="form-label">User</label>
        <input type="text" class="form-control" id="inputUsername" placeholder="Username" name="username">
    </div>
    <div class="mb-3">
        <label for="inputPassword" class="form-label">Password</label>
        <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="password">
    </div>
    <div class="col-12">
        <button class="btn btn-success" type="submit">Login</button>
    </div>
</form>
</div></div>
</body>
</html>