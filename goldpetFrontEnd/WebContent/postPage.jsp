
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
body{
  height: 900px;
  background-color: #8aedc2;
  background-image: linear-gradient(#8aedc2, white);
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
	background-color: #8aedc2;
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

.userBolsonaro {
	width: 15%;
	height: 100%;
	float: right;
	padding-top: 3%;
}

.botao {
	float: right;
}

.imgUser {
	float: top;
	overflow: hidden;
	padding-left: 39%;
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
	<br>
	<br>

	<div class="global">
		<div class="userLula">
			<div class="imgUser">
				<img src="https://bootdey.com/img/Content/avatar/avatar5.png"
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