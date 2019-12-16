<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
</style>
<head>
<meta charset="ISO-8859-1">
<title>Ajude nossa ONG</title>
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

.navC {
	
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

.img-thumbnail {
	padding: 0rem;
	background-color: #fff;
	border: 1px solid #dee2e6;
	border-radius: .25rem;
	max-width: 100%;
	height: auto;
}

.dogF {
	
}

.menu {
	padding-right: 15px;
	width: 100%;
}

.menu>li {
	padding-left: 15px;
}

.bar {
	display: -ms-flexbox;
	display: flex;
	height: 50px;
	overflow: hidden;
	font-size: .75rem;
	background-color: #6c757d;
	border-radius: .25rem;
	margin-bottom: 10px;
	animation: progress-bar-stripes 2s linear infinite;
}

.active {
	-webkit-animation: progress-bar-stripes 700ms linear infinite;
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

			<div>
				<img src="img/Conta.png" style="width: 100%; height: 550px" />

			</div>

			<div>
				<h4 style="margin-top: 20px">Ajude a nossa a ONG conseguir
					recursos necessários para dar uma vida mais confortável e alegre
					para os nossos animais. Nossa meta desse mês R$1500,00, ajude-nos!!
				</h4>
				<BR> <br> <br>
				<h4>Quantidade arrecada:</h4>
				<div class="bar">
					<div class="progress-bar progress-bar-striped active "
						role="progressbar" aria-valuenow="40" aria-valuemin="0"
						aria-valuemax="100" style="width: 40%">40% Complete
						(success)</div>
				</div>
			</div>
		</div>



		<div id="direita"></div>

	</div>

	<div id="finalPg">
		<img src="img/Rodape2.png" />
	</div>


	<!-- <script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.3.1.min.js"></script> -->

</body>
</html>