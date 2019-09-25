<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
</style>
<head>
<meta charset="ISO-8859-1">
<title>Página Inicial</title>
<!-- <link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css"> -->


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<style>
body, html {
	margin: 0;
	padding: 0;
	display: flex;
	flex-direction: row;
	width: 100%;
	height: 100%;
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
}

#cabecalho {
	display: flex;
	flex-direction: row;
	width: 100%;
}

.navC {
	text-align: center;
	display: flex;
	flex-direction: row;
	
	width: 80%;
	position: left;
}

.minhaNav {
	background-color: #139F97;
	margin-top: 6%;
	height: 30%;
}

#imgPet>img{
	border-radius: 70%; 
	overflow: hidden;
	width:150px; 
	height:150px;
	margin-left:0.5%;
}
.img-thumbnail {
    padding: 0rem;
    background-color: #fff;
    border: 1px solid #dee2e6;
    border-radius: .25rem;
    max-width: 100%;
    height: auto;
}
.dogF{

}

</style>
</head>
<body background="img/bg-cadastro.png">

	<div id="esquerda"></div>
	<div id="meio">

		<div id="cabecalho">

			<div id="imgLogo">
				<img src="img/LogoPet.png" style="width: 220px; height: 220px; " />
			</div>

			<div class="navC">
				<nav class="navbar navbar-expand-lg navbar-light minhaNav">
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item active"><a class="nav-link" href="#">Home
									<span class="sr-only">(current)</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" href="#">Doações</a></li>
							
							<li class="nav-item"><a class="nav-link" href="#">Resgate</a></li>
							
							<li class="nav-item"><a class="nav-link" href="#">Sobre Nós</a></li>
							
							<li class="nav-item"><a class="nav-link" href="#">Cadastrar Pet</a></li>
						</ul>
					</div>
				</nav>
			</div>

		</div>

	
			

			
			
		</div>
		

	</div>
	<div id="direita"></div>

	<!-- <script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.3.1.min.js"></script> -->
	
</body>
</html>