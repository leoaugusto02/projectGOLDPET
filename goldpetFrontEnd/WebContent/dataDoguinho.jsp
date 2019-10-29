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
	<script src="js/jquery.js"></script>
	<script src="js/jquery-3.3.1.min.js"></script>
</head>
<body>

	<%
	String acao = "perfil";
	
	String parametros = "acao=" + acao;
	
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
						<nav class="navbar navbar-expand-md navbar-light minhaNav">
							<div class="w-100" id="navbarSupportedContent">
								<ul class="navbar-nav mr-auto menu ">
									<li class="nav-item active"><a class="nav-link" href="#">Home
											<span class="sr-only">(current)</span>
									</a></li>
									<li class="nav-item"><a class="nav-link" href="#">Doa��es</a></li>

									<li class="nav-item"><a class="nav-link" href="#">Resgate</a></li>

									<li class="nav-item"><a class="nav-link" href="#">Ado��o</a></li>

									<li class="nav-item"><a class="nav-link" href="#">Sobre
											N�s</a></li>

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
			<div class="col-xs-12 col-sm-9">

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

						<h4 class="card-header">Informa��es Doge</h4>

						<div class="panel-body" border="3px">
							<table class="table profile__table">
								<tbody s>
									<tr>
										<th><strong>Esp�cie:</strong><label></label></th>
										<td><%=obj.getString("especie")%></td>
									</tr>
									<tr>
										<th><strong>Ra�a:</strong></th>
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
								</tbody>
							</table>

						</div>
					</div>
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
												class="custom-control-input" > <label
												class="custom-control-label" for="customRadio2" style="margin-bottom: 3%;">Levar
												at� na casa</label>
										</div>
									</div>

									<div id="levarNaCasa">
										<input class="form-control" type="text" placeholder="CEP" id="cep"
											style="margin-bottom: 3%;" /> 
											
											<script>
											 $(document).ready(function(){ 
										            $("#cep").keyup(function(){
										            	var cep = $("#cep").val();
										            	if(cep.length == 8){
										            		
										                $.get("https://viacep.com.br/ws/"+cep+"/json/",
										                		function(data, status){
										                    console.log(data);
										                    $("#cidade").val(data.localidade);
										                    $("#nomeRua").val(data.logradouro);
										                    $("#bairro").val(data.bairro);
										                });
										            	}
										            });
										        });
											
											</script>
											
											<input class="form-control" type="text" placeholder="Cidade" id="cidade"
											 style="margin-bottom: 3%;" /> 
											
											<input class="form-control" type="text" placeholder="Rua" id="nomeRua"
											 style="margin-bottom: 3%;" /> 
											
											<input class="form-control" type="number" placeholder="N� casa"
											 style="margin-bottom: 3%;" /> 
											
											<input class="form-control" type="text" placeholder="Bairro" id="bairro"
											 style="margin-bottom: 3%;" />

									</div>

									<div id="buscarNaYong">
										<div class="form-group">
											<label class="col-md-5 control-label" for="hora">Horario</label>
											<div class="col-md-5">
												<select id="hora" name="time" class="form-control">
													<option value="N�o informado">N�o informado</option>
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
													<option value="N�o informado">N�o informado</option>
													<option value="Segunda">Segunda</option>
													<option value="Terca">Ter�a</option>
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

				</div>
			</div>
		</div>
	</div>
	<div id="direita"></div>
	
	<script src="js/bootstrap.min.js"></script>
</body>
</html>