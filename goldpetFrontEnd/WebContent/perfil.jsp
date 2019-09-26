<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<style>
body, html {
	margin: 0;
	padding: 0;
	display: flex;
	flex-direction: row;
	width: 100%;
	height: 100%;
}

.navC {
	text-align: center;
	display: flex;
	flex-direction: row;
	width: 80%;
	position: left;
}

#cabecalho {
	display: flex;
	flex-direction: row;
	width: 100%;
}

.minhaNav {
	background-color: #139F97;
	margin-top: 6%;
	height: 30%;
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
}
</style>

<meta charset="ISO-8859-1">

<title>Meu Perfil</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div id="esquerda"></div>
	<div id="meio">

		<div class= "container">
			<div id="cabecalho">

				<div id="imgLogo">
					<img src="img/LogoPet.png" style="width: 220px; height: 220px;" />
				</div>

				<div class="navC">
					<div class="d-flex">
						<nav class="navbar navbar-expand-lg navbar-light minhaNav">
							<div class="collapse navbar-collapse" id="navbarSupportedContent">
								<ul class="navbar-nav mr-auto">
									<li class="nav-item active"><a class="nav-link" href="#">Home
											<span class="sr-only">(current)</span>
									</a></li>
									<li class="nav-item"><a class="nav-link" href="#">Doações</a></li>

									<li class="nav-item"><a class="nav-link" href="#">Resgate</a></li>

									<li class="nav-item"><a class="nav-link" href="#">Sobre
											Nós</a></li>

									<li class="nav-item"><a class="nav-link" href="#">Cadastrar
											Pet</a></li>
								</ul>
							</div>
						</nav>
					</div>
				</div>

			</div>
			<br>
			<div class="col-xs-12 col-sm-9">

				<!-- User profile -->
				<div class="container">
					<div style="text-align: center">
						<h2>GUARDIÃO</h2>
						<div id="imgLogo">
							<img src="img/escudo.png" style="width: 220px; height: 220px;" />
							<div style="margin: -80px 0px 0px 200px">
								<img src="img/escudo.png" style="width: 80px; height: 60px;" />
							</div>
						</div>
						<h4>NICKNAME</h4>
					</div>

				</div>

				<br>
				<!-- User info -->
				<div class="container">
					<div class="card  mb-8">

						<h4 class="card-header">Informações Usuario</h4>

						<div class="panel-body" border="3px">
							<table class="table profile__table">
								<tbody>
									<tr>
										<th><strong>Nome:</strong><label></label></th>
									</tr>
									<tr>
										<th><strong>Data de Nascimento:</strong></th>
									</tr>
									<tr>
										<th><strong>Genero: </strong></th>
									</tr>
									<tr>
										<th><strong>Telefone: </strong></th>
									</tr>
									<tr>
										<th><strong>Email:</strong></th>
									</tr>
									<tr>
										<th><strong>Endereço:</strong></th>
									</tr>
									<tr>
										<th><strong>Rank:</strong></th>
									</tr>
									<tr>
										<th><strong>Animais Resgatados:</strong></th>
									</tr>
								</tbody>
							</table>

						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<div id="direita"></div>

	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>