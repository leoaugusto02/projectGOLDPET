<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
</style>
<head>
<meta charset="ISO-8859-1">
<title>Adoção</title>
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
	flex-direction: column;
	width: 100%;
	height: 100%;
	overflow-x: hidden;
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
	background-color: #c7fcff;
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

#infoDog {
	
}

.card {
	box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.40), 0 2px 10px 0
		rgba(0, 0, 0, 0.40) !important;
}

.minhaNav {
	background-color: #139F97;
	margin-top: 6%;
	height: 30%;
}

.menu {
	padding-right: 15px;
	width: 100%;
}

.menu>li {
	padding-left: 15px;
}

#a{
	color:black;
	text-decoration: none;

}
</style>
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

			<div class="d-flex justify-content-around">
				<div id="infoDog">
					<div class="card bg-dark text-white" style="width: 23rem;">
						<img src="img/slide01.png" class="card-img" href="#"
							style="height: 500px;">
						<div class="card-img-overlay">
							<h5 class="card-title">Nome do dogzin</h5>
							<p class="card-text">Informaçoes basicas sobre o dogzin
								clicando na imagem ira para o perfil dele para ver os laudos
								medicos e saber mais sobre o dog</p>
							<p class="card-text">Last updated 3 mins ago</p>
						</div>
					</div>
				</div>


				<div class="card bg-dark text-white" style="width: 23rem;">
					<img src="img/slide01.png" class="card-img" href="#"
						style="height: 500px;">
					<div class="card-img-overlay">
						<h5 class="card-title">Nome do dogzin</h5>
						<p class="card-text">Informaçoes basicas sobre o dogzin
							clicando na imagem ira para o perfil dele para ver os laudos
							medicos e saber mais sobre o dog</p>
						<p class="card-text">Last updated 3 mins ago</p>
					</div>
				</div>

				<div class="card bg-dark text-white" style="width: 23rem;">
					<img src="img/slide01.png" class="card-img" href="#"
						style="height: 500px;">
					<div class="card-img-overlay">
						<h5 class="card-title">Nome do dogzin</h5>
						<p class="card-text">Informaçoes basicas sobre o dogzin
							clicando na imagem ira para o perfil dele para ver os laudos
							medicos e saber mais sobre o dog</p>
						<p class="card-text">Last updated 3 mins ago</p>
					</div>
				</div>
			</div>
			
			<div class="d-flex justify-content-around" style="margin-top:2%;">
				<div id="infoDog">
					<div class="card bg-dark text-white" style="width: 23rem;">
						<img src="img/slide01.png" class="card-img" href="#"
							style="height: 500px;">
						<div class="card-img-overlay">
							<h5 class="card-title">Nome do dogzin</h5>
							<p class="card-text">Informaçoes basicas sobre o dogzin
								clicando na imagem ira para o perfil dele para ver os laudos
								medicos e saber mais sobre o dog</p>
							<p class="card-text">Last updated 3 mins ago</p>
						</div>
					</div>
				</div>


				<div class="card bg-dark text-white" style="width: 23rem;">
					<img src="img/slide01.png" class="card-img" href="#"
						style="height: 500px;">
					<div class="card-img-overlay">
						<h5 class="card-title">Nome do dogzin</h5>
						<p class="card-text">Informaçoes basicas sobre o dogzin
							clicando na imagem ira para o perfil dele para ver os laudos
							medicos e saber mais sobre o dog</p>
						<p class="card-text">Last updated 3 mins ago</p>
					</div>
				</div>

				<div class="card bg-dark text-white" style="width: 23rem;">
					<img src="img/slide01.png" class="card-img" href="#"
						style="height: 500px;">
					<div class="card-img-overlay">
						<h5 class="card-title">Nome do dogzin</h5>
						<p class="card-text">Informaçoes basicas sobre o dogzin
							clicando na imagem ira para o perfil dele para ver os laudos
							medicos e saber mais sobre o dog</p>
						<p class="card-text">Last updated 3 mins ago</p>
					</div>
				</div>
			</div>
			



		</div>

		<div id="direita"></div>

	</div>
	<!-- <script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.3.1.min.js"></script> -->

</body>