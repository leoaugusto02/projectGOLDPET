CREATE DATABASE IF NOT EXISTS GoldPet DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
use GoldPet;

CREATE TABLE Usuario{
	codUser integer primary key auto_increment,
	p_nome varchar(15) not null,
	s_nome varchar(15) not null,
	nascimento date not null,
	Tipo varchar(10) not null,
	Endereco varchar(40) not null,
	Senha varchar(15) not null,
	Email varchar(50) not null,
	Genero varchar(1) not null
}CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE Telefone{
	codUser integer not null,
	telefone varchar(11),
	constraint fkCodUserGuard foreign key (codUser) references Usuario (codUser)
}CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE Guardião{
	codUser integer not null,
	animais_resgatados integer,
	constraint fkCodUserGuard foreign key (codUser) references Usuario (codUser)
}CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE Funcionario{
	codUser integer not null,
	cargo varchar(20),
	constraint fkCodUserFunc foreign key (codUser) references Usuario (codUser)
}CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE Animais(
	codAnimal integer primary key auto_increment,
	tipo varchar(15) not null,
	raca varchar(25) not null,
	porte varchar(15) not null,
	idade integer not null,
	status varchar(15) not null,
	sexo varchar(10) not null,
	laudo varchar(10) not null
)CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE Laudo(
	codAnimal integer not null,
	nomeVeterinario varchar(40) not null,
	dataDiagnostico date not null,
	diagnostico varchar(100) not null,
	imagem varchar(30),
	constraint fkCodAnimal foreign key (codAnimal) references Animais (codAnimal)
);

CREATE TABLE Resgatados(
	codResgate integer primary key auto_increment,
	endereço varchar(50) not null,
	nivelUrgencia varchar(25) not null
)CHARACTER SET utf8 COLLATE utf8_general_ci;

							---PARTE DO FORUM---

CREATE TABLE Perguntas(
	codePerguntas integer primary key auto_increment,
	codeUser integer not null,
	pergunta varchar(50) not null,
	descricao varchar(200),
	tema varchar(10),
	constraint fkCodUserPerg foreign key (codUser) references Usuario (codUser)
)CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE Respostas(
	codeRespostas integer primary key auto_increment,
	codUser integer not null,
	codPerg integer not null,
	resposta varchar(250) not null,
	constraint fkCodPerg foreign key (codPerg) references Perguntas (codePerguntas),
	constraint fkCodeUserResp foreign key (codUser) references Usuario (CodeUser)
)CHARACTER SET utf8 COLLATE utf8_general_ci;