/*
	Таблица для хранения номенклатуры резиновых колец.
*/
DROP TABLE IF EXISTS orings;
CREATE TABLE orings (

	id serial NOT NULL UNIQUE PRIMARY KEY,
	number varchar(50) NOT NULL,
	name varchar(50) NOT NULL,
	standart varchar(50) NOT NULL,
	cross_section real NOT NULL,
	internal_diameter real NOT NULL
		
);

/*
	Таблица для хранения номенклатуры УДАЛЕННЫХ резиновых колец.
*/
DROP TABLE IF EXISTS orings_deleted;
CREATE TABLE orings_deleted (

	id serial NOT NULL UNIQUE PRIMARY KEY,
	number varchar(50) NOT NULL,
	name varchar(50) NOT NULL,
	standart varchar(50) NOT NULL,
	cross_section real NOT NULL,
	internal_diameter real NOT NULL
		
);

/*
	Таблица для хранения номенклатуры стандартных изделий: винты, болты, шайбы, гайки, прокладки, стопорные кольца и т.д.
*/
DROP TABLE IF EXISTS standart_parts;
CREATE TABLE standart_parts (

	id serial NOT NULL UNIQUE PRIMARY KEY,
	number varchar(50) NOT NULL,
	name varchar(50) NOT NULL,
	standart varchar(50) NOT NULL
		
);

/*
	Таблица для хранения префиксов деталей
*/
DROP TABLE IF EXISTS number_prefixes;
CREATE TABLE number_prefixes (

	id serial NOT NULL UNIQUE PRIMARY KEY,
	name varchar(50) NOT NULL,
	description varchar(100)
		
);








-- Заполнение таблицы orings
INSERT INTO orings (

	cross_section,
	internal_diameter,
	name,
	number,
	standart
	
)

-- Занесение данных в таблицу
VALUES

	(1.9, 14.6, 'O-Ring', '14,6x1,9 NBR80', 'ISO3601-1'),
	(1.9, 20.5, 'O-Ring', '20,5x1,9 NBR80', 'ISO3601-1'),
	(1.9, 18.5, 'O-Ring', '18,5x1,9 NBR80', 'ISO3601-1'),
	(1.9, 4.7, 'O-Ring', '4,7x1,9 NBR80', 'ISO3601-1'),
	(1.9, 8.7, 'O-Ring', '8,7x1,9 NBR80', 'ISO3601-1'),
	(1.9, 7.7, 'O-Ring', '7,7x1,9 NBR80', 'ISO3601-1'),
	(1.9, 9.7, 'O-Ring', '9,7x1,9 NBR80', 'ISO3601-1'),
	(1.9, 10.6, 'O-Ring', '10,6x1,9 NBR80', 'ISO3601-1'),
	(1.9, 16.6, 'O-Ring', '16,6x1,9 NBR80', 'ISO3601-1'),
	(1.9, 17.5, 'O-Ring', '17,5x1,9 NBR80', 'ISO3601-1'),	
	(2.5, 23.5, 'O-Ring', '23,5x2,5 NBR80', 'ISO3601-1'),
	(1.9, 16.5, 'O-Ring', '16,5x1,9 NBR80', 'ISO3601-1'),
	(1.9, 12.5, 'O-Ring', '12,5x1,9 NBR80', 'ISO3601-1'),
	(1.6, 10.1, 'O-Ring', '10,1x1,6 NBR80', 'ISO3601-1'),
	(2.2, 17.3, 'O-Ring', '17,3x2,2 NBR80', 'ISO3601-1'),
	(2.5, 25.5, 'O-Ring', '25,5x2,5 NBR80', 'ISO3601-1'),
	(2.5, 29.5, 'O-Ring', '29,5x2,5 NBR80', 'ISO3601-1'),
	(2.5, 44, 'O-Ring', '44x2,5 NBR80', 'ISO3601-1'),	
	(2.5, 20.5, 'O-Ring', '20,5x2,5 NBR80', 'ISO3601-1'),	
	(2.5, 15.6, 'O-Ring', '15,6x2,5 NBR80', 'ISO3601-1'),
	(2.5, 12.6, 'O-Ring', '12,6x2,5 NBR80', 'ISO3601-1'),	
	(2.5, 18.5, 'O-Ring', '18,5x2,5 NBR80', 'ISO3601-1'),	
	(2.5, 37, 'O-Ring', '37x2,5 NBR80', 'ISO3601-1'),
	(1.9, 24.5, 'O-Ring', '24,5x1,9 NBR80', 'ISO3601-1'),	
	(2.5, 63.5, 'O-Ring', '63,5x2,5 NBR80', 'ISO3601-1'),
	(1.4, 5.7, 'O-Ring', '5,7x1,4 NBR80', 'ISO3601-1'),
	(2.5, 17.5, 'O-Ring', '17,5x2,5 NBR80', 'ISO3601-1'),
	(1.9, 15.6, 'O-Ring', '15,6x1,9 NBR80', 'ISO3601-1'),	
	(3.5, 60, 'O-Ring', '60x3,5 NBR80', 'ISO3601-1');

	
	
	



	
