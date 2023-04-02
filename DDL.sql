create schema anotacao;

use anotacao;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on anotacao.* to user@'localhost';

create table usr_usuario (
  usr_id bigint unsigned not null auto_increment,
  usr_nome varchar(20) not null,
  usr_senha varchar(100) not null,
  primary key (usr_id),
  unique key uni_usuario_nome (usr_nome)
);