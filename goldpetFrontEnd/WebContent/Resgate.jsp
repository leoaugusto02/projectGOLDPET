<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
</style>
<head>
<meta charset="ISO-8859-1">
<title>Resgate</title>
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

#infoDog {
	
}

.card {
	box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.40), 0 2px 10px 0
		rgba(0, 0, 0, 0.40) !important;
}

.minhaNav {
	background-color: #139F97;
	margin-top: 6%;
	height: 30%;
}

.menu {
	padding-right: 15px;
	width: 100%;
}

.menu>li {
	padding-left: 15px;
}

#a {
	color: black;
	text-decoration: none;
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
									<a class="nav-item nav-link active" href="adocao.jsp">adoção<span
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

			<div id="buttonAdd"
				style="margin-left: 86%; margin-bottom: 2%; width: 15%;">
				<button type="button" class="btn btn-outline-success"
					data-toggle="modal" data-target="#siteModal">
					<img alt="add.png" src="img/add.png"
						style="height: 20px; width: 20px; margin-left: -0.5;">
					Adicinar Dog
				</button>
			</div>

			<div class="modal" id="siteModal" tabindex="-1" role="dialog"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">

						<div class="modal-header" style="background-color: #139F97;">
							<h5 class="modal-title">Adicionar Pet</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span>x</span>
							</button>
						</div>

						<div class="modal-body">
							<div>
									
								<input class="form-control"
									type="text" placeholder="endereço" style="margin-bottom: 3%;" />

								<input class="form-control" type="text" placeholder="Nivel de Urgencia"
									style="margin-bottom: 3%;" />

								<div id="textArea">
									<textarea class="form-control" id="textarea"
										placeholder="Descrição do Pet" rows="3"
										style="margin-top: 2px; margin-bottom: 0px; height: 80px; width: 470px;"></textarea>
								</div>

								<div>

									<input type="file" id="upload" name="imagem"
											style="float: right; margin-top: 6%;"> <img id="img"
											style="width: 300px; margin-left: 17%;" />
											<script>
											$(function() {
												$('#upload')
														.change(
																function() {
																	console
																			.log($(this));
																	const file = ($(this)[0].files[0])
																	const fileReader = new FileReader()
																	fileReader.onloadend = function() {
																		$(
																				'#img')
																				.attr(
																						'src',
																						fileReader.result)
																	}
																	fileReader
																			.readAsDataURL(file)
																})
											})
										</script>

								</div>
							</div>
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-outline-danger"
								data-dismiss="modal">
								<img alt="close.png" src="img/close.png"
									style="height: 20px; width: 20px; margin-left: -0.5;" /> Close
							</button>
							<button type="button" class="btn btn-outline-success">
								<img alt="postar.png" src="img/postar.png"
									style="height: 20px; width: 20px; margin-left: -0.5;" />
								Postar
							</button>
						</div>
					</div>
				</div>
			</div>


			<div class="">
				<div class="d-flex flex-row justify-content-around mb-5"
					id="infoDog">
					<div class="card" style="width: 23rem;">
						<img src="img/slide01.png" class="card-img" href="#"
							style="height: 500px;">
						<div class="card-body">
							<h5 class="card-title">Especie</h5>
							<p class="card-text">Observaçoes sobre o Pet</p>
							<p class="card-text">
								<small class="text-muted">Localizacao do Pet</small>
							</p>
						</div>
					</div>


					<div class="card" style="width: 23rem;">
						<img src="img/slide01.png" class="card-img" href="#"
							style="height: 500px;">
						<div class="card-body">
							<h5 class="card-title">Especie</h5>
							<p class="card-text">Observaçoes sobre o Pet</p>
							<p class="card-text">
								<small class="text-muted">Localizacao do Pet</small>
							</p>
						</div>
					</div>

					<div class="card" style="width: 23rem;">
						<img src="img/slide01.png" class="card-img" href="#"
							style="height: 500px;">
						<div class="card-body">
							<h5 class="card-title">Especie</h5>
							<p class="card-text">Observaçoes sobre o Pet</p>
							<p class="card-text">
								<small class="text-muted">Localizacao do Pet</small>
							</p>
						</div>
					</div>
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