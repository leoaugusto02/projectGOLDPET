<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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

.menu {
	padding-right: 15px;
	width: 100%;
}

.menu>li {
	padding-left: 15px;
}

p.round {
	text-align: center;
	width: 400px;
	height: 50px;
	margin-left: 220px;
	font-size: 35px;
	color: white;
	text-shadow: 1px 1px 2px black, 0 0 25px blue, 0 0 5px darkblue;
}

.clearfix {
	margin-left: 250px;
	width: 600px;
	height: 225px;
}

.texto {
	margin-left: 10px;
	width: 800px;
	height: 225px;
	font-size: 18px;
}
</style>
<head>
<meta charset="UTF-8" />
<meta charset="ISO-8859-1">
<title>Levar no Veterinario</title>
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
			<div class="clearfix">
				<img class="img1" src="img/veterinario.png" alt="Veterinario"
					width="800px" height="290px"> <br> <br>
				<p class="round">Olfatos</p>
				<p class="texto">
					Sabe com que frequência deve levar seu cãozinho ao veterinário?
					Essa é uma pergunta muito comum entre as mamães de quatro patas,
					por isso, daremos a resposta e mencionaremos a importância do
					check-up no seu melhor amigo! <br> Quando ainda jovens, os
					cães devem realizar os exames de rotina anualmente para verificar a
					saúde do animal – mesmo que não apresente sintomas de doenças. É
					importante que este período seja respeitado, pois uma visita ao
					veterinário garante a prevenção e/ou identificação de enfermidades
					que podem leva-lo à morte. <br> Já os cachorros idosos, a
					partir dos oito anos, devem realizar o check-up a cada seis meses.
					As mamães devem respeitar essa periodicidade, tendo em vista que a
					imunidade do animal diminui e a contração de doenças pode ser maior
					<br> Reconhecer a importância de visitar um médico veterinário
					frequentemente é uma das maiores demonstrações de amor e carinho
					que pode ter com o peludinho!
				</p>
				<br>
				<br>
				<br>
				<br>
				<br>
				<button type="button" class="btn btn-primary">Voltar</button>
			
			</div>
			</div>
			</div>
</body>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</html>