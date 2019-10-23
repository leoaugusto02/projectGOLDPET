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

.conteudo {s
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
<title>Dormir com Pet</title>
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
			<div class="clearfix">
				<img class="img1" src="img/dormir.jpg" alt="Dormir" width="800px"
					height="290px"> <br> <br>
				<p class="round">Dormir com Pet</p>
				<p class="texto">
					Tem bicho que parece gente, domina a casa toda, desde o sof� at� a
					cama, e ignora todo e qualquer limite de espa�o. Mas, convenhamos,
					h� quem n�o resista dormir de conchinha com o cachorro e sente
					falta quando o gato n�o vem para a cama durante a noite. Para a
					rela��o afetiva entre o pet e o tutor � �timo, mas resta a d�vida
					se dormir com cachorro faz mal para a sa�de e se � melhor deixar
					cada um no seu quadrado. <br> Veja bem, mal n�o faz, mas �
					preciso cautela e cuidados com o pet para evitar que os membros da
					fam�lia tenham a sa�de prejudicada por doen�as transmitidas pelos
					bichos, como verminoses, alergias, a temida toxoplasmose ou at�
					mesmo pela transmiss�o de ectoparasitas. <br> Vacinar,
					vermifugar e manter prote��o de pulgas e carrapatos no seu pet, bem
					como manter sua higiene atrav�s de banhos e tosas e lev�-lo ao
					veterin�rio a qualquer sinal de doen�a s�o boas sa�das para quem
					n�o quer deixar o animal de lado nem na hora de dormir.

				</p>
				<br>
				<br>
				<br>
				<br>
				<button type="button" class="btn btn-primary">Voltar</button>
			
			</div>
			</div>
			</div>
			<br>
</body>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</html>