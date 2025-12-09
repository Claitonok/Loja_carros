<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--http://localhost:8080/loja_de_carros/-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT"
	crossorigin="anonymous">

<link rel="ICON" type="ICON" sizes="16x16"
	href="https://images.icon-icons.com/94/PNG/512/car_repair_16784.png">
<link rel="stylesheet" type="text/css" href="./css/pagInicio.css">
<title>Loja</title>
</head>
<body>

	<h1>Sign-Loja</h1>


	<form action="LojaServlet" method="post">

		<label for="inputEmail" class="col-sm-5 col-form-label">Email</label>
		<div class="">
			<input type="email" name="txtemail" class="form-control"
				value="claiton@gmail.com">
		</div>

		<label for="inputPassword" class="col-sm-5 col-form-label">Password</label>
		<div class="">
			<input type="password" name="txtsenha" class="form-control"
				value="147">
		</div>


		<c:if test="${not empty responta_para_uses}">
			<span>${responta_para_uses}</span>
		</c:if>


			<div class="checkbox">
				<input class="form-check-input" type="checkbox" id="gridCheck1">
				<label class="form-check-label" for="gridCheck1">Example
					checkbox</label>
			</div>


		<div class="Sign-in">
			<input type="hidden" name="acao" value="login"><br>
			<button type="submit" name="autentica" class="btn btn-primary">Sign-in</button>
		</div>

	</form>

	<div id="link_cadastra">
		<a href="http://localhost:8080/loja_de_carros/LojaServlet?acao=pag_cadastra_user">register-se</a>
	</div>

</body>
</html>

