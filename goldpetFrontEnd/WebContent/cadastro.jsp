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
		<div>
			<form method="post" action="#">
		</div>
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
				placeholder="CEP" maxlength="10"
				onkeydown="javascript: fMasc( this, mCEP );" required autofocus
				autocomplete="on" required="required">
		</div>
		<div class="form-group">
			<input type="text" class="form-group col-md-6" name="referencia"
				placeholder="Referência" required autofocus autocomplete="on"
				required="required">
		</div>
		<div class="form-group">
			<input type="text" class="form-group col-md-6" name="cpf"
				placeholder="CPF" maxlength="14"
				onkeydown="javascript: fMasc( this, mCPF );" required autofocus
				autocomplete="on" required="required">
		</div>
		<div class="form-group">
			<input type="text" class="form-group col-md-6" name="rg"
				placeholder="RG" maxlength="12"
				onkeydown="javascript: fMasc( this, mRG );" required autofocus
				autocomplete="on" required="required">
		</div>
		<div class="form-group">
			<input type="text" class="form-group col-md-6" name="tel1" id="tel1"
				maxlength="14" onkeydown="javascript: fMasc( this, mTel );"
				placeholder="Celular">
		</div>
		<div class="form-group">
			<input type="text" class="form-group col-md-6" name="tel2"
				placeholder="Telefone" maxlength="14"
				onkeydown="javascript: fMasc( this, mTel );" required autofocus
				autocomplete="on" required="required">
		</div>
		<div class="form-group">
			<input type="email" class="form-group col-md-6" name="email"
				placeholder="Ex. exemplo@example.com" required autofocus autocomplete="on"
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
		String acaoConta = "Guardião";

		if ((pNome != null) && (sNome != null) && (apelido != null) && (cep != null) && (referencia != null)
				&& (cpf != null) && (rg != null) && (tel1 != null) && (dataNasc != null) && (email != null)
				&& (senha != null) && (confSenha != null) && (genero != null) && (acao != null)) {

			if (tel2.equals("")) {
				tel2 = "-"; //comit pro Correa
			}

			String parametros = "pNome=" + pNome + "&sNome=" + sNome + "&apelido=" + apelido + "&cep=" + cep
					+ "&referencia=" + referencia + "&cpf=" + cpf + "&rg=" + rg + "&tel1=" + tel1 + "&tel2=" + tel2
					+ "&nascimento=" + dataNasc + "&email=" + email + "&senha=" + senha + "&confSenha=" + confSenha
					+ "&genero=" + genero + "&acao=" + acao + "&acaoConta=" + acaoConta;

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
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.11/jquery.mask.min.js"></script>
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script>
		function cadastrar() {
			$("#acao").val("cadastrar");
		}
	</script>
	<script type="text/javascript">
	function fMasc(objeto, mascara) {
		obj = objeto
		masc = mascara
		setTimeout("fMascEx()", 1)
	}

	function fMascEx() {
		obj.value = masc(obj.value)
	}

	function mTel(tel) {
		tel = tel.replace(/\D/g, "")
		tel = tel.replace(/^(\d)/, "($1")
		tel = tel.replace(/(.{3})(\d)/, "$1)$2")
		if (tel.length == 9) {
			tel = tel.replace(/(.{1})$/, "-$1")
		} else if (tel.length == 10) {
			tel = tel.replace(/(.{2})$/, "-$1")
		} else if (tel.length == 11) {
			tel = tel.replace(/(.{3})$/, "-$1")
		} else if (tel.length == 12) {
			tel = tel.replace(/(.{4})$/, "-$1")
		} else if (tel.length > 12) {
			tel = tel.replace(/(.{4})$/, "-$1")
		}
		return tel;
	}

	function mCPF(cpf) {
		cpf = cpf.replace(/\D/g, "")
		cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2")
		cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2")
		cpf = cpf.replace(/(\d{3})(\d{1,2})$/, "$1-$2")

		return cpf
	}

	function mRG(rg) {
		rg = rg.replace(/\D/g, "")
		rg = rg.replace(/(\d{2})(\d)/, "$1.$2")
		rg = rg.replace(/(\d{3})(\d)/, "$1.$2")
		rg = rg.replace(/(\d{3})(\d{1,1})$/, "$1-$2")
		return rg
	}

	function mCEP(cep) {
		cep = cep.replace(/\D/g, "")
		cep = cep.replace(/^(\d{2})(\d)/, "$1.$2")
		cep = cep.replace(/\.(\d{3})(\d)/, ".$1-$2")
		return cep
	}

	function mNum(num) {
		num = num.replace(/\D/g, "")
		return num
	}
</script>
	<script>
	function validarCPF(cpf) {

		cpf = cpf.replace(/[^\d]+/g, '');
		if (cpf == '')
			return false;
		// Elimina CPFs invalidos conhecidos	
		if (cpf.length != 11 || cpf == "00000000000" || cpf == "11111111111"
				|| cpf == "22222222222" || cpf == "33333333333"
				|| cpf == "44444444444" || cpf == "55555555555"
				|| cpf == "66666666666" || cpf == "77777777777"
				|| cpf == "88888888888" || cpf == "99999999999") {

			return false;

		}
		// Valida 1o digito	
		add = 0;
		for (i = 0; i < 9; i++)
			add += parseInt(cpf.charAt(i)) * (10 - i);
		rev = 11 - (add % 11);
		if (rev == 10 || rev == 11)
			rev = 0;
		if (rev != parseInt(cpf.charAt(9)))
			return false;
		// Valida 2o digito	
		add = 0;
		for (i = 0; i < 10; i++)
			add += parseInt(cpf.charAt(i)) * (11 - i);
		rev = 11 - (add % 11);

		if (rev == 10 || rev == 11)
			rev = 0;
		if (rev != parseInt(cpf.charAt(10)))
			return false;

		return true;

	}

	function validaDOC(cpf) {

		if (validarCPF(cpf) == false) {
			//document.getElementById("campoCPF").value = "";
			document.getElementById("campoCPF").select();
			document.getElementById("campoCPF").focus();
			document.getElementById("campoCPF").style.backgroundColor = "#ffc2c2";
		}/*else{

	}

	function limpa() {
		document.getElementById("campoCPF").style.backgroundColor = "white";
	}
</script>
</body>
</html>