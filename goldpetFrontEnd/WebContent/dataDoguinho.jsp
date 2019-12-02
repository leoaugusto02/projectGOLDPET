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
	height: 1800px;
	background-color: #8aedc2;
	background-image: linear-gradient(#8aedc2, white);
	background-repeat: no-repeat, repeat;
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
<script src="js/jquery.js"></script>
<script src="js/jquery-3.3.1.min.js"></script>
</head>
<body>

	<%
		String acao = "perfil";
		String acaoInserir = request.getParameter("acaoInserir");
		String codAnimal = request.getParameter("codAnimal");
		String acaoVerifica = request.getParameter("acaoVerifica");
		String codUser = request.getParameter("codUser");
		String parametros = "acao=" + acao + "&codAnimal=" + codAnimal;

		if (acaoInserir != null) {

		}

		URL url = new URL("http://localhost:8080/goldpetBackEnd/ProcessaAnimais");

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
			<div id="cabecalho">

				<div id="imgLogo">
					<img src="img/LogoPet.png" style="width: 220px; height: 220px;" />
				</div>

				<div class="navC d-flex w-100 justfy-content-center">

					<div class="w-100">
						<nav class="navbar navbar-expand-lg navbar-light minhaNav">
							<a class="navbar-brand" href="#">Home</a>
							<button class="navbar-toggler" type="button"
								data-toggle="collapse" data-target="#navbarNavAltMarkup"
								aria-controls="navbarNavAltMa	rkup" aria-expanded="false"
								aria-label="Toggle navigation">
								<span class="navbar-toggler-icon"></span>
							</button>
							<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
								<div class="navbar-nav">
									<a class="nav-item nav-link active" href="adocao.jsp">adoção<span
										class="sr-only">(current)</span></a> <a class="nav-item nav-link "
										href="Resgate.jsp">resgate</a> <a
										class="nav-item nav-link active" href="DicasPets">Dicas</a> <a
										class="nav-item nav-link " href="questionPage">Forun</a> <a
										class="nav-item nav-link active" href="GerenciarUsuario.jsp">Dashboard</a>
									<a class="nav-item nav-link " href="AjudeOng.jsp">Ajude-nos</a>
								</div>
							</div>
						</nav>
					</div>
				</div>

			</div>
			<br>
			<div class="col-xs-12 col-sm-9" style="margin-left: 15%;">

				<!-- User profile -->
				<div class="container">
					<div style="text-align: center">
						<h2>Doguinho</h2>
						<div class="circulo square"></div>
					</div>

				</div>

				<br>
				<!-- User info -->
				<div class="container">
					<div class="card  mb-8">

						<h4 class="card-header">Informações Doge</h4>

						<div class="panel-body" border="3px">
							<table class="table profile__table">
								<tbody>
									<tr>
										<th><strong>Nome:</strong><label></label></th>
										<td><%=obj.getString("nome")%></td>
									</tr>
									<tr>
										<th><strong>Espécie:</strong><label></label></th>
										<td><%=obj.getString("especie")%></td>
									</tr>
									<tr>
										<th><strong>Raça:</strong></th>
										<td><%=obj.getString("raca")%></td>
									</tr>
									<tr>
										<th><strong>Porte: </strong></th>
										<td><%=obj.getString("porte")%></td>
									</tr>
									<tr>
										<th><strong>Idade:</strong></th>
										<td><%=obj.getInt("idade")%></td>
									</tr>
									<tr>
										<th><strong>Genero:</strong></th>
										<td><%=obj.getString("sexo")%></td>
									</tr>
									<tr>
										<th><strong>Status:</strong></th>
										<td><%=obj.getString("status")%></td>
									</tr>
									<tr>
										<th><strong>Imagem:</strong></th>
										<td><%=obj.getString("imgAnimal")%></td>
									</tr>

								</tbody>
							</table>

						</div>
					</div>

					<%
						if (obj.getString("mensagem").equals("temLaudo")) {
					%>
					<div class="card  mb-8">

						<h4 class="card-header">Laudo</h4>

						<div class="panel-body" border="3px">
							<table class="table profile__table">
								<tbody>
									<tr>
										<th><strong>Nome do Veterinario:</strong><label></label></th>
										<td><%=obj.getString("nomeVet")%></td>
									</tr>
									<tr>
										<th><strong>Data do Diagnostico:</strong></th>
										<td><%=obj.getString("dataDiag")%></td>
									</tr>
									<tr>
										<th><strong>Breve Diagnostico:</strong></th>
										<td><%=obj.getString("diagnostico")%></td>
									</tr>
									<tr>
										<th><strong>Diagnostico completo:</strong></th>
										<td><%=obj.getString("imgDiag")%></td>
									</tr>
									<%
										// if (request.getSession().getAttribute("codigoUsuario") == null) {

											//}
									%>

									<tr style="visibility: hidden;">
										<th><strong>Enviar laudo medico</strong></th>
										<td></td>
									</tr>
								</tbody>
							</table>

						</div>
					</div>
					<%
						} /*else if (obj.getString("mensagem").equals("semLaudo")) {
							if (request.getSession().getAttribute("codigoUsuario") != null) {
								if (obj.getString("mensagem").equals("veterinario")) {*/
					%>
					<br>
					<button type="button" class="btn btn-outline-success"
						data-toggle="modal" data-target="#laudoModal">Inserir
						Laudo</button>

					<div class="modal" id="laudoModal" tabindex="-1" role="dialog"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content" style="width: 565px;">

								<div class="modal-header" style="background-color: #139F97;">
									<h5 class="modal-title">Inserir Laudo</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span>x</span>
									</button>
								</div>

								<div class="modal-body">
									<div class="form-group">
										<label>Data do diagnóstico:</label> <input type="date"
											class="form-group col-md-6" name="dataDiagnostico"
											style="margin-left: 3%;">
									</div>
									<div id="textArea">
										<textarea class="form-control" id="textarea"
											placeholder="Breve diagnóstico" rows="3"
											name="breveDiagnostico"
											style="margin-top: 2px; margin-bottom: 3%; height: 80px; width: 470px;"></textarea>
									</div>
									<div class="form-group">
										<label>Diagnóstico completo: </label> <input type="file"
											id="upload" name="arquivo" style="float: right;" />
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-outline-success">
										<img alt="postar.png" src="img/postar.png"
											style="height: 20px; width: 20px; margin-left: -0.5;" />
										Confirmar
									</button>
									<input type="hidden" name="acaoInserir" value="inserirLaudo">
									<button type="button" class="btn btn-outline-danger"
										data-dismiss="modal">
										<img alt="close.png" src="img/close.png"
											style="height: 20px; width: 20px; margin-left: -0.5;" />
										Cancelar
									</button>
								</div>
							</div>
						</div>
					</div>

					<%
						//} else if (("mensagem").equals("guardiao")) {
					%>
					<br>
					<div id="buttonAdd">
						<button type="button" class="btn btn-outline-success"
							data-toggle="modal" data-target="#siteModal">Adotar</button>
					</div>

					<div class="modal" id="siteModal" tabindex="-1" role="dialog"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">

								<div class="modal-header" style="background-color: #139F97;">
									<h5 class="modal-title">Adotar</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span>x</span>
									</button>
								</div>

								<div class="modal-body">
									<div>
										<div class="custom-control custom-radio">
											<input type="radio" id="customRadio1" name="customRadio"
												class="custom-control-input"> <label
												class="custom-control-label" for="customRadio1 style="margin-bottom: 1%;"">Buscar
												na Ong</label>
										</div>
										<div class="custom-control custom-radio">
											<input type="radio" id="customRadio2" name="customRadio"
												class="custom-control-input"> <label
												class="custom-control-label" for="customRadio2"
												style="margin-bottom: 3%;">Levar até na casa</label>
										</div>
									</div>

									<div id="levarNaCasa">
										<input class="form-control" type="text" placeholder="CEP"
											id="cep" style="margin-bottom: 3%;" />

										<script>
											$(document)
													.ready(
															function() {
																$("#cep")
																		.keyup(
																				function() {
																					var cep = $(
																							"#cep")
																							.val();
																					if (cep.length == 8) {

																						$
																								.get(
																										"https://viacep.com.br/ws/"
																												+ cep
																												+ "/json/",
																										function(
																												data,
																												status) {
																											console
																													.log(data);
																											$(
																													"#cidade")
																													.val(
																															data.localidade);
																											$(
																													"#nomeRua")
																													.val(
																															data.logradouro);
																											$(
																													"#bairro")
																													.val(
																															data.bairro);
																										});
																					}
																				});
															});
										</script>

										<input class="form-control" type="text" placeholder="Cidade"
											id="cidade" style="margin-bottom: 3%;" /> <input
											class="form-control" type="text" placeholder="Rua"
											id="nomeRua" style="margin-bottom: 3%;" /> <input
											class="form-control" type="number" placeholder="N° casa"
											style="margin-bottom: 3%;" /> <input class="form-control"
											type="text" placeholder="Bairro" id="bairro"
											style="margin-bottom: 3%;" />

									</div>

									<div id="buscarNaYong">
										<div class="form-group">
											<label class="col-md-5 control-label" for="hora">Horario</label>
											<div class="col-md-5">
												<select id="hora" name="time" class="form-control">
													<option value="Não informado">Não informado</option>
													<option value="Manha">9:00 AM</option>
													<option value="Manha">9:30 AM</option>
													<option value="Manha">10:00 AM</option>
													<option value="Manha">10:30 AM</option>
													<option value="Manha">11:00 AM</option>
													<option value="Manha">11:30 AM</option>
													<option value="Tarde">12:00 PM</option>
													<option value="Tarde">12:30 PM</option>
													<option value="Tarde">13:00 PM</option>
												</select>
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-4 control-label" for="dia">Dia</label>
											<div class="col-md-4">
												<select id="hora" name="time" class="form-control">
													<option value="Não informado">Não informado</option>
													<option value="Segunda">Segunda</option>
													<option value="Terca">Terça</option>
													<option value="Quarta">Quarta</option>
													<option value="Quinta">Quinta</option>
													<option value="Sexta">Sexta</option>
												</select>
											</div>
										</div>
									</div>

								</div>

								<div class="modal-footer">
									<button type="button" class="btn btn-outline-danger"
										data-dismiss="modal">
										<img alt="close.png" src="img/close.png"
											style="height: 20px; width: 20px; margin-left: -0.5;" />
										Fechar
									</button>
									<button type="button" class="btn btn-outline-success">
										<img alt="postar.png" src="img/postar.png"
											style="height: 20px; width: 20px; margin-left: -0.5;" />
										Confirmar
									</button>
								</div>
							</div>
						</div>

					</div>
					<%
						//}
							//} else {
					%>
				<!--  	<div class="alert alert-info" role="alert">
						Para agendar uma visita para adotar este animalzinho,<a
							href="cadastro.jsp" class="alert-link">clique aqui</a>, e faça
						seu cadastro no nosso site!-->
						<%
					//	}
					//	}
					%>




					</div>
				</div>
			</div>
		</div>
		<div id="direita"></div>

		<script src="js/bootstrap.min.js"></script>
</body>
</html>