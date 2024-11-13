<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cylinder Volume Calculator</title>
    <link rel="stylesheet" href="https://m2.material.io/components/cards">
</head>
<body>
<%@ include file="main-nav.jsp"%>
<form action="volume" method="post">
    <label for="radius">Radius:</label>
    <input type="text" id="radius" name="radius">
    <br>
    <label for="height">Height:</label>
    <input type="text" id="height" name="height">
    <br>
    <button type="submit">Calculate Volume</button>
</form>
<h2>Calculation Result</h2>
<div class="card">
    <p>${cylinder}</p>
</div>

<p style="color:red;">${error}</p>
</body>
</html>

