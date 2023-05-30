SELECT index_name
FROM all_indexes
WHERE table_name = 'NombreDeLaTabla' AND index_name = 'NombreDelIndice';

--Para optimizar el RFC10:

--Index1 (Ya creado por el DBMS)
CREATE INDEX idx_reserva_id_cliente_asociado
ON Reserva(idClienteAsociado);
COMMIT;

--Index2
CREATE INDEX idx_reserva_id_oferta_asociada
ON Reserva(idOfertaAsociada);
COMMIT;

--Index3 (Ya creado por el DBMS)
CREATE INDEX idx_inmueble_id_inmueble
ON Inmueble(idInmueble);
COMMIT;

--Para optimizar el RFC11:

-- No son necesarios nuevos índices.

--Para optimizar el RFC12:

--Index1
CREATE INDEX idx_reserva_fecha_inicial
ON Reserva(fechaInicialReserva);
COMMIT;

--Index2
CREATE INDEX idx_operador_id_operador
ON Operador(idOperador);
COMMIT;


--Para optimizar el RFC13:

--Index1
CREATE INDEX idx_Reserva_idClienteAsociado
ON Reserva (idClienteAsociado);
COMMIT;

--Index2
CREATE INDEX idx_Reserva_fechaReserva
ON Reserva (fechaReserva);
COMMIT;


--Index3: Ya había sido creado por el DBMS
CREATE INDEX idx_OfertaAlojamiento_idOferta
ON OfertaAlojamiento (idOferta);
COMMIT;

--Index4:
CREATE INDEX idx_OfertaAlojamiento_inmuebleAsociado
ON OfertaAlojamiento (inmuebleAsociado);
COMMIT;

--Index5:
CREATE INDEX idx_Inmueble_Categoria
ON Inmueble (Categoria);
COMMIT;
