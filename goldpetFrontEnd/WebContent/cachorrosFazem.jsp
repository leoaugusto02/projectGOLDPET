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
						<nav class="navbar navbar-expand-md navbar-light minhaNav">
							<div class="w-100" id="navbarSupportedContent">
								<ul class="navbar-nav mr-auto menu ">
									<li class="nav-item active"><a class="nav-link" href="#">Home
											<span class="sr-only">(current)</span>
									</a></li>
									<li class="nav-item"><a class="nav-link" href="#">Doas�es</a></li>

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
			<div class="clearfix">
				<img class="img1" src="img/snow.jpg" alt="Fazem" width="800px"
					height="290px"> <br> <br>
				<p class="round">Por que os cachorros fazem xixi em p�?</p>
				<p class="texto">
					A maioria dos machos tem esse tipo de comportamento, muito embora
					algumas f�meas tamb�m. Muitos tutores imaginam que isso faz parte
					do processo que envolve a urina do c�o. Por�m, fazer xixi em p�
					est� ligado � necessidade de marcar territ�rio o que ocorre, em
					m�dia, a partir dos seis meses. <br> Segundo a veterin�rio,
					cachorros machos preferem as superf�cies verticais e se esfor�am
					para alcan�ar o ponto mais alto. � poss�vel observar tamb�m que
					esses animais urinam menos, mas mais vezes durante o passeio, para
					marcar um maior n�mero de locais. A urina de um animal cont�m
					muitos ferom�nios, que passam diversas informa��es e atraem outros
					animais. Esse sistema faz parte da natureza e da comunica��o do
					pet. Por isso, no passeio, deixe-o fazer todo xixi que quiser, sem
					acelerar. <br> Para ter um passeio mais tranquilo, sem que o
					peludo puxe a coleira, � necess�rio come�ar um treino dentro de
					casa. Veja tudo neste v�deo.
				</p>
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