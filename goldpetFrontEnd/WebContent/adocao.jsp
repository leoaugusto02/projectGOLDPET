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

	<%
	    String acao = "listaAdocao";
		int codigoAnimal = 1; //request.getParameter("codigoAnimal");



			String parametros = "acao=" + acao;

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
									type="text" placeholder="Raça" style="margin-bottom: 3%;" /> <input
									class="form-control" type="text" placeholder="Porte"
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

			<!-- FORM -->
			
			<form action="#" method="post">

				<div class="d-flex justify-content-around">
				
				<%
				System.out.println("Tô aqui antes do while");
				
				while ((linha = br.readLine()) != null) {
					System.out.println("Tô aqui " + linha);
					obj = new JSONObject(linha);
				
				%>
				<a href="dataDoguinho.jsp">
				<div class="card bg-dark text-white" style="width: 23rem;">
						<img src="img/slide01.png" class="card-img" href="#"
							style="height: 500px;">
						<div class="card-img-overlay">
							<h5 class="card-title"><%=obj.getString("nome")%></h5>
							<p class="card-text">
								Código: <%=obj.getInt("codAnimal")%> <br>
								Status: <%=obj.getString("nome")%><br>
								Raça: <%=obj.getString("raca") %><br>
								Espécie: <%=obj.getString("especie")%><br>
								
							</p>
							<p class="card-text">Last updated 3 mins ago</p>
						</div>
					</div>
					</a>
				<%
				}
				System.out.println("Tô aqui dps do while");
				%>
				<!--	<div class="card bg-dark text-white" style="width: 23rem;">
						<img src="img/slide01.png" class="card-img" href="#"
							style="height: 500px;">
						<div class="card-img-overlay">
							<h5 class="card-title">Nome do dogzin</h5>
							<p class="card-text">Informaçoes basicas sobre o dogzin
								clicando na imagem ira para o perfil dele para ver os laudos
								medicos e saber mais sobre o dog</p>
							<p class="card-text">Last updated 3 mins ago</p>
						</div>
					</div>
				</div>
				
			 	 <div class="card bg-dark text-white" style="width: 23rem;">
						<img src="img/slide01.png" class="card-img" href="#"
							style="height: 500px;">
						<div class="card-img-overlay">
							<h5 class="card-title">Nome do dogzin</h5>
							<p class="card-text">Informaçoes basicas sobre o dogzin
								clicando na imagem ira para o perfil dele para ver os laudos
								medicos e saber mais sobre o dog</p>
							<p class="card-text">Last updated 3 mins ago</p>
						</div>
					</div>

					<div class="card bg-dark text-white" style="width: 23rem;">
						<img src="img/slide01.png" class="card-img" href="#"
							style="height: 500px;">
						<div class="card-img-overlay">
							<h5 class="card-title">Nome do dogzin</h5>
							<p class="card-text">Informaçoes basicas sobre o dogzin
								clicando na imagem ira para o perfil dele para ver os laudos
								medicos e saber mais sobre o dog</p>
							<p class="card-text">Last updated 3 mins ago</p>
						</div>
					</div>
				</div>

				<div class="d-flex justify-content-around" style="margin-top: 2%;">
					<div id="infoDog">
						<div class="card bg-dark text-white" style="width: 23rem;">
							<img src="img/slide01.png" class="card-img" href="#"
								style="height: 500px;">
							<div class="card-img-overlay">
								<h5 class="card-title">Nome do dogzin</h5>
								<p class="card-text">Informaçoes basicas sobre o dogzin
									clicando na imagem ira para o perfil dele para ver os laudos
									medicos e saber mais sobre o dog</p>
								<p class="card-text">Last updated 3 mins ago</p>
							</div>
						</div>
					</div>


					<div class="card bg-dark text-white" style="width: 23rem;">
						<img src="img/slide01.png" class="card-img" href="#"
							style="height: 500px;">
						<div class="card-img-overlay">
							<h5 class="card-title">Nome do dogzin</h5>
							<p class="card-text">Informaçoes basicas sobre o dogzin
								clicando na imagem ira para o perfil dele para ver os laudos
								medicos e saber mais sobre o dog</p>
							<p class="card-text">Last updated 3 mins ago</p>
						</div>
					</div>

					<div class="card bg-dark text-white" style="width: 23rem;">
						<img src="img/slide01.png" class="card-img" href="#"
							style="height: 500px;">
						<div class="card-img-overlay">
							<h5 class="card-title">Nome do dogzin</h5>
							<p class="card-text">Informaçoes basicas sobre o dogzin
								clicando na imagem ira para o perfil dele para ver os laudos
								medicos e saber mais sobre o dog</p>
							<p class="card-text">Last updated 3 mins ago</p>
						</div>
					</div>
				</div>
				<input type="hidden" name="acao" id="acao" value="card" /> -->
			</form>
		</div>

		<div id="direita"></div>

	</div>
	 <script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.3.1.min.js"></script> 
	
	<script>
		function card(){
			$("#acao").val("card");
		}
	
	</script>

</body>