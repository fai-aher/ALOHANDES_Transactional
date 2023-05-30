/* 
    RFC8 - ENCONTRAR LOS CLIENTES FRECUENTES
    Para un alojamiento dado, encontrar la información de sus clientes frecuentes. se considera frecuente a un
    cliente si ha utilizado (o tiene reservado) ese alojamiento por lo menos en tres ocasiones o por lo menos 15
    noches, durante todo el periodo de operación de AlohAndes.
    
    Se establece un ejemplo con un id de inmueble igual a 62.
*/
SELECT r.idClienteAsociado, COUNT(*) as numReservas, SUM(TRUNC(r.fechaFinalReserva) - TRUNC(r.fechaInicialReserva)) as totalNoches
FROM Reserva r INNER JOIN OfertaAlojamiento o ON r.idOfertaAsociada = o.idOferta
WHERE o.inmuebleAsociado = 62
GROUP BY r.idClienteAsociado
HAVING COUNT(*) >= 3 OR SUM(TRUNC(r.fechaFinalReserva) - TRUNC(r.fechaInicialReserva)) >= 15;

