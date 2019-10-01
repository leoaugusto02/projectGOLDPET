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

	<div class="card card-splash"
		style="margin-left: 42.5%; margin-top: 10%; width: 300px; background-color: rgba(199, 252, 255, 0.5);">
		<div>


			<img src="img/LogoPet.png" width="300px" height="300px">


		</div>
		<div class="card-base">






			<div class="card-content processing">


				<form class="login-with-password-reset" method="POST">


					<div class="form-group form-group-icon">
						<input name="login" type="email"
							class="form-control form-control-lg login-email"
							placeholder="Digite seu email/usuario" required autofocus
							autocomplete="on">
					</div>
					<div class="form-group form-group-icon">
						<span class="component-hint block"> <input
							class="form-control form-control-lg login-password can-be-visible"
							type="password" name="password" maxlength="40"
							placeholder="Digite sua senha" required>

						</span>

					</div>
					<div class="form-group"></div>
					<div class="form-group">
						<button class="btn btn-lg btn-bold btn-login full-x btn-theme">

							<i class="fa fa-refresh animation-spin form-loading"></i>

						</button>
						<button type="button" class="btn btn-success"
							style="margin-left: 25%;">entrar</button>
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



</body>

</html>