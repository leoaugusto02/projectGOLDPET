<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
</style>
<head>
<meta charset="ISO-8859-1">
<title>Página Inicial</title>
<!-- <link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css"> -->


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<style>
body, html {
	margin: 0;
	padding: 0;
	display: flex;
	flex-direction: row;
	width: 100%;
	height: 100%;
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

#cabecalho {
	display: flex;
	flex-direction: row;
	width: 100%;
}

.navC {
	text-align: center;
	display: flex;
	flex-direction: row;
	width: 80%;
	position: left;
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

.img-thumbnail {
	padding: 0rem;
	background-color: #fff;
	border: 1px solid #dee2e6;
	border-radius: .25rem;
	max-width: 100%;
	height: auto;
}

.dogF {
	
}
</style>
</head>
<body background="img/bgPet.png">

	<div id="esquerda"></div>
	<div id="meio">

		<div id="cabecalho">

			<div id="imgLogo">
				<img src="img/LogoPet.png" style="width: 220px; height: 220px;" />
			</div>


			<div class="navC d-flex w-100 justfy-content-center">

					<div class="w-100">
						<nav class="navbar navbar-expand-lg navbar-light minhaNav">
							<a class="navbar-brand" href="#">Home</a>
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
										class="nav-item nav-link active" href="DicasPets">Dicas</a> <a
										class="nav-item nav-link " href="questionPage">Forun</a> <a
										class="nav-item nav-link active" href="GerenciarUsuario.jsp">Dashboard</a>
									<a class="nav-item nav-link " href="AjudeOng.jsp">Ajude-nos</a>
								</div>
							</div>
						</nav>
					</div>
				</div>

		</div>


		<div id="carouselSite" class="carousel slide" data-ride="carousel">

			<ol class="carousel-indicators">
				<li data-target="#carouselSite" data-slide-to="0" class="active"></li>
				<li data-target="#carouselSite" data-slide-to="1"></li>
				<li data-target="#carouselSite" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">
				<div class="carousel-item active">

					<img class="d-block w-100" src="img/slide01.png"
						style="height: 500px" class="img-fluid d-block">

				</div>

				<div class="carousel-item">

					<img class="d-block w-100" src="img/slide02.png"
						style="height: 500px" class="img-fluid d-block">

				</div>

				<div class="carousel-item">

					<img class="d-block w-100" src="img/slide01.jpg"
						style="height: 500px" class="img-fluid d-block">

				</div>

			</div>

			<a class="carousel-control-prev" href="#carouselSite" role="button"
				data-slide="prev"> <span class="carousel-control-prev-icon"></span>
				<span class="sr-only">Anterior</span>
			</a> <a class="carousel-control-next" href="#carouselSite" role="button"
				data-slide="next"> <span class="carousel-control-next-icon"></span>
				<span class="sr-only">Avançar</span>
			</a>

		</div>

		<div id="dogF">

			<h4 style="margin-top: 2%;">Dogs para doação</h4>

			<div id="imgPet" class="row">
				<img src="img/slide02.png" alt="slide02.png" class="img-thumbnail">
				<img src="img/slide01.png" alt="slide01.png" class="img-thumbnail">
				<img src="img/slide02.png" alt="slide02.png" class="img-thumbnail">
				<img src="img/slide01.png" alt="slide01.png" class="img-thumbnail">
				<img src="img/slide02.png" alt="slide02.png" class="img-thumbnail">

			</div>

		</div>


	</div>


	</div>
	<div id="direita"></div>

	<!-- <script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.3.1.min.js"></script> -->

</body>
</html>