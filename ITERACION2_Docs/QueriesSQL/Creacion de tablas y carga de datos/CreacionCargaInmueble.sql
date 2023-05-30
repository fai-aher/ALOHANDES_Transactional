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
VALUES (1, 1, 'Premium', 3, 'Calle 92 número 46', 'Ropa de cama y toallas incluidas', 25);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (2, 2, 'Básico', 2, 'Avenida 54 número 75', 'Mobiliario moderno y confortable', 22);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (3, 3, 'Económico', 2, 'Carrera 62 número 21', 'Cubertería y vajilla completa', 29);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (4, 4, 'Ejecutivo', 3, 'Calle 80 número 33', 'Cafetera y tetera disponibles', 40);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (5, 5, 'Doble', 3, 'Avenida 68 número 14', 'Mesa y sillas para comedor', 29);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (6, 6, 'Premium', 1, 'Carrera 79 número 66', 'Cortinas opacas para privacidad', 44);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (7, 7, 'Básico', 1, 'Calle 51 número 98', 'Set de baño incluido', 57);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (8, 8, 'Económico', 3, 'Avenida 63 número 72', 'Espejo de cuerpo entero disponible', 52);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (9, 9, 'Ejecutivo', 3, 'Carrera 58 número 27', 'Vajilla y utensilios para niños', 27);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (10, 10, ' Doble', 2, ' Calle 84 número 52', ' Mantas y almohadas adicionales', 53);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (11, 11, ' Premium', 2, ' Avenida 57 número 89', ' Mesa auxiliar y lámpara de lectura', 57);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (12, 12, ' Básico', 2, ' Carrera 75 número 11', ' Elementos de decoración temáticos', 42);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (13, 13, ' Económico', 1, ' Calle 97 número 48', ' Plancha y tabla de planchar disponibles', 53);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (14, 14, ' Ejecutivo', 2, ' Avenida 61 número 35', ' Armario amplio con perchas', 49);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (15, 15, ' Doble', 1, ' Carrera 71 número 23', ' Cubiertos y utensilios de servir', 46);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (16, 16, ' Premium', 3, ' Calle 69 número 76', ' Televisor de pantalla plana disponible', 42);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (17, 17, ' Básico', 1, ' Avenida 87 número 18', ' Cojines decorativos y mantelería', 50);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (18, 18, ' Económico', 4, ' Carrera 64 número 55', ' Estantería y libros disponibles', 32);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (19, 19, ' Ejecutivo', 1, ' Calle 78 número 90', ' Escritorio y silla para trabajar', 30);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (20, 20, ' Doble', 2, ' Avenida 53 número 43', ' Microondas y nevera disponibles', 60);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (21, 21, ' Premium', 1, ' Carrera 70 número 31', ' Almohadas y cojines ergonómicos', 40);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (22, 22, ' Básico', 3, ' Calle 88 número 67', ' Cesto de la ropa sucia disponible', 41);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (23, 23, ' Económico', 3, ' Avenida 65 número 28', ' Elementos de iluminación suave y relajante', 31);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (24, 24, ' Ejecutivo', 2, ' Carrera 82 número 44', ' Taburete y mesita de noche', 30);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (25, 25, ' Doble', 3, ' Calle 59 número 82', ' Batidora y otros electrodomésticos disponibles', 53);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (26, 26, ' Premium', 3, ' Avenida 73 número 51', ' Juegos de mesa y baraja de cartas', 48);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (27, 27, ' Básico', 4, ' Carrera 56 número 39', ' Toallas de playa y sombrilla disponibles', 27);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (28, 28, ' Económico', 2, ' Calle 77 número 17', ' Utensilios de barbacoa y parrilla', 59);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (29, 29, ' Ejecutivo', 4, ' Avenida 66 número 96', ' Espejo de maquillaje y secador de pelo', 27);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (30, 30, ' Doble', 2, ' Carrera 63 número 58', ' Alfombra y cortinas a juego', 29);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (31, 31, ' Premium', 2, ' Calle 81 número 25', ' Caja fuerte para objetos de valor', 21);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (32, 32, ' Básico', 2, ' Avenida 55 número 68', ' Jarras y dispensadores de agua disponibles', 44);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (33, 33, ' Económico', 4, ' Carrera 72 número 73', ' Accesorios de cocina para repostería', 29);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (34, 34, ' Ejecutivo', 2, ' Calle 67 número 91', ' Soporte para dispositivos móviles', 34);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (35, 35, ' Doble', 3, ' Avenida 52 número 22', ' Mueble de almacenamiento adicional', 54);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (36, 36, ' Premium', 4, ' Carrera 76 número 57', ' Plancha de cocina y sartenes disponibles', 38);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (37, 37, ' Básico', 3, ' Calle 93 número 30', ' Mesa y sillas para exterior', 55);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (38, 38, ' Económico', 3, ' Avenida 69 número 10', ' Cojines y mantas para exteriores', 48);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (39, 39, ' Ejecutivo', 4, ' Carrera 60 número 84', ' Candelabros y velas disponibles', 53);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (40, 40, ' Doble', 3, ' Calle 85 número 42', ' Tostadora y hervidor de agua disponibles', 53);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (41, 41, ' Premium', 2, ' Avenida 58 número 81', ' Mesita de centro y sofá confortable', 48);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (42, 42, ' Básico', 2, ' Carrera 83 número 20', ' Colchas y cojines a juego', 23);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (43, 43, ' Económico', 4, ' Calle 71 número 75', ' Escalera para acceder a elementos altos', 20);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (44, 44, ' Ejecutivo', 2, ' Avenida 64 número 49', ' Iluminación inteligente y regulable', 33);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (45, 45, ' Doble', 2, ' Carrera 57 número 38', ' Accesorios de fitness y yoga', 59);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (46, 46, ' Premium', 1, ' Calle 96 número 16', ' Organizadores de ropa y calzado', 37);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (47, 47, ' Básico', 4, ' Avenida 67 número 65', ' Juegos de cama y cojines a juego', 40);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (48, 48, ' Económico', 2, ' Carrera 74 número 29', ' Máquina de café y suministros incluidos', 43);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (49, 49, ' Ejecutivo', 1, ' Calle 60 número 88', ' Cestas de almacenamiento adicionales', 58);

INSERT INTO Inmueble (IDINMUEBLE, OPERADORASOCIADO, CATEGORIA, CAPACIDAD, UBICACION, MENAJE, TAMANOENMTSQ) 
VALUES (50, 50, ' Doble', 3, ' Avenida 56 número 27', ' Toallero y perchero disponibles', 37);

