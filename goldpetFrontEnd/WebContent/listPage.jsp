<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
body {
	height: 900px;
	background-color: #8aedc2;
	background-image: linear-gradient(#8aedc2, white);
	background-repeat: no-repeat, repeat;
}

.userDiv {
	width: 10%;
	height: 100%;
	text-align: center;
	display: inline-block;
	padding-top: 1%;
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
	background-color: #8aedc2;
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

.questionDiv {
	width: 90%;
	height: 100%;
	float: right;
}

.answerDiv {
	width: 90%;
	height: 100%;
	float: right;
	padding-top: 2%
}

.menulateral {
	/*margin-top: 10px;
			margin-left: 15px;*/
	background-color: lightgreen;
	display: inline-block;
	width: 20%;
	height: 75%;
}

#a {
	color: black;
	text-decoration: none;
}
</style>
<head>
<meta charset="UTF-8" />
<meta charset="ISO-8859-1">
<title>Listas</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<div id="cabecalho">

		<div id="imgLogo">
			<img src="img/LogoPet.png" style="width: 220px; height: 220px;" />
		</div>

		<div class="navC d-flex w-100 justfy-content-center">

			<div class="w-100">
				<nav class="navbar navbar-expand-lg navbar-light minhaNav">
					<a class="navbar-brand" href="Index.jsp">Home</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarNavAltMarkup"
						aria-controls="navbarNavAltMarkup" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
						<div class="navbar-nav">
							<a class="nav-item nav-link active" href="adocao.jsp">Adoção<span
								class="sr-only">(current)</span></a> <a class="nav-item nav-link "
								href="Resgate.jsp">Resgate</a> <a
								class="nav-item nav-link active" href="DicasPets.jsp">Dicas</a>
							<a class="nav-item nav-link active" href="GerenciarUsuario.jsp">Dashboard</a>
							<a class="nav-item nav-link active" href="Login.jsp">Login</a> <a
								class="nav-item nav-link active" href="perfil.jsp">Perfil</a> <a
								class="nav-item nav-link " href="AjudeOng.jsp">Ajude-nos</a>
						</div>
					</div>
				</nav>
			</div>
		</div>
	</div>

	</div>
	<br>
	<br>

	<div class="container" style="margin-left: 28%;" onclick="responder()">
		<div class="menulateral"></div>
		<br>
		<div class="card text-dark bg-light  mb-6 " style="max-width: 49rem;">
			<div class="card-header bg-transparent border-light "></div>

			<div class="card-title">
				<h1></h1>
			</div>
			<div class="card-footer bg-transparent border-info"></div>
		</div>
	</div>

</body>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</html>