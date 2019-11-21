<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<style>
body {
	height: 900px;
	background-color: #8aedc2;
	background-image: linear-gradient(#139f97, white);
	background-repeat: no-repeat, repeat;
}

.conteudo {
	display: flex;
	flex-direction: row;
}

#esquerda {
	width: 15%;
	display: flex;
	flex-direction: column;
}

#direita {
	width: 15%;
	display: flex;
	flex-direction: column;
}

#meio {
	width: 70%;
	display: flex;
	flex-direction: column;
	background-image: linear-gradient(#139f97);
	background-repeat: no-repeat, repeat;
}

#cabecalho {
	display: flex;
	flex-direction: row;
	width: 100%;
}

#finalPg {
	float: bottom;
	width: 100%;
	height: 20%
}

.minhaNav {
	background-color: #139F97;
	margin-top: 6%;
	height: 30%;
}

#imgPet>img {
	border-radius: 70%;
	overflow: hidden;
	width: 150px;
	height: 150px;
	margin-left: 0.5%;
}

#customers {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#customers td, #customers th {
	border: 1px solid #ccd7e8;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #000000;
	color: white;
}

.menu {
	padding-right: 15px;
	width: 100%;
}

.menu>li {
	padding-left: 15px;
}

ul {
	list-style: none;
	padding: 0px;
	margin: 0px;
}

li {
	border-left: 4px solid black;
	margin-bottom: 2px;
	text-color: black;
	display: inline-block;
	padding: 5px 5px 5px 10px;
	display: inline-block;
}

li:hover {
	border-left: 4px solid grey;
}

a {
	color: black;
	text-decoration: none;
}
</style>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Pet's</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="conteudo">

		<div class="card card-splash"
			style="margin-top: 11.4%; width: 300px; height: 150px; background-color: rgba(199, 252, 255, 0.5);">
			<div id="esquerda">
				<div class="menuLateral">
					<ul>
						<a href="listAgenda.jsp">
							<li>Agenda</li>
						</a>

						<a href="listPets.jsp">
							<li>Adoções</li>
						</a>

						<a href="GerenciarUsuario.jsp">
							<li>Usuarios</li>
						</a>


					</ul>
				</div>
			</div>


		</div>
		<div id="meio">

			<div id="cabecalho">

				<div id="imgLogo">
					<img src="img/LogoPet.png" style="width: 220px; height: 220px;" />
				</div>

				<div class="navC d-flex w-100 justfy-content-center">

					<div class="w-100">
						<nav class="navbar navbar-expand-lg navbar-light minhaNav">
							<a class="navbar-brand" href="Index.jsp">Home</a>
							<button class="navbar-toggler" type="button"
								data-toggle="collapse" data-target="#navbarNavAltMarkup"
								aria-controls="navbarNavAltMarkup" aria-expanded="false"
								aria-label="Toggle navigation">
								<span class="navbar-toggler-icon"></span>
							</button>
							<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
								<div class="navbar-nav">
									<a class="nav-item nav-link active" href="adocao.jsp">adoção<span
										class="sr-only">(current)</span></a> <a class="nav-item nav-link "
										href="Resgate.jsp">resgate</a> <a
										class="nav-item nav-link active" href="DicasPets.jsp">Dicas</a>
									<a class="nav-item nav-link " href="questionPage.jsp">Forun</a>
									<a class="nav-item nav-link active" href="GerenciarUsuario.jsp">Dashboard</a>
									<a class="nav-item nav-link " href="AjudeOng.jsp">Ajude-nos</a>
								</div>
							</div>
						</nav>
					</div>
				</div>
			</div>

			<form>
				<div class="table" style="margin-bottom: 100px;">

					<table id="customers">

						<thead class="table-dark">
							<tr>
								<th name="nome">Nome Pet</th>
								<th>Porte</th>
								<th>Raça</th>
								<th>Adotado por</th>
								<th>E-mail</th>
								<th>Telefone</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Lily</td>
								<td>12</td>
								<td>labrador</td>
								<td>Helena</td>
								<td>helena@gmail.com</td>
								<td>99425155</td>

							</tr>
							<tr>
								<td>Toby</td>
								<td>2</td>
								<td>Pastor Alemão</td>
								<td>Henry</td>
								<td>henry@gmai.com</td>
								<td>38372512</td>
							</tr>
						</tbody>

					</table>

				</div>
			</form>

		</div>

		<div id="direita"></div>

	</div>


</body>
</html>