drop database if exists estacionamento;

create database if not exists estacionamento;

use estacionamento;

create table usuarios(
	id int not null auto_increment primary key,
    username varchar(12) not null,
    password varchar(128) not null,
    tipo tinyint not null
);