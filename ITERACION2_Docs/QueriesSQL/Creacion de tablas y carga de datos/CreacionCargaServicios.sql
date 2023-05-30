SET DEFINE OFF

CREATE TABLE Servicios ( IDSERVICIO NUMBER(38) primary key,
NOMBRE VARCHAR2(128) NOT NULL,
DESCRIPCION VARCHAR2(256) NOT NULL,
HORAAPERTURA NUMBER(38) NOT NULL,
HORACIERRE NUMBER(38) NOT NULL,
COSTOADICIONAL NUMBER(38) NOT NULL);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (1, 'Servicio de limpieza diario', 'Personal que se encarga de mantener la habitación limpia y ordenada todos los días.', 9, 19, 178991);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (2, 'Jacuzzi', 'Un jacuzzi con agua caliente y burbujas para disfrutar de un momento de relax.', 4, 15, 64105);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (3, 'Piscina', 'Piscina semiolímpica privada para refrescarse y nadar en un ambiente tranquilo y exclusivo.', 3, 17, 53918);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (4, 'Masajes', 'Servicio de masajes a cargo de profesionales que garantizan una experiencia única y relajante.', 7, 13, 118787);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (5, 'Transporte', 'Servicio de transporte desde y hacia el aeropuerto o estación de tren más cercana.', 0, 16, 56122);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (6, 'Desayuno incluido', 'Desayuno completo incluido en el precio de la habitación.', 9, 14, 115725);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (7, 'Gimnasio', 'Sala de gimnasio completamente equipada con máquinas de última generación.', 6, 18, 129682);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (8, 'Sala de reuniones', 'Sala de reuniones con capacidad para varias personas y equipada con tecnología de última generación.', 7, 14, 54634);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (9, 'Servicio de lavandería', 'Servicio de lavandería para que los huéspedes puedan tener su ropa limpia y planchada en todo momento.', 11, 16, 141541);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (10, ' Restaurante', 'Restaurante propio que ofrece una amplia variedad de platos y bebidas.', 10, 1, 147701);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (11, ' Wi-Fi gratis', 'Conexión a Internet de alta velocidad disponible en todas las áreas del hotel de forma gratuita.', 8, 1, 187297);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (12, ' Servicio de habitaciones', 'Servicio de habitaciones disponible las 24 horas del día para satisfacer todas las necesidades de los huéspedes.', 2, 1, 184910);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (13, ' Minibar', 'Minibar en la habitación con una selección de bebidas y aperitivos.', 8, 1, 179068);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (14, ' Aparcamiento privado', 'Aparcamiento privado para los huéspedes que viajan en coche.', 5, 1, 167043);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (15, ' Servicio de guardaequipaje', 'Servicio de guardaequipaje para los huéspedes que llegan temprano o salen tarde.', 4, 1, 152690);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (16, ' Recepción 24 horas', 'Recepción abierta las 24 horas del día para atender cualquier solicitud o necesidad de los huéspedes.', 2, 1, 150375);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (17, ' Servicio de despertador', 'Servicio de despertador para asegurarse de que los huéspedes no lleguen tarde a sus compromisos.', 6, 1, 139189);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (18, ' Centro de negocios', 'Centro de negocios con acceso a Internet, impresoras, escáneres y otras herramientas esenciales para los viajeros de negocios.', 1, 1, 184595);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (19, ' Sauna', 'Sauna para disfrutar de un momento de relajación y bienestar.', 3, 1, 153543);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (20, ' Salón de belleza', 'Salón de belleza donde los huéspedes pueden disfrutar de una gran variedad de tratamientos de belleza.', 0, 1, 98885);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (21, ' Zona de juegos infantiles', 'Zona de juegos para los más pequeños de la casa.', 10, 1, 192983);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (22, ' Servicio de alquiler de bicicletas', 'Servicio de alquiler de bicicletas para explorar los alrededores del hotel.', 7, 1, 113135);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (23, ' Servicio de conserjería', 'Servicio de conserjería para ayudar a los huéspedes con cualquier solicitud o necesidad.', 8, 1, 130018);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (24, ' Peluquería', 'Peluquería para mantener el cabello arreglado durante la estancia.', 5, 1, 108072);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (25, ' Tienda de souvenirs', 'Tienda de souvenirs para llevarse un recuerdo del lugar.', 0, 1, 122332);

INSERT INTO Servicios (IDSERVICIO, NOMBRE, DESCRIPCION, HORAAPERTURA, HORACIERRE, COSTOADICIONAL) 
VALUES (26, ' Caja fuerte en la habitación', 'Caja fuerte en la habitación para guardar', 11, 1, 194594);

