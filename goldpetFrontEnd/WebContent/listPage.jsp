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
	height:20%
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
				<nav class="navbar navbar-expand-md navbar-light minhaNav">
					<div class="w-100" id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto menu ">
							<li class="nav-item active"><a class="nav-link" href="#">Home
									<span class="sr-only">(current)</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Doações</a></li>

							<li class="nav-item"><a class="nav-link" href="#">Resgate</a></li>

							<li class="nav-item"><a class="nav-link" href="#">Adoção</a></li>

							<li class="nav-item"><a class="nav-link" href="#">Sobre
									Nós</a></li>

							<li class="nav-item"><a class="nav-link" href="#">Cadastrar
									Pet</a></li>

							<li class="nav-item"><a class="nav-link" href="#">Forum</a></li>

						</ul>
					</div>
				</nav>
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