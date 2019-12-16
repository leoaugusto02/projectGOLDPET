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

#imgPet>img {
	border-radius: 65%;
	overflow: hidden;
	width: 298px;
	height: 318px;
	margin-left: 0.5%;
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
		String acaoModal = request.getParameter("acaoModal");
		String codAnimal = request.getParameter("codAnimal");
		String acaoVerifica = "verificaSessao";

		String parametros = "";

		if (acaoModal != null) {

			String dataDiagnostico = request.getParameter("dataDiagnostico");
			String breveDiagnostico = request.getParameter("breveDiagnostico");
			String diagnosticoCompleto = request.getParameter("diagnosticoCompleto");
			String horarioMarcado = request.getParameter("horarioMarcado");
			String diaMarcado = request.getParameter("diaMarcado");
			String pNome = request.getParameter("pNome");
			String sNome = request.getParameter("sNome");
			String cpf = request.getParameter("cpf");
			String rg = request.getParameter("rg");
			String telefone = request.getParameter("telefone");

			if (/*codAnimale != null) ||*/ (dataDiagnostico != null) || (breveDiagnostico != null)
					|| (diagnosticoCompleto != null) || (horarioMarcado == null) || (diaMarcado == null)) {
				System.out.println("codAnimal= " + codAnimal);
				parametros = "codAnimal=" + codAnimal + "&dataDiagnostico=" + dataDiagnostico + "&breveDiagnostico="
						+ breveDiagnostico + "&diagnosticoCompleto=" + diagnosticoCompleto + "&acaoModal="
						+ acaoModal;

				System.out.println(parametros);
			} else if ((horarioMarcado != null) || (diaMarcado != null) || (pNome != null || (sNome != null))
					|| (request.getSession().getAttribute("codigoUsuario") != null) || (cpf != null)
					|| (telefone != null)) {

				parametros = "codAnimal=" + codAnimal + "&pNome=" + pNome + "&sNome=" + sNome + "&rg=" + rg
						+ "&cpf=" + cpf + "&telefone=" + telefone + "&horarioMarcado=" + horarioMarcado
						+ "&diaMarcado=" + diaMarcado + "&codUser="
						+ request.getSession().getAttribute("codigoUsuario") + "&acaoModal=" + acaoModal;
			}
			
		
		} else if (request.getSession().getAttribute("codigoUsuario") != null) {

			parametros = "acao=" + acao + "&codUser=" + request.getSession().getAttribute("codigoUsuario")
					+ "&codAnimal=" + codAnimal + "&acaoVerifica=" + acaoVerifica;

		} else {
			parametros = "acao=" + acao + "&codAnimal=" + codAnimal;
		}

		System.out.println("PARAMETROS - " + parametros);

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

		System.out.println("Linha " + apnd);

		JSONObject obj = new JSONObject();
		
		if(!acaoModal.equals("atualizarEagendar")){
			obj = new JSONObject(apnd);
		}
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
						<h2><%=obj.getString("nome")%></h2>
						<div id="imgPet" class="circulo square">
							<img src="img/<%=obj.getString("imgAnimal")%>"
								style="margin-left: -0.2%; margin-bottom: 0.4%;"
								card-img"
								href="#" />
							<!-- style="height: 500px;"-->
						</div>
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
									<th><strong>Data Postagem:</strong></th>
									<td><%=obj.getString("dataPost")%></td>
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
									<td>
										<!-- Button trigger modal -->
										<button type="button" class="btn btn-primary"
											data-toggle="modal" data-target="#exampleModal">
											Visualizar laudo</button>

										<div class="modal fade" id="exampleModal" tabindex="-1"
											role="dialog" aria-labelledby="exampleModalLabel"
											aria-hidden="true">
											<div class="modal-dialog modal-xl" role="document">
												<div class="modal-content">
													<div class="modal-body center">
														<iframe src="./img/<%=obj.getString("imgDiag")%>"
															width="1400" height="800"></iframe>
													</div>
												</div>
											</div>
										</div>

									</td>
								</tr>

							</tbody>
						</table>

					</div>
				</div>
				<%
					if (request.getSession().getAttribute("cargo") != null
								&& request.getSession().getAttribute("cargo").equals("Veterinario")) {
				%>
				<button type="button" class="btn btn-outline-success"
					data-toggle="modal" data-target="#laudoModal">Atualizar
					Laudo</button>
				<br>
				<%
					}

					} else if (obj.getString("mensagem").equals("semLaudo")) {
						//System.out.println("OBJ 2 - " + request.getSession().getAttribute("cargo"));

						if ((request.getSession().getAttribute("cargo") != null)
								&& (request.getSession().getAttribute("cargo").equals("Veterinario"))) {
							//if (obj.getString("mensagemFunc").equals("veterinario")) {
				%>
				<br>
				<button type="button" class="btn btn-outline-success"
					data-toggle="modal" data-target="#laudoModal">Inserir
					Laudo</button>

				<!-- MODAL AQUI -->
				<%
					}
					}
					/*System.out.println("OBJ - " + obj.toString());
					System.out.println("MSG - " + obj.getString("mensagem"));
					if (obj.getString("mensagem").equals("guardiao")) {*/
					if (request.getSession().getAttribute("codigoUsuario") != null) {
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
							<form method="post">
								<div class="modal-header" style="background-color: #139F97;">
									<h5 class="modal-title">Para adotar é necessário agendar
										uma visita na nossa ONG</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span>x</span>
									</button>
								</div>


								<div class="modal-body">
									<div>

										<label><h6>Confirme seus dados:</h6></label> <input
											class="form-control" type="text" id="pNome" name="pNome"
											style="margin-bottom: 3%;"
											value="<%=obj.getString("pNome")%>" required="required" /> <input
											class="form-control" type="text" id="sNome" name="sNome"
											style="margin-bottom: 3%;"
											value="<%=obj.getString("sNome")%>" required="required" /> <input
											class="form-control" type="text" id="cpf" name="cpf"
											style="margin-bottom: 3%;" value="<%=obj.getString("cpf")%>"
											required="required" /> <input class="form-control"
											type="text" name="rg" style="margin-bottom: 3%;" name="rg"
											value="<%=obj.getString("rg")%>" required="required" /> <input
											class="form-control" type="text" style="margin-bottom: 3%;"
											name="telefone" value="<%=obj.getString("telefone")%>"
											required="required" /> <label><h6>Agende um dia
												e horário:</h6></label>
										<div class="form-group">
											<label class="col-md-5 control-label" for="hora">Horario:</label>
											<div class="col-md-5">
												<select id="hora" name="horarioMarcado" class="form-control">
													<option value="Não informado">Não informado</option>
													<option value="9:00">9:00</option>
													<option value="9:30">9:30</option>
													<option value="10:00">10:00</option>
													<option value="10:30">10:30</option>
													<option value="11:00">11:00</option>
													<option value="11:30">11:30</option>
													<option value="12:00">12:00</option>
													<option value="12:30">12:30</option>
													<option value="13:00">13:00</option>
													<option value="13:30">13:30</option>
													<option value="14:00">14:00</option>
													<option value="14:30">14:30</option>
													<option value="15:00">15:00</option>
													<option value="15:30">15:30</option>
													<option value="16:00">16:00</option>
													<option value="16:30">16:30</option>
													<option value="17:00">17:00</option>
												</select>
											</div>
										</div>

										<div class="form-group">
											<label class="col-md-5 control-label" for="dia">Dia:</label>
											<div>
												<input type="date" class="form-group col-md-6"
													name="diaMarcado" style="margin-left: 3%;">
											</div>
										</div>


										<input type="hidden" name="codUser"
											value="<%=request.getSession().getAttribute("codigoUsuario")%>" />
										<input type="hidden" name="codAnimal" value="<%=codAnimal%>" />
									</div>
								</div>

								<div class="modal-footer">
									<input type="submit" value="Confirmar"
										class="btn btn-outline-success" /> <input type="hidden"
										name="acaoModal" id="acaoModal" value="atualizarEagendar" />
									<!--  <img alt="postar.png" src="img/postar.png"
										style="height: 20px; width: 20px; margin-left: -0.5;" />-->
									<button type="button" class="btn btn-outline-danger"
										data-dismiss="modal">
										<img alt="close.png" src="img/close.png"
											style="height: 20px; width: 20px; margin-left: -0.5;" />
										Fechar
									</button>
								</div>
							</form>
						</div>
					</div>
				</div>


				<%
					} else {
				%>
				<div class="alert alert-info" role="alert">
					Para agendar uma visita para adotar este animalzinho,<a
						href="cadastro.jsp" class="alert-link">clique aqui</a>, e faça seu
					cadastro no nosso site!
					<%
					}
				%>
				</div>
			</div>
		</div>
	</div>
	<div id="direita"></div>

	<script src="js/bootstrap.min.js"></script>

	<script>
		function inserirLaudo() {
			$("#acaoModal").val("inserirLaudo");
		}

		function atualizarEagendar() {
			$("#acaoModal").val("atualizarEagendar");
		}
	</script>

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

				<form action="http://localhost:8080/goldpetBackEnd/ProcessaAnimais"
					method="POST" enctype="multipart/form-data">
					<div class="modal-body">

						<div class="form-group">
							<label>Data do diagnóstico:</label> <input type="date"
								class="form-group col-md-6" name="dataDiagnostico"
								style="margin-left: 3%;">
						</div>
						<div id="textArea">
							<textarea class="form-control" id="textarea"
								placeholder="Breve diagnóstico" rows="3" name="breveDiagnostico"
								style="margin-top: 2px; margin-bottom: 3%; height: 80px; width: 470px;"></textarea>
						</div>
						<div class="form-group">
							<label>Diagnóstico completo: </label> <input type="file"
								id="upload" name="diagnosticoCompleto" style="float: right;" />
						</div>
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-outline-success"
							value="Confirmar" />
						<!--  <img alt="postar.png" src="img/postar.png"
										style="height: 20px; width: 20px; margin-left: -0.5;" />-->

						<input type="hidden" name="codUser"
							value="<%=request.getSession().getAttribute("codigoUsuario")%>" />
						<input type="hidden" name="codAnimal" value="<%=codAnimal%>" />
						<%
							if (obj.getString("mensagem").equals("temLaudo")) {
						%>
						<input type="hidden" id="acaoModal" name="acaoModal"
							value="atualizarLaudo" />
						<%
							} else {
						%>
						<input type="hidden" id="acaoModal" name="acaoModal"
							value="inserirLaudo" />
						<%
							}
						%>
						<input type="hidden" name="pathFile"
							value="<%=getServletContext().getRealPath("/").replace('\\', '/')%>" />
						<button type="button" class="btn btn-outline-danger"
							data-dismiss="modal">
							<img alt="close.png" src="img/close.png"
								style="height: 20px; width: 20px; margin-left: -0.5;" />
							Cancelar
						</button>
					</div>

				</form>
			</div>
		</div>
	</div>
</body>
</html>