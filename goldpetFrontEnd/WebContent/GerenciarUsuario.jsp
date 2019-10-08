<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
</style>
<head>
<meta charset="ISO-8859-1">
<title>Gerenciar Usuários</title>
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

			<form>
				<div class="table" style="margin-bottom: 100px;">

					<table class="table table-striped">

						<thead class="table-dark">
							<tr>
								<th name="nome">Nome</th>
								<th>CPF</th>
								<th>RG</th>
								<th>E-mail</th>
								<th>Tipo</th>
								<th>CEP</th>
								<th>Telefone</th>
								<th>Editar</th>
								<th>Excluir</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Leônidas Augusto</td>
								<td>540524787-10</td>
								<td>518942549146</td>
								<td>leo@gmail.com</td>
								<td>Guardião</td>
								<td>1520</td>
								<td>19985624851</td>
								<td>
									<button type="button" class="btn btn-default btn-sm"
										data-toggle="modal" data-target="#exampleModal">
										<span class=""> <img src="img/edit.svg" width="25"
											height="25">
										</span>
									</button>
								</td>
								<td>
									<button type="button" class="btn btn-default btn-sm">
										<span class=""> <img src="img/garbage.svg" width="25"
											height="25">
										</span>
									</button>
								</td>
							</tr>
							<tr>
								<td>Marcelo</td>
								<td>405245878-10</td>
								<td>1526546315110</td>
								<td>celim@gmail.com</td>
								<td>Funcionário</td>
								<td>266326</td>
								<td>19954821657</td>
								<td>
									<button type="button" class="btn btn-default btn-sm"
										data-toggle="modal" data-target="#exampleModal">
										<span class=""> <img src="img/edit.svg" width="25"
											height="25">
										</span>
									</button>
								</td>
								<td>
									<button type="button" class="btn btn-default btn-sm">
										<span class=""> <img src="img/garbage.svg" width="25"
											height="25">
										</span>
									</button>
								</td>
							</tr>
						</tbody>

					</table>

				</div>
			</form>

		</div>



		<div id="direita"></div>

	</div>

	<div id="finalPg">
		<img src="img/Rodape2.png" />
	</div>


	<!-- <script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.3.1.min.js"></script> -->

	<!-- Modal -->


	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header" style="background: black; color: aliceblue">
					<h5 class="modal-title" id="exampleModalLabel">Alterar Usuário
					</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true" style="color: aliceblue;">&times;</span>
					</button>
				</div>
				<form>
					<div class="modal-body" style="background: gray;">
					
						<label><h6>Aqui ficará o nome</h6></label><br>
						<select class="custom-select">
							<option selected>Tipo de usuário</option>
							<option value="1">Guardião</option>
							<option value="2">Funcionário</option>
						</select> 
						<br><br>
						<input type="password" class="form-control"
							placeholder="Senha" />
						<br>
						 <input type="password"
							class="form-control" placeholder="Confirmar senha"><br>
					</div>
				</form>
				<div class="modal-footer" style="background: black;">
					<input type="submit" class="btn btn-outline-success" value="Salvar">
					<input type="submit" class="btn btn-outline-danger" value="Cancelar">
				</div>
			</div>
		</div>
	</div>


</body>
</html>