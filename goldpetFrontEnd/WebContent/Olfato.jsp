<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
body {
	height: 1200px;
	background-color: #8aedc2;
	background-image: linear-gradient(#139f97, white);
	background-repeat: no-repeat, repeat;
}

.conteudo {
	display: flex;
	flex-direction: row;
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
	background-image: linear-gradient(#139f97);
	background-repeat: no-repeat, repeat;
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

.minhaNav {
	background-color: #139F97;
	margin-top: 6%;
	height: 30%;
}

#imgPet>img {
	border-radius: 70%;
	overflow: hidden;
	width: 150px;
	height: 150px;
	margin-left: 0.5%;
}

.menu {
	padding-right: 15px;
	width: 100%;
}

.menu>li {
	padding-left: 15px;
}

p.round {
	text-align: center;
	width: 400px;
	height: 50px;
	margin-left: 220px;
	font-size: 35px;
	color: white;
	text-shadow: 1px 1px 2px black, 0 0 25px blue, 0 0 5px darkblue;
}

.clearfix {
	margin-left: 250px;
	width: 600px;
	height: 225px;
}

.texto {
	margin-left: 10px;
	width: 800px;
	height: 225px;
	font-size: 18px;
}

.button {
	margin-left: 500px;
	padding: 12px 258px;
}
</style>
<head>
<meta charset="UTF-8" />
<meta charset="ISO-8859-1">
<title>Olfatos</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div class="conteudo">

		<div id="esquerda"></div>
		<div id="meio">
			<div id="cabecalho">

				<div id="imgLogo">
					<img src="img/LogoPet.png" style="width: 220px; height: 220px;" />
				</div>

				<div class="navC d-flex w-100 justfy-content-center">

					<div class="w-100">
						<nav class="navbar navbar-expand-lg navbar-light minhaNav">
							<a class="navbar-brand" href="Index.jsp">Home</a>
							<button class="navbar-toggler" type="button"
								data-toggle="collapse" data-target="#navbarNavAltMarkup"
								aria-controls="navbarNavAltMarkup" aria-expanded="false"
								aria-label="Toggle navigation">
								<span class="navbar-toggler-icon"></span>
							</button>
							<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
								<div class="navbar-nav">
									<a class="nav-item nav-link active" href="adocao.jsp">adoção<span
										class="sr-only">(current)</span></a> <a class="nav-item nav-link "
										href="Resgate.jsp">resgate</a> <a
										class="nav-item nav-link active" href="DicasPets.jsp">Dicas</a>
									<a class="nav-item nav-link " href="questionPage.jsp">Forun</a>
									<a class="nav-item nav-link active" href="GerenciarUsuario.jsp">Dashboard</a>
									<a class="nav-item nav-link " href="AjudeOng.jsp">Ajude-nos</a>
								</div>
							</div>
						</nav>
					</div>
				</div>
			</div>
			<div class="clearfix">
				<img class="img1" src="img/olfato.png" alt="Olfato" width="800px"
					height="290px"> <br> <br>
				<p class="round">Olfatos</p>
				<p class="texto">
					Você sabia que os cachorros percebem os cheiros 1 milhão de vezes
					melhor do que os seres humanos? “Esse olfato é tão poderoso que o
					seu pet pode captar odores que você nem de longe poderia imaginar
					(e sentir). Os cães são capazes de sentir o cheiro de um inseto que
					está a longas distâncias ou até uma gota de sangue em um grande
					compartimento com água”, conta Dra. Luana Sartori. Não é a toa que
					alguns animais são utilizados na busca por desaparecidos em uma
					tragédia natural, por exemplo." <br> Se você observar filhotes
					caninos recém-nascidos, vai perceber que mesmo sem abrir os olhos
					eles encontram a mãe e as mamas para se alimentar. Isso acontece
					porque o olfato é o primeiro sentido desenvolvido nos cachorros. Há
					uma história bem conhecida que conta a peripécia de Fern,um cão
					nascido na Irlanda do Norte, que foi capaz de encontrar uma lata de
					carne escondida nas profundidades do Lago Castlewellan”, revela a
					veterinária. Mas não é só isso, ele farejou o alimento cerca de dez
					minutos depois que o barco submergiu a lata. O lago possui 1,5
					quilômetro de comprimento e 800 metros de largura. <br> É
					através desse olfato apurado que os cães se comunicam. Por isso,
					que eles buscam rabos alheios para cheirar.
				</p>
				<br> <br> <br> <br> <br> <br> <br>
				<br>
				<button type="button" class="btn btn-primary">Voltar</button>
			</div>

		</div>
	</div>

</body>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</html>