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

		<div class="container" style="text-align:center">
			<div id="imgLogo">
				<img src="img/escudo.png" style="width: 220px; height: 220px;" />
			</div>


			<h4>Digite seus dados nos campos abaixo</h4>
			<div class="form-group">
				<input type="name" class="form-group col-md-6"
					placeholder="Primeiro Nome">
			</div>
			<div class="form-group">
				<input type="name" class="form-group col-md-6"
					placeholder="Sobrenome">
			</div>
			<div class="form-group">
				<input type="date" class="form-group col-md-6">
			</div>
			<div class="form-group">
				<input type="text" class="form-group col-md-6"
					placeholder="Endereço">
			</div>
			<div class="form-group">
				<input type="text" class="form-group col-md-6" placeholder="Email">
			</div>
			<div class="form-group">
				<input type="text" class="form-group col-md-6"
					placeholder="Senha">
			</div>
			<div class="form-group">
				<input type="text" class="form-group col-md-6" placeholder="Confirmar Senha">
			</div>
			<div class="form-group">
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="Gender"
						id="RadioM" value="M"> <label class="form-check-label"
						for="RadioM">Masculino</label>
				</div>
			
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="radio" name="Gender"
						id="RadioF" value="F"> <label class="form-check-label"
						for="RadioF">Feminino</label>
				</div>
				<div class="custom-control custom-checkbox">
					
				</div>
			</div>
			<input type="button" value="Cadastrar" />
		</div>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery-3.3.1.min.js"></script>
</body>
</html>