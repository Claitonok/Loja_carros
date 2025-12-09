<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="./css/pagAltera.css">
<title>Altera Cadastro de Carros</title>
</head>
<body>

	<h1>Altera Cadastro de Carros</h1>

	<form action="LojaServlet" method="post">


		<div class="row mb-3">
			<!-- 			<label for="inputEmail3" class="col-sm-2 col-form-label">id</label>-->
			<div class="col-sm-10">
				<input type="hidden" name="txtid" value="${users.id}"
					class="form-control">
			</div>
		</div>


		<div class="row mb-3">
			<label for="inputEmail3" class="col-sm-2 col-form-label">marca</label>
			<div class="col-sm-10">
				<input type="text" name="txtmarca" value="${users.marca}"
					class="form-control">
			</div>
		</div>

		<div class="row mb-3">
			<label for="inputPassword3" class="col-sm-2 col-form-label">Modelo</label>
			<div class="col-sm-10">
				<input type="text" name="txtmodelo" value="${users.modelo}"
					class="form-control">
			</div>
		</div>

		<div class="row mb-3">
			<label for="inputPassword3" class="col-sm-2 col-form-label">Cor</label>
			<div class="col-sm-10">
				<input type="text" name="txtcor" value="${users.cor}"
					class="form-control">
			</div>
		</div>

		<div class="row mb-3">
			<label for="inputPassword3" class="col-sm-2 col-form-label">Km</label>
			<div class="col-sm-10">
				<input type="text" name="txtkm" value="${users.km}"
					class="form-control">
			</div>
		</div>

		<div class="row mb-3">
			<label for="inputPassword3" class="col-sm-2 col-form-label">Valor</label>
			<div class="col-sm-10">
				<input type="text" name="txtvalor" value="${users.valor}"
					class="form-control">
			</div>
		</div>

		<div class="row mb-3">
			<div class="col-sm-10 offset-sm-2">
				<div class="form-check">
					<input class="form-check-input" type="checkbox"> <label
						class="form-check-label" for="gridCheck1">Example checkbox</label>
				</div>
			</div>
		</div>

		<input type="hidden" name="acao" value="Altera"><br>
		<button type="submit" id="formButton" name="autentica"
			class="btn btn-primary">Alterar</button>
	</form>
	<br>
	<br>

	<div id="btn_mostrartodos">
		<a
			href="http://localhost:8080/loja_de_carros/LojaServlet?acao=mostratodos"><button
				class="btn btn-dark">Mostrar Todos</button></a>
	</div>


</body>
</html>