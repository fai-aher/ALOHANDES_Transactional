SELECT o.*
FROM OFERTA o
JOIN RESERVA res ON o.IDOFERTA = res.IDOFERTAASOCIADA
GROUP BY o.IDOFERTA
ORDER BY COUNT(res.IDRESERVA) DESC 
FETCH FIRST 20 ROWS ONLY;