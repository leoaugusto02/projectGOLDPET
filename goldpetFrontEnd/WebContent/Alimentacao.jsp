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
<title>Alimentação</title>
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
  <a class="navbar-brand" href="index.jsp">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">
      <a class="nav-item nav-link active" href="adocao.jsp">adoção<span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link " href="Resgate.jsp">resgate</a>
      <a class="nav-item nav-link active" href="DicasPets">Dicas</a>
      <a class="nav-item nav-link " href="questionPage">Forun</a>
      <a class="nav-item nav-link active" href="GerenciarUsuario.jsp">Dashboard</a>
      <a class="nav-item nav-link " href="AjudeOng.jsp">Ajude-nos</a>
    </div>
  </div>
</nav>
					</div>
				</div>
			</div>
			<div class="clearfix">
				<img class="img1" src="img/alimentacao.png" alt="Alimentacao"
					width="800px" height="290px"> <br> <br>
				<p class="round">Alimentação</p>
				<p class="texto">Programe os horários de alimentar seu cão, sem
					excessos e de maneira razoável para que ele não passe fome, os
					adultos alimente duas vezes ao dia e os filhotes de quatro a seis
					vezes ao dia. Dê alimentos próprios para a raça e a idade do
					cachorro e deixe a água dele sempre limpa e fresca para que não
					corra risco de ingerir algo inapropriado.</p>
					<button type="button" class="btn btn-primary">Voltar</button>
			
			</div>
			</div>
			</div>
</body>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</html>