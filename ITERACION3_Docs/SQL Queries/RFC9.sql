/* 
    RFC9 - ENCONTRAR LAS OFERTAS DE ALOJAMIENTO QUE NO TIENEN MUCHA DEMANDA
    Encontrar las ofertas de alojamiento que no han recibido clientes en periodos superiores a 1 mes, durante todo
    el periodo de operación de AlohAndes
        
    Se realiza la consulta sobre toda la base de datos.
    Se utiliza un self-join en el select interno para operar informacion
    de la misma tabla y dar un resultado.
*/
SELECT DISTINCT o.idOferta
FROM OfertaAlojamiento o
WHERE o.idOferta NOT IN (
SELECT r.idOfertaAsociada
FROM Reserva r
JOIN Reserva r2 ON r.idOfertaAsociada = r2.idOfertaAsociada AND r.fechaInicialReserva != r2.fechaInicialReserva
WHERE ABS(TRUNC(r.fechaInicialReserva) - TRUNC(r2.fechaInicialReserva)) <= 30);