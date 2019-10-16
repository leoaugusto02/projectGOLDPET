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

	<form action="#">
		<div class="container" style="text-align: center">
			<h2>Cadastro Guardião</h2>
			<div id="imgLogo">
				<img src="img/escudo.png" style="width: 220px; height: 220px;" />
			</div>


			<h4>Digite seus dados nos campos abaixo</h4>
			<div class="form-group">
				<input type="name" class="form-group col-md-6" name="apelido"
					placeholder="Apelido">
			</div>
			<div class="form-group">
				<input type="name" class="form-group col-md-6" name="pNome"
					placeholder="Primeiro Nome">
			</div>
			<div class="form-group">
				<input type="name" class="form-group col-md-6" name="sNome"
					placeholder="Sobrenome">
			</div>
			<div class="form-group">
				<input type="date" class="form-group col-md-6" name="nascimento">
			</div>
			<div class="form-group">
				<input type="text" class="form-group col-md-6" name="cep"
					placeholder="CEP">
			</div>
			<div class="form-group">
				<input type="text" class="form-group col-md-6" name="referencia"
					placeholder="Referência">
			</div>
			<div class="form-group">
				<input type="text" class="form-group col-md-6" name="cpf"
					placeholder="CPF">
			</div>
			<div class="form-group">
				<input type="text" class="form-group col-md-6" name="rg"
					placeholder="RG">
			</div>
			<div class="form-group">
				<input type="text" class="form-group col-md-6" name="tel1"
					placeholder="Celular">
			</div>
			<div class="form-group">
				<input type="text" class="form-group col-md-6" name="tel2"
					placeholder="Telefone">
			</div>
			<div class="form-group">
				<input type="email" class="form-group col-md-6" name="email"
					placeholder="Email">
			</div>
			<div class="form-group">
				<input type="password" class="form-group col-md-6" name="senha"
					placeholder="Senha">
			</div>
			<div class="form-group">
				<input type="password" class="form-group col-md-6" name="confSenha"
					placeholder="Confirmar Senha">
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
			<input type="hidden" name="acao" id="acao" value="cadastrar"/>
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
		
		if ((pNome != null) && (sNome != null) && (apelido != null) && (cep != null) && 
				(referencia != null) && (cpf != null) && (rg != null) && 
				(tel1 != null) && (dataNasc != null) && (email != null) &&
				(senha != null) && (confSenha != null) && (genero != null) && (acao != null)) {

			if(tel2.equals("")){
				tel2 = "-";
			}
			
			String parametros = "pNome=" + pNome + "&sNome=" + sNome + "&apelido=" + apelido +
					"&cep=" + cep + "&referencia=" + referencia + "&cpf="+ cpf + "&rg=" + rg +
					"&tel1=" + tel1 + "&tel2=" + tel2 + "&nascimento=" + dataNasc + "&email=" + email +
					"&senha=" + senha + "&confSenha=" + confSenha + "&genero=" + genero
					+ "&acao=" + acao;
			
			URL url = new URL("http://localhost:8080/goldpetBackEnd/ProcessaPessoas");

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setDoOutput(true);
			
			System.out.println(parametros);

			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(parametros);

		 	BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

			String apnd = "", linha = "";
			
			while((linha = br.readLine()) != null) apnd += linha;
			
			JSONObject obj = new JSONObject(apnd);
			
			System.out.println("Chegou aqui");
	
			if(obj.getString("mensagem").equals("0")){
				
				%>	
				<div class="card border-success mb-2">
					<div class="card-text" style="padding:2%;text-align:center">Cadastro Concluido</div>
					<a class="btn btn-success" href="login.jsp" style="margin:3%">
					Retornar para a página de login</a> 			
				</div>
				<% 	
			
			}else if(obj.getString("mensagem").equals("2")){
				System.out.println("As senhas precisam ser iguais");
			}else if(obj.getString("mensagem").equals("3")){
				System.out.println("Usuario já existe");
			}else{
				System.out.println("OPS! Algo deu errado");
			}
			
		}else{
			System.out.println("Todos os campos precisam ser preenchidos");
		}
			%>
	</form>
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script>
		function cadastrar() {
			$("#acao").val("cadastrar");
		}
	</script>
</body>
</html>