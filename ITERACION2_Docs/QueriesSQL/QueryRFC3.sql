    /* 
     *  Para el RFC3: Mostrar el índice de ocupación de cada una de las ofertas
     *  de alojamiento registradas
     *  el índice de ocupación se define como la proporción del número de días
     *  reservados para cada oferta durante un período específico (por ejemplo,
     *  un año) en relación con el total de días disponibles en ese período
    */
    

SELECT ofer.ID, COUNT(res.ID) AS NUMERO_RESERVAS, SUM(TRUNC(res.FECHAFINALRESERVA) - TRUNC(res.FECHAINICIALRESERVA)) AS DIAS_RESERVADOS,
((SUM(TRUNC(res.FECHAFINALRESERVA) - TRUNC(res.FECHAINICIALRESERVA))) / ((TRUNC(? - ?)) * 1.0)) * 100 AS INDICE_OCUPACION

FROM OFERTAALOJAMIENTO ofer LEFT JOIN RESERVA res ON ofer.ID = res.IDOFERTAASOCIADA
AND TRUNC(res.FECHAINICIALRESERVA) >= ? AND TRUNC(res.FECHAFINALRESERVA) <= ?
GROUP BY ofer.ID;