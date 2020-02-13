DROP TABLE IF EXISTS TBL_USUARIO;
  
CREATE TABLE TBL_USUARIO (
  idusuario INT AUTO_INCREMENT  PRIMARY KEY,
  nombre VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  creado TIMESTAMP NOT NULL,
  actualizado TIMESTAMP NOT NULL,
  lastlogin  TIMESTAMP NOT NULL,
  token VARCHAR,
  isactive BOOLEAN NOT NULL 
);