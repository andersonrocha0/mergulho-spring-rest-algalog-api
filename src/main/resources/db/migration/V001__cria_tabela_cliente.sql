create table cliente(
    id bigint not null auto_increment primary key,
    nome varchar(60) not null,
    email varchar(60) not null,
    fone varchar(20) not null
);