<<<<<<< HEAD

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
<title>Fa�a seu login</title>
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
				request.getSession().setAttribute("tipo", obj.getString("tipo"));
				

				response.sendRedirect("perfil.jsp");
			}else{
				System.out.println("Usuario n�o existe");
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
			<div style="padding-left: 50%;">
				<a href="#" class="link-forgot-password">Esqueceu sua senha?</a>
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

=======
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
<title>Fa�a seu login</title>
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
				System.out.println("Usuario n�o existe");
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
			<div class="new-forget ">
				<a href="cadastro.jsp">Cadastre-se</a> 
				
				<a href="#" class="link-forgot-password" style="padding-left:19.8%;">Esqueceu sua senha?</a>
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
<<<<<<< HEAD
=======

>>>>>>> b94daa3925dfec8c52c307df94904f7c73c21d7d
>>>>>>> d1394273c90a784ceecb7f9b43780f985f095179
</html>