SELECT op.idOperador, COUNT(*) AS cantidadReservas
FROM Operador op
JOIN Inmueble i ON op.idOperador = i.operadorAsociado
JOIN OfertaAlojamiento ofa ON i.idInmueble = ofa.inmuebleAsociado
JOIN Reserva r ON ofa.idOferta = r.idOfertaAsociada
WHERE r.fechaInicialReserva BETWEEN TO_DATE('01-01-2022', 'DD-MM-YYYY') AND TO_DATE('28-01-2022', 'DD-MM-YYYY')
GROUP BY op.idOperador
ORDER BY COUNT(*) ASC
FETCH FIRST 5 ROWS ONLY;
