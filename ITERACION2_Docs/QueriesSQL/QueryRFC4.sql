    /* Para el RFC4: Mostrar los alojamientos disponibles en un rango de fechas,
     * que cumplen con un conjunto de requerimientos de dotación o servicios.
     * 
     * Se consider que esos servicios se obtienen como parametros por medio de una
     * lista de Strings.
     * 
     * Además, se requerien 2 atributos mas: fechaInicio y fechaFin para filtrar la
     * busqueda.
     */
     
SELECT ofer.* 
FROM OFERTAALOJAMIENTO ofer
WHERE ofer.ID NOT IN (SELECT res.IDOFERTAASOCIADA FROM RESERVA res
WHERE (TRUNC(res.FECHAINICIALRESERVA) BETWEEN ? AND ?) OR (TRUNC(res.FECHAFINALRESERVA) BETWEEN ? AND ?))
AND ofer.ID IN (SELECT spo.IDOFERTAALOJAMIENTO FROM SERVICIOSPOROFERTA spo
INNER JOIN SERVICIO serv ON spo.IDSERVICIOOFRECIDO = serv.IDSERVICIO
WHERE serv.NOMBRE IN ? OR serv.NOMBRE IN ?  OR serv.NOMBRE IN ?  OR serv.NOMBRE IN ?  OR serv.NOMBRE IN ? /* tantos ? como diferentes servicios en la lista*/
GROUP BY spo.IDOFERTAALOJAMIENTO HAVING COUNT(spo.IDOFERTAALOJAMIENTO) = ?);