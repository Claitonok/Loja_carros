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
<link rel="ICON" type="ICON" sizes="20x20"
	href="https://images.icon-icons.com/20/PNG/256/business_application_addmale_useradd_insert_add_user_client_2312.png">
<link rel="stylesheet" href="./css/pagAtualiza_users.css">
<title>Atualizando Cadastro</title>
</head>
<body>

	<header>
		<div id="cabecalho">
			<h1>Atualizando Cadastro</h1>
			<a href="http://localhost:8080/loja_de_carros/"><button
					class="btn btn-success">Home</button></a>
		</div>
	</header>


	<form action="LojaServlet" method="post">

		<input type="hidden" name="txtid" value="${retorno_user.id}">

		<div class="row mb-3">
			<label for="inputEmail3" class="col-sm-2 col-form-label">Nome</label>
			<div class="col-sm-10">
				<input type="text" name="txtnome" class="form-control"
					id="inputEmail3" required="required">
			</div>
		</div>

		<div class="row mb-3">
			<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
			<div class="col-sm-10">
				<input type="email" name="txtemail" class="form-control"
					id="inputEmail3" value="${retorno_user.email}" required="required">
			</div>
		</div>

		<div class="row mb-3">
			<label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
			<div class="col-sm-10">
				<input type="password" name="txtsenha" class="form-control"
					id="inputPassword3" required="required">
			</div>
		</div>

		<div class="row mb-3">
			<div class="col-sm-10 offset-sm-2">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" id="gridCheck1">
					<label class="form-check-label" for="gridCheck1">Politicas
						do site</label>
				</div>
			</div>
		</div>
		<input type="hidden" name="acao" value="User_atualiza"><br>
		<button type="submit" name="autentica" class="btn btn-primary">Atualizar
			Cadastrar</button>
	</form>

</body>
</html>

