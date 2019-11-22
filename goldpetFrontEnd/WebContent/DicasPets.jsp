<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<style>
body {
	height: 1300px;
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
	border: 1px solid white;
	border-radius: 12px;
	text-align: center;
	width: 600px;
	height: 55px;
	margin-left: 400px;
	font-size: 35px;
	color: white;
	text-shadow: 1px 1px 2px black, 0 0 25px blue, 0 0 5px darkblue;
}

.clearfix {
	margin-left: 400px;
	width: 600px;
	height: 225px;
	border: 1px solid gray;
	padding: 2px;
}

.img1 {
	float: right;
}

input[type=button] {
	background-color: #ccc7ba;
	border: none;
	color: black;
	padding: 12px 258px;
	text-decoration: none;
	margin: 2px 2px;
	cursor: pointer;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Dicas</title>
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
									<a class="nav-item nav-link active" href="adocao.jsp">ado��o<span
										class="sr-only">(current)</span></a> <a class="nav-item nav-link "
										href="Resgate.jsp">resgate</a> <a
										class="nav-item nav-link active" href="DicasPets.jsp">Dicas</a>
									<a class="nav-item nav-link " href="questionPage.jsp">Forun</a>
									<a class="nav-item nav-link active" href="GerenciarUsuario.jsp">Dashboard</a>
									<a class="nav-item nav-link " href="AjudeOng.jsp">Ajude-nos</a>
								</div>
							</div>
						</nav>
					</div>
				</div>
			</div>
			<p class="round">Dicas,Cuorisidades e Cuidados !!</p>
			<br> <br>
			<div class="clearfix">
				<img class="img1" src="img/adoravel.jpg" alt="Adoravel"
					width="170px" height="170px">
				<h2>
					<center>Adoram beijar</center>
				</h2>
				Sabe aquela lambida no rosto que o seu cachorrinho adora dar? � o
				famoso beijo de cachorro. Normalmente um c�o tem o costume de lamber
				a boca de... <br> <br> <br> <a
					href="adoramBeijar.jsp"><input type="button"
					value="Leia mais..."></a>
			</div>
			<br>
			<div class="clearfix">
				<img class="img1" src="img/alimentacao.png" alt="Alimentacao"
					width="170px" height="170px">
				<h2>
					<center>Alimenta��o</center>
				</h2>
				Programe os hor�rios de alimentar seu c�o, sem excessos e de maneira
				razo�vel para que ele n�o passe fome... <br> <br> <br>
				<a href="Alimentacao.jsp"><input type="button"
					value="Leia mais..."></a>
			</div>
			<br>
			<div class="clearfix">
				<img class="img1" src="img/snow.jpg" alt="Snow" width="170px"
					height="170px">
				<h2>Por que os cachorros fazem xixi em p�?</h2>
				A maioria dos machos tem esse tipo de comportamento, muito embora
				algumas f�meas tamb�m. Muitos tutores... <br> <input
					type="button" value="Leia mais...">
			</div>
			<br>
			<div class="clearfix">
				<img class="img1" src="img/higiene.jpg" alt="Higiene" width="170px"
					height="170px">
				<h2>
					<center>Higiene</center>
				</h2>
				D� banho em seu cachorro pelo menos uma vez ao m�s e se poss�vel
				pe�a em um pet shop que escove os dentes dele para prevenir... <a
					href="higiene.jsp"><input type="button" value="Leia mais..."></a>
			</div>
			<br>
			<div class="clearfix">
				<img class="img1" src="img/passeio.jpg" alt="Passeio" width="170px"
					height="170px">
				<h2>
					<center>Passeio</center>
				</h2>
				Leve-o todos os dias para passear, o cachorro tamb�m precisa se
				exercitar e andar como n�s, ainda mais se sua casa n�o tem
				quintal... <a href="passeios.jsp"><input type="button"
					value="Leia mais..."></a>
			</div>
			<br>
			<div class="clearfix">
				<img class="img1" src="img/truques.jpg" alt="Truques" width="170px"
					height="170px">
				<h2>C�es velhos aprendem truques novos?</h2>
				Um dos motivos de haver mais c�es adultos nos abrigos e ONGs � o
				medo de c�es velhos n�o aprenderem coisas novas. Desde um xixi no
				lugar certo, at�... <a href="truques.jsp"><input type="button"
					value="Leia mais..."></a>
			</div>
			<br>
			<div class="clearfix">
				<img class="img1" src="img/dormir.jpg" alt="Dormir" width="170px"
					height="170px">
				<h2>Dormir com P�</h2>
				Tem bicho que parece gente, domina a casa toda, desde o sof� at� a
				cama, e ignora todo e qualquer limite de espa�o. Mas... <a
					href="dormir.jsp"><input type="button" value="Leia mais..."></a>
			</div>
			<br>
			<div class="clearfix">
				<img class="img1" src="img/suam.jpg" alt="Suam" width="170px"
					height="170px">
				<h2>Os c�es tamb�m suam, sabia?</h2>
				Antes de mais nada � preciso entender qual � a temperatura corporal
				ideal para o c�o: entre os 38 �C e os 39 �C. Bem diferente da nossa.
				<a href="suam.jsp"><input type="button" value="Leia mais..."></a>
			</div>
			<br>
			<div class="clearfix">
				<img class="img1" src="img/olfato.png" alt="Olfato" width="170px"
					height="170px">
				<h2>O m�gico olfato dos c�es</h2>
				Voc� sabia que os cachorros percebem os cheiros 1 milh�o de vezes
				melhor do que os seres humanos? <a href="Olfato.jsp"><input
					type="button" value="Leia mais..."></a>
			</div>
			<br>
			<div class="clearfix">
				<img class="img1" src="img/veterinario.png" alt="Veterinario"
					width="170px" height="170px">
				<h2>Levar ao Veterinario</h2>
				Sabe com que frequ�ncia deve levar seu c�ozinho ao veterin�rio? Essa
				� uma pergunta muito comum... <a href="levarVeterinario.jsp"><input
					type="button" value="Leia mais..."></a>
			</div>
			<br>
		</div>
</body>
</html>
