SELECT op.idOperador, COUNT(*) AS cantidadReservas
FROM Operador op
JOIN Inmueble i ON op.idOperador = i.operadorAsociado
JOIN OfertaAlojamiento ofa ON i.idInmueble = ofa.inmuebleAsociado
JOIN Reserva r ON ofa.idOferta = r.idOfertaAsociada
WHERE r.fechaInicialReserva BETWEEN TO_DATE('01-01-2022', 'DD-MM-YYYY') AND TO_DATE('28-01-2022', 'DD-MM-YYYY')
GROUP BY op.idOperador
ORDER BY COUNT(*) DESC
FETCH FIRST 5 ROWS ONLY;


--Ejemplos con Inserts
INSERT INTO RESERVA(IDCLIENTEASOCIADO, IDOFERTAASOCIADA, PROMOCIONESACTIVAS, FECHAINICIALRESERVA, FECHAFINALRESERVA, FECHARESERVA, FECHACANCELACION)
VALUES (20,11,'ninguna','06-01-2022','12-01-2022','09-01-2022',null);
COMMIT;
