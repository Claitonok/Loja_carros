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
<link rel="ICON" type="ICON" sizes="20x20"
	href="https://images.icon-icons.com/94/PNG/512/car_repair_16784.png">
<link rel="stylesheet" href="./css/pagMostraTodos.css">
<title>Loja de Carros</title>
</head>
<body>

	<header>
		<div class="cabecalho">
			<h4 id="saudacao">
				Seja bem-vindo(a): | <span>${resposta.nome}</span>
			</h4>
			<a
				href="http://localhost:8080/loja_de_carros/LojaServlet?acao=logout"><button
					class="btn btn-danger">Sair do Sistema</button></a>
		</div>
	</header>


	<c:if test="${not empty listUsers}">
		<table class="table">
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Marca</th>
				<th scope="col">Modelo</th>
				<th scope="col">Cor</th>
				<th scope="col">Km</th>
				<th scope="col">Valor</th>
			</tr>
			<tbody>
				<c:forEach var="ListUser" items="${listUsers}">
					<tr>
						<th scope="row">${ListUser.id}</th>
						<td>${ListUser.marca}</td>
						<td>${ListUser.modelo}</td>
						<td>${ListUser.cor}</td>
						<td>${ListUser.km}</td>
						<td>${ListUser.valor}</td>
						<td><a href="LojaServlet?acao=altera&id=${ListUser.id}"><button
									class="btn btn-primary">Alterar</button></a></td>
						<td><a href="LojaServlet?acao=excluir&id=${ListUser.id}"><button
									class="btn btn-danger">Excluir</button></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div id="btn_cadastra">
			<a
				href="http://localhost:8080/loja_de_carros/LojaServlet?acao=pag_cadastra_carro"><button
					class="btn btn-success">Cadastrar</button></a>
		</div>
		<br>
		<br>
		<footer>
			<div id="pagination">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
					
					<c:if test="${not empty paginaInicio}">
						<li class="page-item"><a class="btn btn-primary"
	href="http://localhost:8080/loja_de_carros/LojaServlet?acao=mostratodos&idPag=${paginaInicio}">Previous</a></li>
					</c:if> 
					
					<c:forEach var="i" begin="10" end="100" step="10">
						<li class="page-item"><a class="btn btn-secondary"
						href="http://localhost:8080/loja_de_carros/LojaServlet?acao=mostratodos&idPag=${i}">${i}</a></li>
					</c:forEach>
						
				<c:if test="${not empty pagFinal}"> 
						<li class="page-item"><a class="btn btn-primary"
	href="http://localhost:8080/loja_de_carros/LojaServlet?acao=mostratodos&idPag=${pagFinal}">Next</a></li>
				</c:if>
					
					</ul>
				</nav>
			</div>
		</footer>
	</c:if>


	<c:if test="${empty listUsers}">
		<h1>NENHUM CARRO CADASTRADO</h1>
		<a
			href="http://localhost:8080/loja_de_carros/LojaServlet?acao=pag_cadastra_carro"><button
				class="btn btn-primary">Cadastrar</button></a>
	</c:if>

	<!-- http://localhost:8080/loja_de_carros/LojaServlet?acao=mostratodos -->

</body>
</html>