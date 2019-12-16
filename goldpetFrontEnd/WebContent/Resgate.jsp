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

	<%
		String acao = "listarAnimaisResgate";
		String acaoModal = request.getParameter("acaoModal");
		String parametros = "";

		if (acaoModal != null) {
			parametros = "";

		} else {
			parametros = "acao=" + acao;
		}

		URL url = new URL("http://localhost:8080/goldpetBackEnd/ProcessaResgate");

		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setDoOutput(true);

		System.out.println(parametros);

		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(parametros);

		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

		String linha = "";
		JSONObject obj = new JSONObject();
	%>

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

			<div id="buttonAdd"
				style="margin-left: 86%; margin-bottom: 2%; width: 15%;">
				<button type="button" class="btn btn-outline-success"
					data-toggle="modal" data-target="#siteModal">
					<img alt="add.png" src="img/add.png"
						style="height: 20px; width: 20px; margin-left: -0.5;">
					Novo Resgate
				</button>
			</div>

			<div class="modal" id="siteModal" tabindex="-1" role="dialog"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">

						<div class="modal-header" style="background-color: #139F97;">
							<h5 class="modal-title">Novo Resgate</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span>x</span>
							</button>
						</div>

						<div class="modal-body">
							<div>

								<input class="form-control" type="text" placeholder="Endereço"
									style="margin-bottom: 3%;" />

								<div class="input-group mb-3">
									<select class="custom-select" id="inputGroupSelect01">
										<option selected>Selecione o nível de urgência...</option>
										<option value="1">Não urgente</option>
										<option value="2">Pouco machucado</option>
										<option value="3">Machucado</option>
										<option value="3">Perigo</option>
										<option value="3">Muito Urgente</option>
									</select>
								</div>



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
																	$('#img')
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
									style="height: 20px; width: 20px; margin-left: -0.5;" /> Fechar
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
			<form method="post" action="#">
				<%
					//System.out.println("OBJ - " + obj.toString());
					//if(obj.getString("mensagem").equals("temAnimais")){

					//System.out.println("Tô aqui antes do while");

					int i = 0;
					boolean fimWhile = false;

					while ((linha = br.readLine()) != null) {

						//System.out.println("Tô aqui " + linha);
						obj = new JSONObject(linha);
						System.out.println("OBJ - " + obj.toString());

						if (!obj.getString("status").equals("ntem")) {

							if (i == 0) {
				%>
				<div class="d-flex justify-content-around">
					<%
						}
					%>

					<div class="card" style="width: 23rem;">
						<img src="imgAnimalResgate/<%=obj.getString("dogeImagem")%>" class="card-img"
							href="#" style="height: 500px;">
						<div class="card-body">
							<h5 class="card-title">
								Nível de Urgência:
								<%=obj.getInt("nivelUrgencia")%></h5>
							<p class="card-text">
								Código:
								<%=obj.getInt("codeResgate")%></p>
							<p class="card-text">
								Observaçoes sobre o Pet:
								<%=obj.getString("descricao")%></p>
							<p class="card-text">
								Status:
								<%=obj.getString("status")%></p>
							<p class="card-text">
								<small class="text-muted">Localizacao do Pet: <%=obj.getString("endereco")%></small>
							</p>
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#exampleModal">Resgatar</button>
						</div>
					</div>

					<!-- Modal -->
					<div class="modal fade" id="exampleModal" tabindex="-1"
						role="dialog" aria-labelledby="exampleModalLabel"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel">Resgatar
										Pet</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<h5 class="modal-body">
										Nível de Urgência:
										<%=obj.getInt("nivelUrgencia")%></h5>
									<p class="text">
										Código:
										<%=obj.getInt("codeResgate")%></p>
									<p class="text">
										Observaçoes sobre o Pet:
										<%=obj.getString("descricao")%></p>
									<p class="text">
										Status:
										<%=obj.getString("status")%></p>
									<p class="text">
										<small class="text-muted">Localizacao do Pet: <%=obj.getString("endereco")%></small>
									</p>

									<div class="form-check form-check-inline">
										<input class="form-check-input" type="checkbox"
											id="inlineCheckbox1" value="option1"> <label
											class="form-check-label" for="inlineCheckbox1">Confirmar Resgate</label>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">Cancelar</button>
									<button type="button" class="btn btn-primary">
										Confirmar</button>
								</div>
							</div>
						</div>
					</div>

					<%
						i++;
								if (i == 3) {
									fimWhile = false;
					%>

				</div>
				<br>
				<%
					i = 0;
							} else {
								fimWhile = true;
							}

						}

					}
					System.out.println("Tô aqui dps do while");
					if (fimWhile) {
				%>
			
		</div>
		<%
			}
			//}else{
		%>
		<!-- <h2>sem animais</h2> -->
		<%
			//}
		%>
		</form>

	</div>

	<div id="direita"></div>


	</div>

	<div id="finalPg">
		<img src="img/Rodape2.png" />
	</div>
	<!-- <script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.3.1.min.js"></script> -->
</body>