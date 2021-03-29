/*
	Таблица для хранения номенклатуры резиновых колец.
*/
DROP TABLE IF EXISTS products;
CREATE TABLE products (

	id serial NOT NULL UNIQUE PRIMARY KEY,
	number varchar(50) NOT NULL,
	name varchar(50) NOT NULL,
	asm_id integer NOT NULL,
	description varchar(5000),
	draw_link varchar(50),
	FOREIGN KEY (asm_id) REFERENCES assemblies (id)	
);


INSERT INTO products(
	number,
	name,
	asm_id,
	description
)  

VALUES (
	'RGR100/5CD',
	'Распределитель',
	17,
	'Распределитель для трактора К-7 (ПТЗ), все 5 секций одинаковые: 4поз. золотник, фиксация в положении "подъем" и "плавающее", управление троссовое (в состоянии поставки без коннектора)'
)


