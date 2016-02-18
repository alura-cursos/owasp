create table usuarios (	id integer not null primary key  GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ,	usuario varchar(255),	senha varchar(255), email varchar(255));


create table perguntas ( id integer not null primary key  GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)  , pergunta varchar(2048), usuario_id integer not null);

alter table perguntas add foreign key (usuario_id) references usuarios(id);

create table respostas ( id integer not null primary key  GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) , resposta varchar(2048), pergunta_id integer not null, usuario_id integer not null);
