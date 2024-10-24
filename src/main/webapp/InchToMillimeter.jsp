<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inch to Millimeter Converter</title>
</head>
<body>
<%@ include file="main-nav.jsp"%>
<h1>Inch to Millimeter Conversion</h1>
<form action="convert" method="POST">
    <label for="inches">Enter value in inches:</label>
    <input type="text" id="inches" name="inches" required>
    <input type="submit" value="Convert">
</form>
</body>
</html>
// update

 