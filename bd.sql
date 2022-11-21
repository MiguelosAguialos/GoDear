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
cpf_res int(11) NOT NULL,
cel_res long(30) NOT NULL,
sala_res int(30) NOT NULL,
data_res int(8) NOT NULL,
inicio_res int(4) NOT NULL,
fim_res int(4) NOT NULL,
PRIMARY KEY(id));

INSERT INTO usuarios VALUES (
001, 
'admin',
'12345678');