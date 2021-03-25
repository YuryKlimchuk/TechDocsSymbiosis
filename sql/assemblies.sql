/*
DROP TABLE IF EXISTS assembly_composition_opp;
CREATE TABLE assembly_composition_opp (

	asm_id_full integer NOT NULL,
	id integer NOT NULL,
	counts integer,
	change integer,
	FOREIGN KEY (id) REFERENCES our_product_parts (id),
	FOREIGN KEY (asm_id_full) REFERENCES assemblies (id)
	
);
*/


-- Заполнение таблицы assemblies
INSERT INTO assemblies(

	number,
	name,
	status,
	version,
	update

)

-- Занесение данных в таблицу
VALUES

	('RGR100-21000', 'Заглушка', 'NOTE', 'RG65-17', '04.04.2017'),
	('RGR100-26000', 'Заглушка', 'NOTE', 'RG65-17', '04.04.2017'),
	('RGR100-26000-01', 'Заглушка', 'NOTE', 'RG65-17', '04.04.2017'),
	('RGR100-27000', 'Заглушка', 'NOTE', 'RG51-17', '04.04.2017'),
	('RGR100-20000', 'Крышка сливная', 'DESIGN', '', ''),
	('RGR100-20000-01', 'Крышка сливная', 'DESIGN', '', ''),
	('RGR100-20000-02', 'Крышка сливная', 'DESIGN', '', ''),
	('RGR100-20000-03', 'Крышка сливная', 'DESIGN', '', ''),
	('RGR100-25000-12', 'Крышка нагнетательная', 'DESIGN', '', ''),

-- Заполнение таблицы assemblies
INSERT INTO assembly_composition_opp(

	asm_id_full,
	id,
	counts,
	change

)

-- Занесение данных в таблицу
VALUES

	--(1, 75, 1, -1),           --RGR100-21000
	--(2, 85, 1, -1),           --RGR100-26000
	--(3, 86, 1, -1);           --RGR100-26000-01
	--(4, 87, 1, -1);           --RGR100-27000
	(8, 71, 1, -1),           --RGR100-20000
	(9, 71, 1, -1),           --RGR100-20000-01
	(10, 72, 1, -1),           --RGR100-20000-02
	(11, 71, 1, -1),           --RGR100-20000-03
	(10, 73, 1, -1),           --RGR100-20000-02
	(10, 74, 1, -1);           --RGR100-20000-02
	
	
	
	
	
	
	
	
	
	
-- Заполнение таблицы assemblies
INSERT INTO assembly_composition_oring(

	asm_id_full,
	id,
	counts,
	change

)

-- Занесение данных в таблицу
VALUES

	--(1, 3, 1, -1);           --RGR100-21000
	--(2, 28, 1, -1),           --RGR100-26000
	--(3, 28, 1, -1);           --RGR100-26000-01
	--(4, 3, 1, -1);           --RGR100-27000
	
	
-- Заполнение таблицы assemblies
INSERT INTO assembly_composition_asm(

	asm_id_full,
	id,
	counts,
	change

)

-- Занесение данных в таблицу
VALUES

	(8, 1, 2, -1),           --RGR100-20000
	(9, 1, 2, -1),           --RGR100-20000-01
	(10, 1, 1, -1),           --RGR100-20000-02
	(11, 1, 2, -1);           --RGR100-20000-03
	
	


-- Заполнение таблицы assemblies
INSERT INTO assembly_composition_stp(

	asm_id_full,
	id,
	counts,
	change

)

-- Занесение данных в таблицу
VALUES

	(10, 8, 2, -1);           --RGR100-20000-02

	
	
-- Заполнение таблицы assemblies
INSERT INTO assembly_composition_vzk(

	asm_id_full,
	id,
	counts,
	change

)

-- Занесение данных в таблицу
VALUES

	(8, 15, 1, -1),           --RGR100-20000
	(8, 20, 1, -1),           --RGR100-20000
	(9, 16, 1, -1),           --RGR100-20000-01
	(9, 19, 1, -1),           --RGR100-20000-01
	(10, 15, 1, -1),           --RGR100-20000-02
	(10, 20, 2, -1),           --RGR100-20000-02
	(11, 15, 1, -1),           --RGR100-20000-03
	(11, 16, 1, -1);           --RGR100-20000-03
	
	
---------------------------------------
---------------------------------------
---------------------------------------

-- Крышка нагнетательная RGR100-28000
INSERT INTO assembly_composition_opp(

	asm_id_full,
	id,
	counts,
	change

)
VALUES

	(13, 88, 1, -1);           --RGR100-28000

-- Крышка нагнетательная RGR100-28000
INSERT INTO assembly_composition_oring(

	asm_id_full,
	id,
	counts,
	change

)
VALUES

	(13, 9, 1, -1),        
	(13, 2, 1, -1); 
	
	
---------------------------------------
---------------------------------------
---------------------------------------

-- Крышка нагнетательная RGR100-28000-01
INSERT INTO assembly_composition_opp(

	asm_id_full,
	id,
	counts,
	change

)
VALUES

	(13, 133, 1, -1);          

INSERT INTO assembly_composition_oring(

	asm_id_full,
	id,
	counts,
	change

)
VALUES

	(13, 9, 1, -1),        
	(13, 2, 1, -1); 
	
	
---------------------------------------
---------------------------------------
---------------------------------------

-- Крышка нагнетательная RGR100-25000-12
INSERT INTO assembly_composition_asm(

	asm_id_full,
	id,
	counts,
	change

)
VALUES

	(12, 13, 1, -1);          

INSERT INTO assembly_composition_opp(

	asm_id_full,
	id,
	counts,
	change

)
VALUES

	(12, 129, 1, -1), 
	(12, 131, 1, -1);

INSERT INTO assembly_composition_vzk(

	asm_id_full,
	id,
	counts,
	change

)
VALUES
	(12, 19, 1, -1),
	(12, 14, 1, -1), 
	(12, 14, 1, -1),
	(12, 3, 1, -1);
	
INSERT INTO assembly_composition_oring(

	asm_id_full,
	id,
	counts,
	change

)
VALUES

	(12, 1, 1, -1);