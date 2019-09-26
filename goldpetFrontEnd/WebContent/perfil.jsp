<%@page import="java.io.DataOutputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Meu Perfil</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body class="bg-" background="img/blue.jpg">

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="Index.jsp">Forum do Forum</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="postPage.jsp">Faça sua pergunta
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="listPage.jsp">Perguntas</a></li>
			</ul>
		</div>
	</nav>

	<br>

	<div class="container">
		<div class="col-xs-12 col-sm-9">

			<!-- User profile -->
			<div class="container">

				<div class="card  mb-8">
					<div class="card-header">Perfil</div>
					<div class="card-body">
						<div
							style="float: left width: 60px; height: 60px; border-radius: 50%; margin-right: 20px; overflow: hidden; width: 100px; height: 100px">
							<center>
								<img src="https://bootdey.com/img/Content/avatar/avatar5.png"
									alt="..." style="width: 100%; height: auto">
						</div>
						<div class="card-title" style="margin: 20px 0">

							</center>
						</div>

					</div>
				</div>
			</div>

			<br>
			<!-- User info -->
			<div class="container">
				<div class="card  mb-8">

					<h4 class="card-header">Informações Usuario</h4>

					<div class="panel-body" border="3px">
						<table class="table profile__table">
							<tbody>
								<tr>
									<th><strong>Nome:</strong><label></label></th>
								</tr>
								<tr>
									<th><strong>Data de Nascimento:</strong></th>
								</tr>
								<tr>
									<th><strong>Genero: 
									</strong></th>
								</tr>
								<tr>
									<th><strong>Telefone:
									</strong></th>
								</tr>
								<tr>
									<th><strong>Email:</strong></th>
								</tr>
							</tbody>
						</table>

					</div>
				</div>

			</div>
		</div>
	</div>

	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>