<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
body {
	display: flex;
	justify-content: center
}
</style>
<title>Select parser</title>
</head>
<body>
	<form action="FrontController" method="get" id="form">
			<input type="submit" name="parser_type" value="SAX">
			<input type="submit" name="parser_type" value="StAX">
			<input type="submit" name="parser_type" value="DOM">
	</form>
</body>
</html>