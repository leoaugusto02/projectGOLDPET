<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
body {
	height: 900px;
	background-color: #139f97;
	background-image: linear-gradient(#139f97, white);
	background-repeat: no-repeat, repeat;
}

.global {
	margin: 1%;
}

.userDiv {
	width: 10%;
	height: 100%;
	text-align: center;
	display: inline-block;
	padding-top: 1%;
}

.pergunta {
	float: right;
	width: 85%;
	padding-right: 20%;
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
	background-color: #139f97;
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

.userLateral {
	width: 15%;
	height: 100%;
	float: left;
	padding-top: 3%;
}

.user {
	float: botton;
	text-allign: center;
}
</style>
<head>
<meta charset="UTF-8" />
<title>Quest</title>
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
  <a class="navbar-brand" href="#">Home</a>
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
	<br>
	<br>
	<form method="post" action="#">
		<div class="global">

			<div class="userLateral">
				<div class="imgUser">
					
				</div>
				<div class="user"></div>
			</div>
			<div class="pergunta">

				<div class="card">
					<div class="card-header"></div>
					<div class="card-body">
						<blockquote class="blockquote mb-0"></blockquote>
					</div>
				</div>


				<div class="resposta" style="width: 100%;">
					<div class="card-header"></div>

					<ul class="list-group list-group-flush">
						<li class="list-group-item">
							<div class="userDiv">
								

							</div>
							<div class="answerDiv"></div>
						</li>

						<li class="list-group-item"></li>
						<li class="list-group-item"></li>

					</ul>
				</div>

				<div class="resposta" style="width: 100%;">
					<div class="card-header"></div>
					<textarea id="textarea" name="textResp" rows="4"
						placeholder="RESPOSTA" style="width: 100%;"></textarea>
					<input type="hidden" id="acao" name="acao" value="responder" />
					 <input	type="submit" id="btn" class="btn btn-primary" value="Enviar" 
					 style="width: 10%;" />
				</div>

				<script>
					document.getElementById('btn').disabled = true;
				</script>


			</div>
		</div>

	</form>
</body>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>