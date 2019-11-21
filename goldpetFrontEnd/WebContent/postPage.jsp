	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
body{
  height: 900px;
  background-color: #8aedc2;
  background-image: linear-gradient(#139f97, white);
  background-repeat: no-repeat, repeat;
}
.global {
	margin: 1%;
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
.userLula {
	width: 15%;
	height: 100%;
	float: left;
}
.botao {
	float: right;
}

</style>
<head>
<meta charset="UTF-8" />
<meta charset="ISO-8859-1">
<title>Postagem</title>
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

	<div class="global">
		<div class="userLula">
			<div class="imgUser">
				<img src=""
					style="width: 80px; height: 80px;" />
			</div>
		</div>

		<div class="userBolsonaro"></div>

		<div class="fazerPergunta">
			<form method="post" action="#">
				<div class="card" style="width: 70%">

					<div
						class="card-header d-flex flex-md-row flex-sm-columm bg-light w-100">

						<input type="text" name="titulo" class="form-control"
							placeholder="Titulo" />

					</div>

					<div class="card-body">
						<textarea class="form-control" id="textarea" name="descricao" rows="5"
							placeholder="Faça a sua pergunta..." style="width: 100%;"></textarea>
						<div class="botao">
							<input type="hidden" name = "acao" id = "acao" value="postar" />
							<input type="submit" value="Postar" class="btn btn-success px-5 mt-3" />
						</div>
					</div>
				</div>
			</form>
			
			
			
			<div class="alert alert-success" role="alert">
				É necessário estar logado para fazer perguntas! <a href="login.jsp"
					class="alert-link">Faça seu login!</a>
			</div>
			
			<div class="alert alert-primary" role="alert">Pergunta feita
				com sucesso!!!</div>


			<div class="alert alert-danger" role="alert">Não foi possível
				realizar sua pergunta, tente novamente!</div>
			

		</div>
	</div>

</body>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</html>