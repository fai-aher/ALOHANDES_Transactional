
--RFC13

--Query1 : Funciona
SELECT c.*, (SELECT COUNT(*) FROM Reserva r WHERE c.idCliente = r.idClienteAsociado AND EXTRACT(YEAR FROM r.fechaReserva) = 2022) AS NumeroReservasAlAño
FROM Cliente c
WHERE (SELECT COUNT(DISTINCT EXTRACT(MONTH FROM r.fechaReserva)) FROM Reserva r WHERE c.idCliente = r.idClienteAsociado AND EXTRACT(YEAR FROM r.fechaReserva) = 2022) = 12;


--Query2 : Funciona

SELECT c.*, (SELECT COUNT(*) FROM Reserva r, OfertaAlojamiento o WHERE c.idCliente = r.idClienteAsociado AND r.idOfertaAsociada = o.idOferta AND o.precioBase >= 700000 AND EXTRACT(YEAR FROM r.fechaReserva) = 2022) AS Cantidad_Reservas_Costosas_AlAño
FROM Cliente c
WHERE (SELECT COUNT(DISTINCT EXTRACT(MONTH FROM r.fechaReserva)) FROM Reserva r WHERE c.idCliente = r.idClienteAsociado AND EXTRACT(YEAR FROM r.fechaReserva) = 2022) = 12;


-- Query 3: Funciona

SELECT c.*, (SELECT COUNT(*) FROM Reserva r, OfertaAlojamiento o, Inmueble i WHERE c.idCliente = r.idClienteAsociado AND r.idOfertaAsociada = o.idOferta AND o.inmuebleAsociado = i.idInmueble AND i.Categoria = 'SUITE' AND EXTRACT(YEAR FROM r.fechaReserva) = 2022) AS Numero_Reservas_Suite_Al_Año
FROM Cliente c
WHERE (SELECT COUNT(DISTINCT EXTRACT(MONTH FROM r.fechaReserva)) FROM Reserva r WHERE c.idCliente = r.idClienteAsociado AND EXTRACT(YEAR FROM r.fechaReserva) = 2022) = 12;






--Ejemplo de inserts

INSERT INTO RESERVA(IDCLIENTEASOCIADO, IDOFERTAASOCIADA, PROMOCIONESACTIVAS, FECHAINICIALRESERVA, FECHAFINALRESERVA, FECHARESERVA, FECHACANCELACION)
VALUES (210,10101010,'ninguna','01-02-2022','12-01-2022','02-12-2022',null);
commit;