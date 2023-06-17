BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Usuario" (
	"id_usuario"	INTEGER,
	"cedula"	TEXT,
	"nombres"	TEXT,
	"apellidos"	TEXT,
	"genero"	TEXT,
	"edad"	INTEGER,
	"correo"	TEXT,
	"password"	TEXT,
	PRIMARY KEY("id_usuario" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "Candidato" (
	"id_candidato"	INTEGER,
	"nombre"	TEXT,
	"apellidos"	TEXT,
	"puesto"	TEXT,
	"partido_fk"	INTEGER,
	"foto_candidato"	TEXT,
	PRIMARY KEY("id_candidato" AUTOINCREMENT),
	FOREIGN KEY("partido_fk") REFERENCES "PPolitico"("id_politico")
);
CREATE TABLE IF NOT EXISTS "Papeleta" (
	"id_papeleta"	INTEGER,
	"nombre_papeleta"	TEXT,
	PRIMARY KEY("id_papeleta" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "Voto" (
	"id_voto"	INTEGER,
	"usuario_fk"	INTEGER,
	"papeleta_fk"	INTEGER,
	"partido_fk"	INTEGER,
	PRIMARY KEY("id_voto" AUTOINCREMENT),
	FOREIGN KEY("partido_fk") REFERENCES "PPolitico"("id_politico") ON DELETE CASCADE,
	FOREIGN KEY("papeleta_fk") REFERENCES "Papeleta"("id_papeleta") ON DELETE CASCADE,
	FOREIGN KEY("usuario_fk") REFERENCES "Usuario"("id_usuario") ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS "Comentario" (
	"id_comentario"	INTEGER,
	"Contenido"	TEXT,
	"usuario_fk"	INTEGER,
	PRIMARY KEY("id_comentario" AUTOINCREMENT),
	FOREIGN KEY("usuario_fk") REFERENCES "Usuario"("id_usuario") ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS "PPolitico" (
	"id_politico"	INTEGER,
	"nombre"	TEXT,
	"fundacion"	TEXT,
	"posicion"	TEXT,
	"sede"	TEXT,
	"pais"	TEXT,
	"ideologia"	TEXT,
	"foto_ppolitico"	TEXT,
	"region"	TEXT,
	"aceptacion"	TEXT,
	"planpdf"	BLOB,
	PRIMARY KEY("id_politico" AUTOINCREMENT)
);
INSERT INTO "Usuario" VALUES (1,'0987456123','Roberto','Quinto','Masculino',44,'R@gmail.com','12345');
INSERT INTO "Comentario" VALUES (1,'Me gusta',1);
INSERT INTO "PPolitico" VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'');
COMMIT;
