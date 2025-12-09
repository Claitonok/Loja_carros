<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT"
	crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="./css/pagAltera_users.css">
<title>Altera Cadastro</title>
</head>
<body>

<header>
<div id="cabecalho">
<h1>Altera Cadastro</h1>
<a href="http://localhost:8080/loja_de_carros/"><button class="btn btn-success">Home</button></a>
</div>
</header>



	<form action="LojaServlet" method="post">
		
		<div class="row mb-3">
			<label for="inputEmail3" class="col-sm-2 col-form-label">Email:</label>
			<div class="col-sm-10">
				<input type="email" name="txtemail" class="form-control" value="claiton@gmail.com"
					id="inputEmail3" required="required">
			</div>
			
	<c:if test="${not empty validade}">
		<span class='alert alert-danger'>${validade}</span>
	</c:if>
	
	<c:if test="${not empty resp}">
		<span class='alert alert-danger'>${resp}</span>
	</c:if>
			
		</div>
		
		
		<input type="hidden" name="acao" value="Validar_email_User"><br>
		<button type="submit" name="autentica" class="btn btn-primary">Alterar a senha</button>
</form>


</body>
</html>