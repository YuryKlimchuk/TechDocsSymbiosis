DROP TABLE IF EXISTS specification_rows;
CREATE TABLE specification_rows (

	asm_id_full integer NOT NULL,
	id integer NOT NULL,
	counts integer NOT NULL,
	change integer NOT NULL,
	type varchar(50) NOT NULL,
	FOREIGN KEY (asm_id_full) REFERENCES assemblies (id),
	PRIMARY KEY (asm_id_full, id, type)

);


	
	