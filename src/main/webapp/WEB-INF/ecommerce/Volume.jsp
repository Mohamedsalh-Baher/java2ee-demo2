<jsp:useBean id="result" scope="request" type=""/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cylinder Volume Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%@include file="../../main-nav.jsp" %>
<div class="container mt-5">
    <h1 class="text-center">Cylinder Volume Calculator</h1>
    <form action="Volume.jsp" method="post" class="mt-4">
        <div class="mb-3">
            <label for="radius" class="form-label">Radius</label>
            <input type="text" id="radius" name="radius" class="form-control" placeholder="Enter radius in units">
        </div>
        <div class="mb-3">
            <label for="height" class="form-label">Height</label>
            <input type="text" id="height" name="height" class="form-control" placeholder="Enter height in units">
        </div>
        <button type="submit" class="btn btn-primary">Calculate Volume</button>
    </form>
    <div class="mt-4">
        <h2>Result:</h2>
        <p>${result}</p>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>

