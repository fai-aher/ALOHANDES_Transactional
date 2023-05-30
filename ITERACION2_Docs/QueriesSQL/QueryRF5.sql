/* RF5: Eliminacion de una Reserva o todas */

DELETE FROM RESERVAS WHERE idclienteasociado = ? AND idofertaasociada = ? AND fechareserva = ?
AND idofertaasociada = (SELECT id FROM OFERTAALOJAMIENTO oa WHERE oa.id = idofertaasociada AND oa.ofertaactiva = FALSE );


/* Borrar todas y verificar condicion */
DELETE FROM RESERVAS WHERE idofertaasociada = (SELECT id FROM OFERTAALOJAMIENTO oa WHERE oa.id = idofertaasociada AND oa.ofertaactiva = FALSE );