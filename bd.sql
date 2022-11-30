DROP DATABASE godear;
CREATE DATABASE godear;
USE godear;

CREATE TABLE usuarios(
id int AUTO_INCREMENT NOT NULL,
login_user varchar (30) NOT NULL,
senha_user varchar(30),
PRIMARY KEY(id));

CREATE TABLE reservas(
id_res int AUTO_INCREMENT NOT NULL,
nome_res varchar(60) NOT NULL,
cpf_res varchar(14) NOT NULL,
cel_res varchar(14) NOT NULL,
sala_res varchar(30) NOT NULL,
data_res varchar(10) NOT NULL,
inicio_res varchar(5) NOT NULL,
fim_res varchar(5) NOT NULL,
PRIMARY KEY(id_res));

INSERT INTO usuarios VALUES (
001, 
'admin',
'12345678');