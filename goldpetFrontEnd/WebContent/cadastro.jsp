<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.io.DataOutputStream"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.background {
	margin: 0;
	font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
		"Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji",
		"Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
	font-size: 1rem;
	font-weight: 400;
	line-height: 1.5;
	color: #212529;
	text-align: left;
	background-color: #b3d7ff;;
}
</style>
<meta charset="ISO-8859-1">
<title>Cadastro Guardião</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>


	<div class="container" style="text-align: center">
		<h2>Cadastro Guardião</h2>
		<div id="imgLogo">
			<img src="img/escudo.png" style="width: 220px; height: 220px;" />
		</div>

		<h4>Digite seus dados nos campos abaixo</h4>

		<div id="buttonAdd"
			style="margin-left: 23%; margin-bottom: 2%; width: 15%;">
			<button type="button" class="btn btn-outline-success"
				data-toggle="modal" data-target="#siteModal">
				<img alt="add.png" src="img/add.png"
					style="height: 20px; width: 20px; margin-left: -0.5;">
				Adicionar foto do perfil
			</button>
		</div>
		<form action="http://localhost:8080/goldpetBackEnd/ProcessaAnimais"
			method="POST" enctype="multipart/form-data">
			<div class="modal" id="siteModal" tabindex="-1" role="dialog"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">

						<div class="modal-header" style="background-color: #139F97;">
							<h5 class="modal-title">Foto do perfil</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span>x</span>
							</button>
						</div>

						<div class="modal-body">


							<input type="file" id="upload" name="imagem"
								style="float: left; margin-top: 6%;"> <img id="img"
								style="width: 300px;" />
							<script>
								$(function() {
									$('#upload')
											.change(
													function() {
														console.log($(this));
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

						<div class="modal-footer">

							<input type="submit" class="btn btn-primary" value="Ok"/>
							<input type="hidden" name="imagem" id="imagem" value="inserirPet" />
							<input type="hidden" name="pathFile"
								value="<%=getServletContext().getRealPath("/").replace('\\', '/')%>" />
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
		</form>
		<form action="#">
			<div class="form-group">
				<input type="text" class="form-group col-md-6" name="apelido"
					placeholder="Apelido" required autofocus autocomplete="on"
					required="required">
			</div>
			<div class="form-group">
				<input type="text" class="form-group col-md-6" name="pNome"
					placeholder="Primeiro Nome" required autofocus autocomplete="on"
					required="required">
			</div>
			<div class="form-group">
				<input type="text" class="form-group col-md-6" name="sNome"
					placeholder="Sobrenome" required autofocus autocomplete="on"
					required="required">
			</div>
			<div class="form-group">
				<input type="date" class="form-group col-md-6" name="nascimento"
					required autofocus autocomplete="on" required="required">
			</div>
			<div class="form-group">
				<input type="text" class="form-group col-md-6" name="cep"
					placeholder="CEP" required autofocus autocomplete="on"
					required="required">
			</div>
			<div class="form-group">
				<input type="text" class="form-group col-md-6" name="referencia"
					placeholder="Referência" required autofocus autocomplete="on"
					required="required">
			</div>
			<div class="form-group">
				<input type="text" class="form-group col-md-6" name="cpf"
					placeholder="CPF" required autofocus autocomplete="on"
					required="required">
			</div>
			<div class="form-group">
				<input type="text" class="form-group col-md-6" name="rg"
					placeholder="RG" required autofocus autocomplete="on"
					required="required">
			</div>
			<div class="form-group">
				<input type="text" class="form-group col-md-6" name="tel1"
					placeholder="Celular">
			</div>
			<div class="form-group">
				<input type="text" class="form-group col-md-6" name="tel2"
					placeholder="Telefone" required autofocus autocomplete="on"
					required="required">
			</div>
			<div class="form-group">
				<input type="email" class="form-group col-md-6" name="email"
					placeholder="Email" required autofocus autocomplete="on"
					required="required">
			</div>
			<div class="form-group">
				<input type="password" class="form-group col-md-6" name="senha"
					placeholder="Senha" required autofocus autocomplete="on"
					required="required">
			</div>
			<div class="form-group">
				<input type="password" class="form-group col-md-6" name="confSenha"
					placeholder="Confirmar Senha" required autofocus autocomplete="on"
					required="required">
			</div>
			<div class="form-group">
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="genero"
						id="RadioM" value="M"> <label class="form-check-label"
						for="RadioM">Masculino</label>
				</div>

				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="genero"
						id="RadioF" value="F"> <label class="form-check-label"
						for="RadioF">Feminino</label>
				</div>
			</div>
			<input type="submit" class="btn btn-primary" value="Cadastrar">
			<input type="hidden" name="acao" id="acao" value="cadastrar" />
		</form>
	</div>

	<%
		String pNome = request.getParameter("pNome");
		String sNome = request.getParameter("sNome");
		String apelido = request.getParameter("apelido");
		String cep = request.getParameter("cep");
		String referencia = request.getParameter("referencia");
		String cpf = request.getParameter("cpf");
		String rg = request.getParameter("rg");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String confSenha = request.getParameter("confSenha");
		String genero = request.getParameter("genero");
		String acao = request.getParameter("acao");
		String dataNasc = request.getParameter("nascimento");
		String imagem = request.getParameter("imagem");
		String acaoConta = "Guardião";

		if ((pNome != null) && (sNome != null) && (apelido != null) && (cep != null) && (referencia != null)
				&& (cpf != null) && (rg != null) && (tel1 != null) && (dataNasc != null) && (email != null)
				&& (senha != null) && (confSenha != null) && (genero != null) && (acao != null)
				&& (imagem != null)) {

			if (tel2.equals("")) {
				tel2 = "-"; //comit pro Correa
			}

			String parametros = "pNome=" + pNome + "&sNome=" + sNome + "&apelido=" + apelido + "&cep=" + cep
					+ "&referencia=" + referencia + "&cpf=" + cpf + "&rg=" + rg + "&tel1=" + tel1 + "&tel2=" + tel2
					+ "&nascimento=" + dataNasc + "&email=" + email + "&senha=" + senha + "&confSenha=" + confSenha
					+ "&genero=" + genero + "&acao=" + acao + "&acaoConta=" + acaoConta + "&imagem=" + imagem;

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

			System.out.println("Chegou aqui");

			if (obj.getString("mensagem").equals("0")) {
	%>
	<div class="card border-success mb-2">
		<div class="card-text" style="padding: 2%; text-align: center">Cadastro
			Concluido</div>
		<a class="btn btn-success" href="Login.jsp" style="margin: 3%">
			Retornar para a página de login</a>
	</div>
	<%
		} else if (obj.getString("mensagem").equals("2")) {
				System.out.println("As senhas precisam ser iguais");
			} else if (obj.getString("mensagem").equals("3")) {
				System.out.println("Usuario já existe");
			} else {
				System.out.println("OPS! Algo deu errado");
			}

		} else {
			System.out.println("Todos os campos precisam ser preenchidos");
	%>
	<div class="card border-success mb-2">
		<div class="card-text" style="padding: 2%; text-align: center">Cadastro
			Concluido</div>
		<a class="btn btn-success" href="Login.jsp" style="margin: 3%">
			Retornar para a página de login</a>
	</div>
	<%
		}
	%>
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script>
		function cadastrar() {
			$("#acao").val("cadastrar");
		}
	</script>
</body>
</html>