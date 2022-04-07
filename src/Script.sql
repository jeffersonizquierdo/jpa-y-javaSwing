create database bd_hibernatel ;
use  bd_hibernatel;

create table mascotas(
	id_mascota int (11) not null auto_increment,
    nombre varchar(45) not null,
    raza varchar(45) default null,
    color varchar(45) default null,
    sexo varchar(45) default null,
    primary key (id_mascota)
)engine=InnoDB auto_increment=6 default char set=utf8mb4;

CREATE TABLE persona(
	id_persona int(11) NOT NULL,
	nombre_persona varchar(45) DEFAULT NULL,
	profesion_persona varchar(45) DEFAULT NULL,
	telefono_persona varchar(45) DEFAULT NULL,
	tipo_persona int(2) NOT NULL,
	nacimiento_id int(11) NOT NULL,
PRIMARY KEY (id_persona));

ALTER TABLE mascotas ADD column persona_id int (11)  null after sexo;

CREATE TABLE nacimiento(
	id_nacimiento int(11) NOT NULL AUTO_INCREMENT ,
	ciudad_nacimiento varchar(45) DEFAULT NULL,
	departamento_nacimiento varchar(45) DEFAULT NULL,
	fecha_nacimiento date DEFAULT NULL,
	pais_nacimiento varchar(45) DEFAULT NULL,
PRIMARY KEY (id_nacimiento));

ALTER TABLE persona ADD INDEX fk_persona_nacimiento (nacimiento_id ASC);
ALTER TABLE persona ADD CONSTRAINT fk_persona_nacimiento  FOREIGN KEY (nacimiento_id) REFERENCES nacimiento (id_nacimiento) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE mascotas ADD  INDEX  fk_mascotas_persona_idx (persona_id asc);
ALTER TABLE  mascotas ADD constraint fk_mascotas_persona foreign key  (persona_id) references persona (id_persona) ON DELETE NO ACTION ON UPDATE NO ACTION;

CREATE TABLE productos (
	id_producto int (11) not null auto_increment,
	nombre_producto varchar (45) not null,
	precio_producto double default null,
	primary key (id_producto)
)engine=InnoDB auto_increment=6 default char set=utf8mb4;

CREATE TABLE personas_productos(
	persona_id int (11) not null,
	producto_id int (11) not null,
	key fk_producto (producto_id),
	key fk_persona (persona_id),
	constraint fk_producto foreign key (producto_id) references productos (id_producto),
	constraint fk_persona foreign key (persona_id) references persona (id_persona)
)engine=InnoDB auto_increment=6 default char set=utf8mb4;