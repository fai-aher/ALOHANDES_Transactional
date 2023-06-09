SET DEFINE OFF
--sdfgsdfgsdfgsdfhsejhsedfgsd
CREATE TABLE OfertaAlojamiento ( IDOFERTA NUMBER(38) primary key,
PRECIOBASE NUMBER(38, 10) NOT NULL,
INMUEBLEASOCIADO NUMBER(38) NOT NULL,
OFERTAACTIVA NUMBER(38) NOT NULL,
OFERTADISPONIBLE NUMBER(38) NOT NULL,
MODALIDADTEMPORAL VARCHAR2(26) NOT NULL,
constraint FKOfertaAlojamientoInmueble foreign key (INMUEBLEASOCIADO) references INMUEBLE(IDINMUEBLE));

--drop table ofertaalojamiento;

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (1, 3018263.211009752, 1, 0, 1, 'Mes');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (2, 3697911.1148205753, 2, 1, 0, 'Semana');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (3, 2230979.5618871385, 3, 0, 1, 'Semestre');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (4, 3654968.962977705, 4, 0, 0, 'Bimestre');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (5, 3318883.1483903877, 5, 1, 1, 'Mes');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (6, 2190095.96001474, 6, 1, 1, 'Semana');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (7, 3045229.47374532, 7, 1, 0, 'Bimestre');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (8, 2160747.5085419226, 8, 1, 0, 'Semestre');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (9, 1645645.8401014595, 9, 0, 1, 'Semana');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (10, 1518964.6589686386, 10, 0, 0, ' Mes');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (11, 1452236.5006594376, 11, 1, 1, ' Semestre');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (12, 1527659.271855343, 12, 1, 1, ' Bimestre');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (13, 3412120.103369899, 13, 1, 0, ' Mes');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (14, 2909446.135899163, 14, 0, 0, ' Semana');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (15, 1554567.0898734871, 15, 1, 1, ' Bimestre');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (16, 1913069.3233323318, 16, 1, 0, ' Semestre');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (17, 2984686.9033669652, 17, 0, 0, ' Mes');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (18, 1030318.5454495127, 18, 0, 1, ' Semana');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (19, 2544646.494367339, 19, 1, 1, ' Bimestre');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (20, 3028857.5652957316, 20, 1, 1, ' Semestre');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (21, 2766887.8329320746, 21, 1, 1, ' Mes');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (22, 1298205.340684582, 22, 0, 1, ' Semana');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (23, 1469832.8120008034, 23, 1, 1, ' Bimestre');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (24, 1863948.334720483, 24, 1, 1, ' Semestre');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (25, 1641109.8759641142, 25, 1, 1, ' Mes');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (26, 2361158.9502560897, 26, 0, 1, ' Semana');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (27, 1403419.9581690927, 27, 1, 1, ' Bimestre');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (28, 1430502.0623936285, 28, 1, 1, ' Semestre');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (29, 2127224.9121850636, 29, 0, 1, ' Mes');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (30, 1876285.2809008437, 30, 1, 1, ' Semana');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (31, 1189839.3281523737, 31, 0, 0, ' Bimestre');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (32, 3337439.184618684, 32, 0, 1, ' Semestre');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (33, 1635500.8314459317, 33, 0, 0, ' Mes');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (34, 2811283.6831919253, 34, 0, 1, ' Semana');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (35, 1814174.0606957981, 35, 0, 0, ' Bimestre');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (36, 2081645.4200822457, 36, 1, 1, ' Semestre');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (37, 1000315.8324969909, 37, 0, 0, ' Mes');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (38, 1218849.955216109, 38, 1, 0, ' Semana');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (39, 1795988.044259009, 39, 1, 1, ' Bimestre');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (40, 2647517.484930757, 40, 0, 0, ' Semestre');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (41, 2835867.9877810944, 41, 0, 0, ' Mes');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (42, 3036133.739610073, 42, 0, 1, ' Semana');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (43, 1725352.0727814655, 43, 1, 0, ' Bimestre');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (44, 2840097.8953100103, 44, 0, 0, ' Semestre');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (45, 2262304.5619977186, 45, 1, 1, ' Mes');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (46, 1233181.7427667335, 46, 0, 0, ' Semana');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (47, 1284132.6408707595, 47, 1, 0, ' Bimestre');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (48, 2978080.294852545, 48, 0, 1, ' Semestre');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (49, 1095097.856970405, 49, 0, 1, ' Mes');

INSERT INTO OfertaAlojamiento (IDOFERTA, PRECIOBASE, INMUEBLEASOCIADO, OFERTAACTIVA, OFERTADISPONIBLE, MODALIDADTEMPORAL) 
VALUES (50, 3045353.4648343753, 50, 0, 1, ' Semana');

