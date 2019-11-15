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
<head>

<style>
body, html {
	margin: 0;
	padding: 0;
	display: flex;
	flex-direction: row;
	width: 100%;
	height: 100%;
}

.navC {
	text-align: center;
	display: flex;
	flex-direction: row;
	width: 80%;
	position: left;
}

#cabecalho {
	display: flex;
	flex-direction: row;
	width: 100%;
}

.minhaNav {
	background-color: #139F97;
	margin-top: 6%;
	height: 30%;
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

.square {
	width: 90px;
	height: 90px;
	margin: auto;
	margin-top: 20px;
	margin-bottom: 20px;
	border: solid 2px black;
}

.circulo {
	border-radius: 100%;
	width: 300px;
	height: 320px;
	margin: auto;
	overflow: visible;
}
</style>

<meta charset="ISO-8859-1">

<title>Meu Perfil</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<%
		if (request.getSession().getAttribute("codigoUsuario") == null) {
			System.out.println("Por favor Realize o login");
			response.sendRedirect("Login.jsp");
			return;
		} else {
			Integer codeUser = (Integer) request.getSession().getAttribute("codigoUsuario");
			String acao = "mostrarCredencial";
			System.out.println(codeUser);

			String parametros = "codeUser=" + codeUser + "&acao=" + acao;

			URL url = new URL("http://localhost:8080/goldpetBackEnd/ProcessaPessoas");

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setDoOutput(true);

			System.out.println(parametros);

			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(parametros);

			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

			String apnd = "", linha = "";

			while ((linha = br.readLine()) != null)
				apnd += linha;

			JSONObject obj = new JSONObject(apnd);
		
	%>

	<div id="esquerda"></div>
	<div id="meio">

		<div class="container">
			<form action="#" method="post">
				<div id="cabecalho">

					<div id="imgLogo">
						<img src="img/LogoPet.png" style="width: 220px; height: 220px;" />
					</div>

					<div class="navC">
						<div class="d-flex">
							<div class="navC d-flex w-100 justfy-content-center">

								<div class="w-100">
									<nav class="navbar navbar-expand-lg navbar-light minhaNav">
										<a class="navbar-brand" href="#">Home</a>
										<button class="navbar-toggler" type="button"
											data-toggle="collapse" data-target="#navbarNavAltMarkup"
											aria-controls="navbarNavAltMarkup" aria-expanded="false"
											aria-label="Toggle navigation">
											<span class="navbar-toggler-icon"></span>
										</button>
										<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
											<div class="navbar-nav">
												<a class="nav-item nav-link active" href="adocao.jsp">adoção<span
													class="sr-only">(current)</span></a> <a
													class="nav-item nav-link " href="Resgate.jsp">resgate</a> <a
													class="nav-item nav-link active" href="DicasPets">Dicas</a>
												<a class="nav-item nav-link " href="questionPage">Forun</a>
												<a class="nav-item nav-link active"
													href="GerenciarUsuario.jsp">Dashboard</a> <a
													class="nav-item nav-link " href="AjudeOng.jsp">Ajude-nos</a>
											</div>
										</div>
									</nav>

								</div>
							</div>

						</div>
						<br>
						<div class="col-xs-12 col-sm-9">

							<!-- User profile -->
							<div class="container">
								<div style="text-align: center">
									<h2>GUARDIÃO</h2>
									<div style="padding-top: 50px;">
										<img src="img/male-icon.png"
											style="width: 300px; height: 300px;" />
									</div>
									<div style="margin: -50px 0px 0px 280px">
										<img src="img/escudo.png" style="width: 85px; height: 60px;" />
									</div>
									<br>
									<h4>NICKNAME</h4>
								</div>

							</div>

							<br>
							<!-- User info -->
							<div class="container">
								<div class="card  mb-8">
									<div class="card-header">
										<h4>Informações Usuario</h4>
									</div>
									<div class="panel-body" border="3px">
										<table class="table profile__table">
											<tbody>
												<tr>
													<th><strong>Apelido:</strong><label></label></th>
													<td><%=obj.getString("apelido")%></td>
												</tr>
												<tr>
													<th><strong>Nome:</strong><label></label></th>
													<td><%=obj.getString("nome")%></td>
												</tr>
												<tr>
													<th><strong>Data de Nascimento:</strong></th>
													<td><%=obj.getString("nascimento")%></td>
												</tr>
												<tr>
													<th><strong>Genero: </strong></th>
													<td><%=obj.getString("genero")%></td>
												</tr>
												<tr>
													<th><strong>Telefone1: </strong></th>
													<td><%=obj.getString("tel1")%></td>
												</tr>
												<tr>
													<th><strong>Telefone2:</strong><label></label></th>
													<td><%=obj.getString("tel2")%></td>
												</tr>
												<tr>
													<th><strong>Email:</strong></th>
													<td><%=obj.getString("email")%></td>
												</tr>
												<tr>
													<th><strong>Endereço:</strong></th>
													<td><%=obj.getString("endereco")%></td>
												</tr>
												<tr>
													<th><strong>Rank:</strong></th>
													<td><%=obj.getString("rank")%></td>
												</tr>
												<tr>
													<th><strong>Animais Resgatados:</strong></th>
													<td><%=obj.getInt("aniResgatados")%></td>
												</tr>
												<tr>
													<th><strong>Progresso:</strong><label></label></th>
													<td><%=obj.getInt("progresso")%></td>
													<td></td>
												</tr>
												<%
											}
										%>
											</tbody>
										</table>

									</div>
								</div>

							</div>
						</div>
						<div id="botao" style="margin-top: 5%; margin-left: 28%">
							<button type="button" class="btn btn-outline-success"
								data-toggle="modal" data-target="#siteModal">Alterar
								Informações</button>
			</form>
		</div>



	</div>

	<div class="modal" id="siteModal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">

				<div class="modal-header" style="background-color: #139F97;">
					<h5 class="modal-title">Alterar Informaçoes</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span>x</span>
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

									<input class="form-control" type="text"
										placeholder="nome do pet" style="margin-bottom: 3%;" /> <input
										class="form-control" type="number" placeholder="Idade"
										style="margin-bottom: 3%;" /> <input class="form-control"
										type="text" placeholder="Raça" style="margin-bottom: 3%;" />

									<input class="form-control" type="text" placeholder="Porte"
										style="margin-bottom: 3%;" /> <input class="form-control"
										type="text" placeholder="Espécie" style="margin-bottom: 3%;" />

									<div class="form-check form-check-inline"
										style="margin-bottom: 2%;">
										<input class="form-check-input" type="radio"
											name="inlineRadioOptions" id="inlineRadio1" value="option1">
										<label class="form-check-label" for="inlineRadio1"> <img
											alt="feminino.png" src="img/feminino.png"
											style="height: 25px; width: 25px; margin-left: -0.5;">Fêmea
										</label>
									</div>
									<div class="form-check form-check-inline">
										<input class="form-check-input" type="radio"
											name="inlineRadioOptions" id="inlineRadio2" value="option2">
										<label class="form-check-label" for="inlineRadio2"> <img
											alt="masculino.png" src="img/masculino.png"
											style="height: 25px; width: 25px; margin-left: -0.5;">Macho
										</label>

									</div>

									<div id="textArea">
										<textarea class="form-control" id="textarea"
											placeholder="Status do Pet" rows="3"
											style="margin-top: 2px; margin-bottom: 0px; height: 80px; width: 470px;"></textarea>
									</div>

									<div>

										<button action="upload" type="file"
											class="btn btn-outline-info"
											style="float: right; margin-top: 2%;">
											<img alt="petIcon.png" src="img/PetIcon.png"
												style="height: 20px; width: 20px; margin-left: -1%;">Imagem
											Pet
										</button>

									</div>
								</div>
							</div>

							<div class="modal-footer">
								<button type="button" class="btn btn-outline-danger"
									data-dismiss="modal">
									<img alt="close.png" src="img/close.png"
										style="height: 20px; width: 20px; margin-left: -0.5;" />
									Close
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
			</div>
		</div>
	</div>
	<div id="direita"></div>

	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>