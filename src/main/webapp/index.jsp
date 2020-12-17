<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Load data</title>
    <link rel="stylesheet" href="static/css/bootstrap.min.css"/>
</head>
<body>
<form action="load-data" method="post" class="row g-3" style="margin-top: 50px; margin-left: 50px;">
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

</body>
</html>