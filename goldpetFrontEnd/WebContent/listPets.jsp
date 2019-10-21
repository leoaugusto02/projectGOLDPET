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
	background-image: url("img/bgDireita.png")
}

#direita {
	width: 15%;
	display: flex;
	flex-direction: column;
	background-image: url("img/bgDireita.png");
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

		<div id="esquerda"></div>
		<div id="meio">

			<div id="cabecalho">

				<div id="imgLogo">
					<img src="img/LogoPet.png" style="width: 220px; height: 220px;" />
				</div>

				<div class="navC d-flex w-100 justfy-content-center">

					<div class="w-100">
						<nav class="navbar navbar-expand-md navbar-light minhaNav">
							<div class="w-100" id="navbarSupportedContent">
								<ul class="navbar-nav mr-auto menu ">
									<li class="nav-item active"><a class="nav-link" href="#">Home
											<span class="sr-only">(current)</span>
									</a></li>
									<li class="nav-item"><a class="nav-link" href="#">Doa��es</a></li>

									<li class="nav-item"><a class="nav-link" href="#">Resgate</a></li>

									<li class="nav-item"><a class="nav-link" href="#">Ado��o</a></li>

									<li class="nav-item"><a class="nav-link" href="#">Sobre
											N�s</a></li>

									<li class="nav-item"><a class="nav-link" href="#">Cadastrar
											Pet</a></li>

									<li class="nav-item"><a class="nav-link" href="#">Forum</a></li>

								</ul>
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
								<th>Ra�a</th>
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
								<td>Pastor Alem�o</td>
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