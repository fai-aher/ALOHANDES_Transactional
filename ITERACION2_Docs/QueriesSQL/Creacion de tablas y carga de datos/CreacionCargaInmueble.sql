SET DEFINE OFF
--fgdfsgfgsgfgdssfgfsg
CREATE TABLE Inmueble ( IDINMUEBLE NUMBER(38) primary key,
OPERADORASOCIADO NUMBER(38) not null,
CATEGORIA VARCHAR2(128),
CAPACIDAD NUMBER(38),
UBICACION VARCHAR2(128) not null,
MENAJE VARCHAR2(256),
TAMANOENMTSQ NUMBER(38),
constraint FKInmuebleOperador foreign key (OPERADORASOCIADO) references operador(idoperador));

--drop table Inmueble;

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (1, 1, 'Premium', 3, 'Calle 92 n�mero 46', 'Ropa de cama y toallas incluidas', 25);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (2, 2, 'B�sico', 2, 'Avenida 54 n�mero 75', 'Mobiliario moderno y confortable', 22);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (3, 3, 'Econ�mico', 2, 'Carrera 62 n�mero 21', 'Cuberter�a y vajilla completa', 29);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (4, 4, 'Ejecutivo', 3, 'Calle 80 n�mero 33', 'Cafetera y tetera disponibles', 40);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (5, 5, 'Doble', 3, 'Avenida 68 n�mero 14', 'Mesa y sillas para comedor', 29);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (6, 6, 'Premium', 1, 'Carrera 79 n�mero 66', 'Cortinas opacas para privacidad', 44);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (7, 7, 'B�sico', 1, 'Calle 51 n�mero 98', 'Set de ba�o incluido', 57);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (8, 8, 'Econ�mico', 3, 'Avenida 63 n�mero 72', 'Espejo de cuerpo entero disponible', 52);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (9, 9, 'Ejecutivo', 3, 'Carrera 58 n�mero 27', 'Vajilla y utensilios para ni�os', 27);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (10, 10, ' Doble', 2, ' Calle 84 n�mero 52', ' Mantas y almohadas adicionales', 53);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (11, 11, ' Premium', 2, ' Avenida 57 n�mero 89', ' Mesa auxiliar y l�mpara de lectura', 57);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (12, 12, ' B�sico', 2, ' Carrera 75 n�mero 11', ' Elementos de decoraci�n tem�ticos', 42);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (13, 13, ' Econ�mico', 1, ' Calle 97 n�mero 48', ' Plancha y tabla de planchar disponibles', 53);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (14, 14, ' Ejecutivo', 2, ' Avenida 61 n�mero 35', ' Armario amplio con perchas', 49);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (15, 15, ' Doble', 1, ' Carrera 71 n�mero 23', ' Cubiertos y utensilios de servir', 46);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (16, 16, ' Premium', 3, ' Calle 69 n�mero 76', ' Televisor de pantalla plana disponible', 42);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (17, 17, ' B�sico', 1, ' Avenida 87 n�mero 18', ' Cojines decorativos y manteler�a', 50);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (18, 18, ' Econ�mico', 4, ' Carrera 64 n�mero 55', ' Estanter�a y libros disponibles', 32);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (19, 19, ' Ejecutivo', 1, ' Calle 78 n�mero 90', ' Escritorio y silla para trabajar', 30);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (20, 20, ' Doble', 2, ' Avenida 53 n�mero 43', ' Microondas y nevera disponibles', 60);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (21, 21, ' Premium', 1, ' Carrera 70 n�mero 31', ' Almohadas y cojines ergon�micos', 40);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (22, 22, ' B�sico', 3, ' Calle 88 n�mero 67', ' Cesto de la ropa sucia disponible', 41);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (23, 23, ' Econ�mico', 3, ' Avenida 65 n�mero 28', ' Elementos de iluminaci�n suave y relajante', 31);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (24, 24, ' Ejecutivo', 2, ' Carrera 82 n�mero 44', ' Taburete y mesita de noche', 30);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (25, 25, ' Doble', 3, ' Calle 59 n�mero 82', ' Batidora y otros electrodom�sticos disponibles', 53);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (26, 26, ' Premium', 3, ' Avenida 73 n�mero 51', ' Juegos de mesa y baraja de cartas', 48);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (27, 27, ' B�sico', 4, ' Carrera 56 n�mero 39', ' Toallas de playa y sombrilla disponibles', 27);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (28, 28, ' Econ�mico', 2, ' Calle 77 n�mero 17', ' Utensilios de barbacoa y parrilla', 59);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (29, 29, ' Ejecutivo', 4, ' Avenida 66 n�mero 96', ' Espejo de maquillaje y secador de pelo', 27);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (30, 30, ' Doble', 2, ' Carrera 63 n�mero 58', ' Alfombra y cortinas a juego', 29);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (31, 31, ' Premium', 2, ' Calle 81 n�mero 25', ' Caja fuerte para objetos de valor', 21);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (32, 32, ' B�sico', 2, ' Avenida 55 n�mero 68', ' Jarras y dispensadores de agua disponibles', 44);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (33, 33, ' Econ�mico', 4, ' Carrera 72 n�mero 73', ' Accesorios de cocina para reposter�a', 29);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (34, 34, ' Ejecutivo', 2, ' Calle 67 n�mero 91', ' Soporte para dispositivos m�viles', 34);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (35, 35, ' Doble', 3, ' Avenida 52 n�mero 22', ' Mueble de almacenamiento adicional', 54);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (36, 36, ' Premium', 4, ' Carrera 76 n�mero 57', ' Plancha de cocina y sartenes disponibles', 38);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (37, 37, ' B�sico', 3, ' Calle 93 n�mero 30', ' Mesa y sillas para exterior', 55);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (38, 38, ' Econ�mico', 3, ' Avenida 69 n�mero 10', ' Cojines y mantas para exteriores', 48);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (39, 39, ' Ejecutivo', 4, ' Carrera 60 n�mero 84', ' Candelabros y velas disponibles', 53);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (40, 40, ' Doble', 3, ' Calle 85 n�mero 42', ' Tostadora y hervidor de agua disponibles', 53);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (41, 41, ' Premium', 2, ' Avenida 58 n�mero 81', ' Mesita de centro y sof� confortable', 48);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (42, 42, ' B�sico', 2, ' Carrera 83 n�mero 20', ' Colchas y cojines a juego', 23);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (43, 43, ' Econ�mico', 4, ' Calle 71 n�mero 75', ' Escalera para acceder a elementos altos', 20);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (44, 44, ' Ejecutivo', 2, ' Avenida 64 n�mero 49', ' Iluminaci�n inteligente y regulable', 33);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (45, 45, ' Doble', 2, ' Carrera 57 n�mero 38', ' Accesorios de fitness y yoga', 59);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (46, 46, ' Premium', 1, ' Calle 96 n�mero 16', ' Organizadores de ropa y calzado', 37);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (47, 47, ' B�sico', 4, ' Avenida 67 n�mero 65', ' Juegos de cama y cojines a juego', 40);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (48, 48, ' Econ�mico', 2, ' Carrera 74 n�mero 29', ' M�quina de caf� y suministros incluidos', 43);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (49, 49, ' Ejecutivo', 1, ' Calle 60 n�mero 88', ' Cestas de almacenamiento adicionales', 58);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (50, 50, ' Doble', 3, ' Avenida 56 n�mero 27', ' Toallero y perchero disponibles', 37);

