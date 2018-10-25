CREATE TABLE categoria (
	codigo bigint(20) Primary key auto_increment,
    nome varchar(50) not null)
    engine= InnoDB default charset=utf8;
    
Insert into categoria (nome) values ('Lazer');
Insert into categoria (nome) values ('Alimentação');
insert into categoria (nome) values ('Supermercado');
insert into categoria (nome) values ('Farmacia');
Insert into categoria (nome) values ('Outros');