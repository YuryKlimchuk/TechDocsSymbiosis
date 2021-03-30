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

	--('RGR100-21000', 'Заглушка', 'NOTE', 'RG65-17', '04.04.2017'),
	--('RGR100-26000', 'Заглушка', 'NOTE', 'RG65-17', '04.04.2017'),
	--('RGR100-26000-01', 'Заглушка', 'NOTE', 'RG65-17', '04.04.2017');
	('RGR100-27000', 'Заглушка', 'NOTE', 'RG51-17', '04.04.2017');

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
	(2, 85, 1, -1),           --RGR100-26000
	(3, 86, 1, -1);           --RGR100-26000-01
	
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
	(2, 28, 1, -1),           --RGR100-26000
	(3, 28, 1, -1);           --RGR100-26000-01
