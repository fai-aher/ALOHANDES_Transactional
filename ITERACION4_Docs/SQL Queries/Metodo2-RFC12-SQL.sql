SELECT *
FROM (
  SELECT o.idOferta, COUNT(*) AS cantidadReservas
  FROM OfertaAlojamiento o
  JOIN Reserva r ON r.idOfertaAsociada = o.idOferta
  WHERE r.fechaInicialReserva BETWEEN TO_DATE('01-01-2022', 'DD-MM-YYYY') AND TO_DATE('28-01-2022', 'DD-MM-YYYY')
  GROUP BY o.idOferta
  ORDER BY COUNT(*) ASC
)
WHERE ROWNUM = 1;
