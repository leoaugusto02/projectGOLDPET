<%@page import="org.json.JSONObject"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.DataOutputStream"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
</style>
<head>
<meta charset="ISO-8859-1">
<title>Adoção</title>
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

			<div id="buttonAdd"
				style="margin-left: 86%; margin-bottom: 2%; width: 15%;">
				<button type="button" class="btn btn-outline-success"
					data-toggle="modal" data-target="#siteModal">
					<img alt="add.png" src="img/add.png"
						style="height: 20px; width: 20px; margin-left: -0.5;">
					Adicinar Dog
				</button>
			</div>
			<form action="#" enctype="multipart/form-data" method="post">
				<div class="modal" id="siteModal" tabindex="-1" role="dialog"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">

							<div class="modal-header" style="background-color: #139F97;">
								<h5 class="modal-title">Cadastro</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span>x</span>
								</button>
							</div>

							<div class="modal-body">
								<div>

									<input class="form-control" type="text"
										placeholder="Nome do animal" style="margin-bottom: 3%;"
										name="nome" /> <input class="form-control" type="number"
										placeholder="Idade" name="idade" style="margin-bottom: 3%;" />
									<input class="form-control" type="text" placeholder="Raça"
										name="raca" style="margin-bottom: 3%;" /> <input
										class="form-control" type="text" placeholder="Porte"
										name="porte" style="margin-bottom: 3%;" /> <input
										class="form-control" type="text" placeholder="Espécie"
										name="especie" style="margin-bottom: 3%;" />

									<div class="form-check form-check-inline"
										style="margin-bottom: 2%;">
										<input class="form-check-input" type="radio" name="genero"
											id="inlineRadio1" value="Fêmea"> <label
											class="form-check-label" for="inlineRadio1"> <img
											alt="feminino.png" src="img/feminino.png"
											style="height: 25px; width: 25px; margin-left: -0.5;">Fêmea
										</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio" name="genero"
											id="inlineRadio2" value="Macho"> <label
											class="form-check-label" for="inlineRadio2"> <img
											alt="masculino.png" src="img/masculino.png"
											style="height: 25px; width: 25px; margin-left: -0.5;">Macho
										</label>

									</div>

									<div id="textArea">
										<textarea class="form-control" id="textarea"
											placeholder="Status do Pet" rows="3" name="status"
											style="margin-top: 2px; margin-bottom: 0px; height: 80px; width: 470px;"></textarea>
									</div>

									<div id="sendImg">

										<input type="file" id="upload" name="imgCao"
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
							<div class="modal-header" style="background-color: #139F97;">
								<h5 class="modal-title">Laudo</h5>
							</div>
							<div class="modal-body">
								<div>

									<input class="form-control" type="text"
										placeholder="Nome do veterinário" style="margin-bottom: 3%;"
										name="nomeVet" />
									<div class="form-group">
										<input type="date" class="form-group col-md-6"
											name="nascimento">
									</div>
									<input class="form-control" type="text"
										placeholder="Diagnóstico breve" name="diagnostico"
										style="margin-bottom: 3%;" />
								</div>
							</div>

							<div class="modal-footer">
								<button type="button" class="btn btn-outline-danger"
									data-dismiss="modal">
									<img alt="close.png" src="img/close.png"
										style="height: 20px; width: 20px; margin-left: -0.5;" />
									Close
								</button>
								<input type="submit" class="btn btn-outline-success"
									value="Postar" />
								<!-- 	<img alt="postar.png" src="img/postar.png"
									style="height: 20px; width: 20px; margin-left: -0.5;" /> -->
								<input type="hidden" name="acaoModal" id="acaoModal"
									value="inserirPet" />
							</div>
						</div>
					</div>
				</div>
			</form>
			<%
				String acao = "listaAdocao";
				String codAnimal = request.getParameter("codAnimal");
				String acaoModal = request.getParameter("acaoModal");

				String parametros = "";

				if (acaoModal != null) {

					System.out.println("açãoModal=" + acaoModal);

					String nome = request.getParameter("nome");
					String idade = request.getParameter("idade");
					String raca = request.getParameter("raca");
					String porte = request.getParameter("porte");
					String especie = request.getParameter("especie");
					String genero = request.getParameter("genero");
					String imagem = request.getParameter("imagem");
					String status = request.getParameter("status");
					String nomeVet = request.getParameter("nomeVet");

					if ((nome != null) || (idade != null) || (raca != null) || (porte != null) || (especie != null)
							|| (genero != null) || (imagem != null) || (status != null)) {

						parametros = "acaoModal=" + acaoModal + "&nome=" + nome + "&idade=" + idade + "&raca=" + raca
								+ "&porte=" + porte + "&especie=" + especie + "&genero=" + genero + "&imagem=" + imagem
								+ "&status=" + status;

						response.sendRedirect("adocao.jsp");

					}
				} else {
					parametros = "acao=" + acao;
				}

				URL url = new URL("http://localhost:8080/goldpetBackEnd/ProcessaAnimais");

				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("POST");
				con.setDoOutput(true);

				System.out.println(parametros);

				DataOutputStream wr = new DataOutputStream(con.getOutputStream());
				wr.writeBytes(parametros);

				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

				String linha = "";
				JSONObject obj;
			%>

			<!-- FORM -->

			<form action="#" method="post">
				<%
					System.out.println("Tô aqui antes do while");

					int i = 0;
					boolean fimWhile = false;

					while ((linha = br.readLine()) != null) {
						System.out.println("Tô aqui " + linha);
						obj = new JSONObject(linha);
						if (i == 0) {
				%>
				<div class="d-flex justify-content-around">
					<%
						}
					%>
					<a href="dataDoguinho.jsp?codAnimal=<%=obj.getInt("codAnimal")%>">
						<div class="card bg-dark text-white" style="width: 23rem;">
							<img src="img/slide01.png" class="card-img" href="#"
								style="height: 500px;">
							<div class="card-img-overlay">
								<h5 class="card-title"><%=obj.getString("nome")%></h5>
								<p class="card-text">
									Código:
									<%=obj.getInt("codAnimal")%>
									<br> Status:
									<%=obj.getString("nome")%><br> Raça:
									<%=obj.getString("raca")%><br> Espécie:
									<%=obj.getString("especie")%><br>

								</p>
								<p class="card-text">Last updated 3 mins ago</p>
							</div>
						</div> <br>
					</a>
					<%
						i++;
							if (i == 3) {
								fimWhile = false;
					%>
				</div>
				<%
					i = 0;
						} else {
							fimWhile = true;
						}

					}
					System.out.println("Tô aqui dps do while");
					if (fimWhile) {
				%>
			
		</div>
		<%
			}
		%>
		</form>
	</div>

	<div id="direita"></div>

	</div>
	<!-- <script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.3.1.min.js"></script> -->

	<script>
		function inserirDog() {
			$("#acaoModal").val("inserirPet");
		}
	</script>

</body>