<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Login page</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body style="text-align: center;">
	<h2>login</h2>
	<form:form action="loginprocesing" method="post">
		<input name="username" type="text" placeholder="login" />
		<input name="password" type="password" placeholder="password" />
		<button>login</button>
	</form:form>
</body>
</html>