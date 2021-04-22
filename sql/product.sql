/*
	Таблица для хранения номенклатуры резиновых колец.
*/
DROP TABLE IF EXISTS products;
CREATE TABLE products (

	id serial NOT NULL UNIQUE PRIMARY KEY,
	number varchar(50) NOT NULL,
	name varchar(50) NOT NULL,
	status varchar(50) NOT NULL,
	version varchar(50) NOT NULL,
	update varchar(50) NOT NULL,
	asm_id integer NOT NULL,
	description varchar(5000),
	draw_link varchar(50),
	FOREIGN KEY (asm_id) REFERENCES assemblies (id)	
);



