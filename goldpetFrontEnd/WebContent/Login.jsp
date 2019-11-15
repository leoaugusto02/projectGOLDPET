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
<meta charset="ISO-8859-1">
<title>Faça seu login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body background="img/bgBone.jpg">

	<%
	
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String acao = request.getParameter("acao");
		
		if ((login != null) && (senha != null) && (acao != null)) {

			String parametros = "login=" + login + "&senha=" + senha + "&acao=" + acao;
			
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
			
			if(obj.getString("mensagem").equals("0")){
				request.getSession().setAttribute("codigoUsuario", obj.getInt("codeUser"));

				response.sendRedirect("perfil.jsp");
			}else{
				System.out.println("Usuario não existe");
			}
			
		}else {
			System.out.println("Todos os campos precisam ser preenchidos");
		}
	%>

	<div class="card card-splash"
		style="margin-left: 42.5%; margin-top: 10%; width: 300px; background-color: rgba(199, 252, 255, 0.5);">
		<div>

			<img src="img/LogoPet.png" width="300px" height="300px">

		</div>
		<div class="card-base">

			<div class="card-content processing">

				<form class="login-with-password-reset" acao="#" method="POST">

					<div class="form-group form-group-icon">
						<input name="login" type="text"
							class="form-control form-control-lg login-email"
							placeholder="Digite seu email/usuario" required autofocus
							autocomplete="on" required="required">
					</div>
					<div class="form-group form-group-icon">
						<span class="component-hint block"> <input
							class="form-control form-control-lg login-password can-be-visible"
							type="password" maxlength="40" placeholder="Digite sua senha"
							required name="senha" required="required">
						</span>

					</div>
					<div class="form-group"></div>
					<div class="form-group">
						<button class="btn btn-lg btn-bold btn-login full-x btn-theme">

							<i class="fa fa-refresh animation-spin form-loading"></i>

						</button>
						<input type="submit" class="btn btn-success"
							style="margin-left: 25%;" value="Entrar" />
						<input type="hidden" name="acao" value="login" id="acao" >	
					</div>
				</form>
			</div>
			<div class="criacao" style="padding-bottom:10%;">
				<a href="#" class="link-forgot-password" style="padding-left: 50%;">Esqueceu sua senha?</a>
				<a href="cadastro.jsp" style="padding-right:50%;">Criar Conta</a>
			</div>
			
			<div style="margin-bottom:10%;">
			</div>
			
		</div>
	</div>
	<div class="card-base">

		<div class="card-content processing"></div>

	</div>
	
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
	<script>
		function login() {
			$("#acao").val("login");
		}
	</script>

</body>

</html>