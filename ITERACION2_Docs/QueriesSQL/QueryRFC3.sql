    /* 
     *  Para el RFC3: Mostrar el �ndice de ocupaci�n de cada una de las ofertas
     *  de alojamiento registradas
     *  el �ndice de ocupaci�n se define como la proporci�n del n�mero de d�as
     *  reservados para cada oferta durante un per�odo espec�fico (por ejemplo,
     *  un a�o) en relaci�n con el total de d�as disponibles en ese per�odo
    */
    

SELECT ofer.ID, COUNT(res.ID) AS NUMERO_RESERVAS, SUM(TRUNC(res.FECHAFINALRESERVA) - TRUNC(res.FECHAINICIALRESERVA)) AS DIAS_RESERVADOS,
((SUM(TRUNC(res.FECHAFINALRESERVA) - TRUNC(res.FECHAINICIALRESERVA))) / ((TRUNC(? - ?)) * 1.0)) * 100 AS INDICE_OCUPACION

FROM OFERTAALOJAMIENTO ofer LEFT JOIN RESERVA res ON ofer.ID = res.IDOFERTAASOCIADA
AND TRUNC(res.FECHAINICIALRESERVA) >= ? AND TRUNC(res.FECHAFINALRESERVA) <= ?
GROUP BY ofer.ID;