<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	margin-left: 180px;
	font-size: 21px;
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
	font-size: 17px;
}
</style>
<head>
<meta charset="UTF-8" />
<meta charset="ISO-8859-1">
<title>Cachorros fazem</title>
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
									<a class="nav-item nav-link active" href="adocao.jsp">Adoção<span
										class="sr-only">(current)</span></a> 
										<a class="nav-item nav-link " href="Resgate.jsp">Resgate</a> <a
										class="nav-item nav-link active" href="DicasPets.jsp">Dicas</a>
									<a class="nav-item nav-link active" href="GerenciarUsuario.jsp">Dashboard</a>
									<a class="nav-item nav-link active" href="Login.jsp">Login</a>
									<a class="nav-item nav-link active" href="perfil.jsp">Perfil</a>
									<a class="nav-item nav-link " href="AjudeOng.jsp">Ajude-nos</a>
								</div>
							</div>
						</nav>
					</div>
				</div>
			</div>
			</div>
			<div class="clearfix">
				<img class="img1" src="img/snow.jpg" alt="Fazem" width="800px"
					height="290px"> <br> <br>
				<p class="round">Por que os cachorros fazem xixi em pé?</p>
				<p class="texto">
					A maioria dos machos tem esse tipo de comportamento, muito embora
					algumas fêmeas também. Muitos tutores imaginam que isso faz parte
					do processo que envolve a urina do cão. Porém, fazer xixi em pé
					está ligado à necessidade de marcar território o que ocorre, em
					média, a partir dos seis meses. <br> Segundo a veterinário,
					cachorros machos preferem as superfícies verticais e se esforçam
					para alcançar o ponto mais alto. É possível observar também que
					esses animais urinam menos, mas mais vezes durante o passeio, para
					marcar um maior número de locais. A urina de um animal contém
					muitos feromônios, que passam diversas informações e atraem outros
					animais. Esse sistema faz parte da natureza e da comunicação do
					pet. Por isso, no passeio, deixe-o fazer todo xixi que quiser, sem
					acelerar. <br> Para ter um passeio mais tranquilo, sem que o
					peludo puxe a coleira, é necessário começar um treino dentro de
					casa. Veja tudo neste vídeo.
				</p>
				<br> <br>
				<button type="button" class="btn btn-primary">Voltar</button>

			</div>
		</div>
	</div>
</body>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</html>