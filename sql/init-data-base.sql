


/*
	Таблица для хранения номенклатуры сборок.
*/
DROP TABLE IF EXISTS assemblies;
CREATE TABLE assemblies (

	id serial NOT NULL UNIQUE PRIMARY KEY,
	number varchar(30) NOT NULL UNIQUE,
	name varchar(30) NOT NULL,
	status varchar(30) NOT NULL,
	version varchar(30) NOT NULL,
	update varchar(30) NOT NULL

);
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
	Таблица для хранения деталей собственного производства.
*/
DROP TABLE IF EXISTS our_product_parts;
CREATE TABLE our_product_parts (

	id serial NOT NULL UNIQUE PRIMARY KEY,
	number varchar(50) NOT NULL UNIQUE,
	name varchar(50) NOT NULL,
	status varchar(50) NOT NULL,
	version varchar(50) NOT NULL,
	update varchar(50) NOT NULL

);
/*
	Таблица для хранения деталей в сборках
*/
ALTER TABLE assembly_composition_opp RENAME COLUMN opp_id TO id;  

DROP TABLE IF EXISTS assembly_composition_opp;
CREATE TABLE assembly_composition_opp (

	asm_id_full integer NOT NULL,
	opp_id integer NOT NULL,
	counts integer,
	change integer,
	FOREIGN KEY (opp_id) REFERENCES our_product_parts (id),
	FOREIGN KEY (asm_id_full) REFERENCES assemblies (id)
	
);
/*
	Таблица для хранения деталей в сборках
*/
DROP TABLE IF EXISTS assembly_composition_oring;
CREATE TABLE assembly_composition_oring (

	asm_id_full integer NOT NULL,
	oring_id integer NOT NULL,
	counts integer,
	change integer,
	FOREIGN KEY (oring_id) REFERENCES orings (id),
	FOREIGN KEY (asm_id_full) REFERENCES assemblies (id)
	
);























/*
	Таблица для хранения номенклатуры стандартных изделий
*/

-- Создание таблицы
DROP TABLE IF EXISTS standart_parts;
CREATE TABLE standart_parts (

	id serial NOT NULL UNIQUE PRIMARY KEY,
	number varchar(30) NOT NULL UNIQUE,
	name varchar(30) NOT NULL,
	standart varchar(30) NOT NULL
);



/*
	Таблица для хранения номенклатуры сборок.
*/

-- Создание таблцы
DROP TABLE IF EXISTS assemblies;
CREATE TABLE assemblies (

	id serial NOT NULL UNIQUE PRIMARY KEY,
	number varchar(30) NOT NULL UNIQUE,
	name varchar(30) NOT NULL,
	status varchar(30) NOT NULL,
	version varchar(30) NOT NULL,
	update varchar(30) NOT NULL

);


DROP TABLE IF EXISTS our_product_parts;
DROP TABLE IF EXISTS orings;
DROP TABLE IF EXISTS buy;
DROP TABLE IF EXISTS assemblies;
DROP TABLE IF EXISTS standart_parts;
DROP TABLE IF EXISTS assembly_composition_vzk;
DROP TABLE IF EXISTS assembly_composition_opp;
DROP TABLE IF EXISTS assembly_composition_oring;
DROP TABLE IF EXISTS assembly_composition_buy;
DROP TABLE IF EXISTS assembly_composition_asm;
DROP TABLE IF EXISTS assembly_composition_stp;


select 'drop table if exists "' || tablename || '" cascade;' 
  from pg_tables
 where schemaname = 'public'; -- or any other schema


/*
	Таблица для хранения покупных изделий
*/

-- Создание таблцы
DROP TABLE IF EXISTS buy;
CREATE TABLE buy (

	id serial NOT NULL UNIQUE PRIMARY KEY,
	number varchar(30) NOT NULL UNIQUE,
	name varchar(30) NOT NULL,
	manufacturer varchar(30) NOT NULL
);







/*
	Таблица для хранения деталей в сборках
*/
-- Создание таблицы
DROP TABLE IF EXISTS assembly_composition_opp;
CREATE TABLE assembly_composition_opp (

	asm_id_full integer NOT NULL,
	opp_id integer NOT NULL,
	counts integer,
	change integer,
	FOREIGN KEY (opp_id) REFERENCES our_product_parts (id),
	FOREIGN KEY (asm_id_full) REFERENCES assemblies (id)
	
);

/*
	Таблица для хранения деталей в сборках
*/
-- Создание таблицы
DROP TABLE IF EXISTS assembly_composition_oring;
CREATE TABLE assembly_composition_oring (

	asm_id_full integer NOT NULL,
	oring_id integer NOT NULL,
	counts integer,
	change integer,
	FOREIGN KEY (oring_id) REFERENCES orings (id),
	FOREIGN KEY (asm_id_full) REFERENCES assemblies (id)
	
);


/*
	Таблица для хранения деталей в сборках
*/
-- Создание таблицы
DROP TABLE IF EXISTS assembly_composition_buy;
CREATE TABLE assembly_composition_buy (

	asm_id_full integer NOT NULL,
	buy_id integer NOT NULL,
	counts integer,
	change integer,
	FOREIGN KEY (buy_id) REFERENCES buy (id),
	FOREIGN KEY (asm_id_full) REFERENCES assemblies (id)
	
);


/*
	Таблица для хранения сборок в сборках
*/
-- Создание таблицы
DROP TABLE IF EXISTS assembly_composition_asm;
CREATE TABLE assembly_composition_asm (

	asm_id_full integer NOT NULL,
	asm_id integer NOT NULL,
	counts integer,
	change integer,
	FOREIGN KEY (asm_id) REFERENCES assemblies (id),
	FOREIGN KEY (asm_id_full) REFERENCES assemblies (id)
	
);


/*
	Таблица для хранения стандартных в сборках
*/
-- Создание таблицы
DROP TABLE IF EXISTS assembly_composition_stp;
CREATE TABLE assembly_composition_stp (

	asm_id_full integer NOT NULL,
	stp_id integer NOT NULL,
	counts integer,
	change integer,
	FOREIGN KEY (stp_id) REFERENCES standart_parts (id),
	FOREIGN KEY (asm_id_full) REFERENCES assemblies (id)
	
);

-- Создание таблицы
DROP TABLE IF EXISTS assembly_composition_vzk;
CREATE TABLE assembly_composition_vzk (

	asm_id_full integer NOT NULL,
	vzk_id integer NOT NULL,
	counts integer,
	change integer,
	FOREIGN KEY (vzk_id) REFERENCES vzk (id),
	FOREIGN KEY (asm_id_full) REFERENCES assemblies (id)
	
);



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
	Таблица для хранения деталей собственного производства.
*/

-- Создание таблцы
DROP TABLE IF EXISTS our_product_parts;
CREATE TABLE our_product_parts (

	id serial NOT NULL UNIQUE PRIMARY KEY,
	number varchar(50) NOT NULL UNIQUE,
	name varchar(50) NOT NULL,
	status varchar(50) NOT NULL,
	version varchar(50) NOT NULL,
	update varchar(50) NOT NULL

);

-- Создание таблцы
DROP TABLE IF EXISTS our_product_parts_deleted;
CREATE TABLE our_product_parts_deleted (

	id integer,
	number varchar(50) NOT NULL,
	name varchar(50) NOT NULL,
	status varchar(50) NOT NULL,
	version varchar(50) NOT NULL,
	update varchar(50) NOT NULL

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







-- Заполнение таблицы buy
INSERT INTO buy (

	number,
	name,
	manufacturer

)

-- Занесение данных в таблицу
VALUES

	('Тросс-VB', 'Тросс', 'Технопривод'),
	('IP-DAR-250-AJ-12-32-AH', 'Клапан электромагнитный', 'Tecnord'),
	('IP-DAR-250-AJ-24-32-AH', 'Клапан электромагнитный', 'Tecnord'),
	('ICS-250-AJ-12-32-AH', 'Клапан электромагнитный', 'Tecnord');



-- Заполнение таблицы our_product_parts
INSERT INTO our_product_parts (

	number,
	name,
	status,
	version,
	update

)

-- Занесение данных в таблицу
VALUES

	('RGR100-10001',    'Стакан', 'NOTE', 'RG51-17', '04.04.2017'),
	('RGR100-10003',    'Толкатель', 'NOTE', 'RG81-19', '12.02.2019'),
	('RGR100-10004',    'Пыльник', 'NOTE', 'RG51-17', '04.04.2017'),
	('RGR100-11001',    'Корпус секции', 'NOTE', 'RG51-17', '04.04.2017'),
	('RGR100-11001-01', 'Корпус секции', 'NOTE', 'RG51-17', '04.04.2017'),
	('RGR100-11001-02', 'Корпус секции', 'NOTE', 'RG51-17', '04.04.2017'),
	('RGR100-11001-03', 'Корпус секции', 'NOTE', 'RG51-17', '04.04.2017'),
	('RGR100-11001-04', 'Корпус секции', 'NOTE', 'RG63-17', '31.10.2017'),
	('RGR100-11001-06', 'Корпус секции', 'NOTE', 'RG67-18', '27.02.2018'),
	('RGR100-11001-07', 'Корпус секции', 'NOTE', 'RG67-18', '27.02.2018'),
	--('RGR100-11001-11', 'Корпус секции', 'NOTE', 'RG94-21', '20.01.2021'),
	('RGR100-11002',    'Золотник', 'NOTE', 'RG93-20', '06.10.2020'),
	('RGR100-11002-01', 'Золотник', 'NOTE', 'RG93-20', '06.10.2020'),
	('RGR100-11003', 'Клапан обратный', 'NOTE', 'RG51-17', '04.04.2017'),
	('RGR100-11004', 'Пробка', 'NOTE', 'RG51-17', '04.04.2017'),
	('RGR100-11005', 'Пружина', 'NOTE', 'RG51-17', '04.04.2017'),
	('RGR100-11006', 'Стакан', 'NOTE', 'RG51-17', '04.04.2017'),
	('RGR100-11007', 'Шайба', 'NOTE', 'RG51-17', '04.04.2017'),
	('RGR100-11008', 'Насадка', 'NOTE', 'RG51-17', '04.04.2017'),
	('RGR100-11009', 'Пружина', 'NOTE', 'RG51-17', '04.04.2017'),
	('RGR100-11009-01', 'Пружина', 'NOTE', 'RG94-21', '20.01.2021'),
	--('RGR100-11501', 'Золотник', 'NOTE', 'RG94-21', '20.01.2021'),
	--('RGR100-11502', 'Шайба', 'NOTE', 'RG94-21', '20.01.2021'),
	('RGR100-15004', 'Плита', 'NOTE', 'RG51-17', '04.04.2017'),
	('RGR100-15005', 'Кронштейн', 'NOTE', 'RG51-17', '04.04.2017'),
	('RGR100-15006', 'Кронштейн', 'NOTE', 'RG51-17', '04.04.2017'),
	('RGR100-15007', 'Опора', 'NOTE', 'RG51-17', '04.04.2017'),
	('RGR100-15008', 'Ось', 'NOTE', 'RG81-19', '12.02.2019'),
	('RGR100-15010', 'Ось', 'NOTE', 'RG81-19', '12.02.2019'),
	('RGR100-15011', 'Пыльник', 'NOTE', 'RG51-17', '04.04.2017'),
	--('RGR100-16001', 'Заглушка', 'NOTE', 'RG71-18', '31.07.2018'),
	('RGR100-20001', 'Крышка сливная', 'NOTE', 'RG94-21', '20.01.2021'),
	('RGR100-20001-01', 'Крышка сливная', 'NOTE', 'RG94-21', '20.01.2021'),
	('RGR100-20002', 'Банджо', 'NOTE', 'RG94-21', '20.01.2021'),
	('RGR100-20003', 'Болт', 'NOTE', 'RG94-21', '20.01.2021'),
	--('RGR100-21001', 'Заглушка', 'NOTE', 'RG51-17', '04.04.2017'),
	('RGR100-25001', 'Крышка нагнетательная', 'NOTE', 'RG94-21', '20.01.2021'),
	('RGR100-25001-01', 'Крышка нагнетательная', 'NOTE', 'RG94-21', '20.01.2021'),
	('RGR100-25001-02', 'Крышка нагнетательная', 'NOTE', 'RG94-21', '20.01.2021'),
	('RGR100-25001-03', 'Крышка нагнетательная', 'NOTE', 'RG94-21', '20.01.2021'),
	('RGR100-25001-04', 'Крышка нагнетательная', 'NOTE', 'RG94-21', '20.01.2021'),
	('RGR100-25001-05', 'Крышка нагнетательная', 'NOTE', 'RG94-21', '20.01.2021'),
	('RGR100-25001-06', 'Крышка нагнетательная', 'NOTE', 'RG94-21', '20.01.2021'),
	('RGR100-25001-07', 'Крышка нагнетательная', 'NOTE', 'RG94-21', '20.01.2021'),
	('RGR100-25001-08', 'Крышка нагнетательная', 'NOTE', 'RG94-21', '20.01.2021'),
	('RGR100-26001', 'Заглушка', 'NOTE', 'RG65-17', '28.05.2017'),
	('RGR100-26001-01', 'Заглушка', 'NOTE', 'RG65-17', '28.05.2017'),
	('RGR100-27001', 'Заглушка', 'NOTE', 'RG51-17', '04.04.2017'),
	('RGR100-28001', 'Заглушка', 'NOTE', 'RG76-18', '19.10.2018'),
	('RGR100-30002', 'Стакан', 'NOTE', 'RG27-15', '16.09.2015'),
	('RGR100-30003',    'Обойма', 'NOTE', 'RG77-18', '15.10.2018'),
	('RGR100-30003-01', 'Обойма', 'NOTE', 'RG77-18', '15.10.2018'),
	('RGR100-30003-02', 'Обойма', 'NOTE', 'RG77-18', '15.10.2018'),
	('RGR100-30003-03', 'Обойма', 'NOTE', 'RG77-18', '15.10.2018'),
	('RGR100-30003-04', 'Обойма', 'NOTE', 'RG77-18', '15.10.2018'),
	('RGR100-30003-05', 'Обойма', 'NOTE', 'RG77-18', '15.10.2018'),
	('RGR100-30003-09', 'Обойма', 'NOTE', 'RG94-21', '20.01.2021'),
	('RGR100-30004', 'Хвостовик', 'NOTE', 'RG75-18', '06.05.2018'),
	('RGR100-30004-01', 'Хвостовик', 'NOTE', 'RG75-18', '06.05.2018'),
	('RGR100-30005',    'Насадка', 'NOTE', 'RG94-21', '20.01.2021'),
	('RGR100-30005-01', 'Насадка',  'NOTE', 'RG94-21', '20.01.2021'),
	('RGR100-30005-02', 'Насадка', 'NOTE', 'RG94-21', '20.01.2021'),
	('RGR100-30006', 'Винт','NOTE', 'RG75-18', '06.05.2018'),
	('RGR100-30007', 'Фиксатор','NOTE', 'RG75-18', '06.05.2018'),
	('RGR100-30007-01', 'Фиксатор','NOTE', 'RG75-18', '06.05.2018'),
	('RGR100-30008', 'Пружина', 'NOTE', 'RG75-18', '06.05.2018'),
	('RGR100-30008-01', 'Пружина','NOTE', 'RG94-21', '20.01.2021'),
	('RGR100-30009', 'Пружина','NOTE', 'RG75-18', '06.05.2018'),
	('RGR100-30010', 'Упор', 'NOTE', 'RG75-18', '06.05.2018'),
	('RGR100-30011', 'Клапан', 'NOTE', 'RG75-18', '06.05.2018'),
	('RGR100-30012', 'Пробка', 'NOTE', 'RG75-18', '06.05.2018'),
	('RGR100-30013', 'Пластина', 'NOTE', 'RG75-18', '06.05.2018'),
	('RGR100-30014', 'Хвостовик', 'NOTE', 'RG75-18', '06.05.2018'),
	('RGR100-30015', 'Заглушка', 'NOTE', 'RG75-18', '06.05.2018');





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

	--(1.9, 14.6, 'O-Ring', '14,6x1,9 NBR80', 'ISO3601-1'),
	--(1.9, 20.5, 'O-Ring', '20,5x1,9 NBR80', 'ISO3601-1'),
	--(1.9, 18.5, 'O-Ring', '18,5x1,9 NBR80', 'ISO3601-1'),
	(1.9, 4.7, 'O-Ring', '4,7x1,9 NBR80', 'ISO3601-1'),
	(1.9, 8.7, 'O-Ring', '8,7x1,9 NBR80', 'ISO3601-1'),
	(1.9, 7.7, 'O-Ring', '7,7x1,9 NBR80', 'ISO3601-1'),
	(1.9, 9.7, 'O-Ring', '9,7x1,9 NBR80', 'ISO3601-1'),
	(1.9, 10.6, 'O-Ring', '10,6x1,9 NBR80', 'ISO3601-1'),
	--(1.9, 16.6, 'O-Ring', '16,6x1,9 NBR80', 'ISO3601-1'),
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
	--(1.9, 15.6, 'O-Ring', '15,6x1,9 NBR80', 'ISO3601-1'),	
	(3.5, 60, 'O-Ring', '60x3,5 NBR80', 'ISO3601-1');

	
	
	
-- Заполнение таблицы standart_parts
INSERT INTO standart_parts (

	number,
	name,
	standart
	
)

-- Занесение данных в таблицу
VALUES

	('M5x12', 'Винт', 'ISO4762'),
	('M5x14', 'Винт', 'ISO4762'),
	('M5x25', 'Винт', 'ISO4762'),
	('M6x14', 'Винт', 'ISO4762'),
	('M6x30', 'Винт', 'ISO4762');









-- Создание таблцы для хранение ВЗК
DROP TABLE IF EXISTS vzk;
CREATE TABLE vzk (

	id serial NOT NULL UNIQUE PRIMARY KEY,
	number varchar(50) NOT NULL UNIQUE,
	name varchar(50)
	
);

-- Заполнение таблицы
INSERT INTO vzk (

	number,
	name
	
)

VALUES

	('KEM.24.00', 'Клапан электромагнитный'),
	('KEM.24.10', 'Клапан электромагнитный'),
	('KKD.100.10.000', 'Клапан комбинированный'),
	('KKD.100.30.100', 'Клапан комбинированный'),
	('KKD.100.30.150', 'Клапан комбинированный'),
	('KKD.100.30.180', 'Клапан комбинированный'),
	('KKD.100.30.220', 'Клапан комбинированный'),
	('KKD.100.30.280', 'Клапан комбинированный'),
	('KPV.100.30.000', 'Клапан антикавитационный'),
	('PGA.70.10', 'Пневмогидроаккумулятор'),
	('RMW.G14.00', 'Шайба резинометаллическая'),
	('ZMT.G14.00', 'Заглушка металлическая'),
	('ZMT.G12.00', 'Заглушка металлическая'),
	('ZMT.G34.00', 'Заглушка металлическая'),
	('ZMT.M10.00', 'Заглушка металлическая'),
	('ZPT.G14.00', 'Заглушка пластиковая'),
	('ZPT.G12.00', 'Заглушка пластиковая'),
	('ZPT.G34.00', 'Заглушка пластиковая');

