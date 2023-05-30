/* 
 * Requerimiento de Consulta  7
 * RFC7 - ANALIZAR LA OPERACI�N DE ALOHANDES
 * Para una unidad de tiempo definido (por ejemplo, semana o mes) y un tipo de alojamiento, considerando todo
 * el tiempo de operaci�n de AloHandes, indicar cu�les fueron las fechas de mayor demanda (mayor cantidad de
 * alojamientos ocupados), las de mayores ingresos (mayor cantidad de dinero recibido) y las de menor ocupaci�n.

    Para resolver este requerimiento de consuulta, se crearon 3 funciones encargadas cada una de mostrar informaci�n
    relevante para el requerimiento, estas 3 funciones son:
    
    1.calcularFechasMayorDemanda
    2.calcularFechasMayoresIngresos
    3.calcularFechasMenorOcupacion
    
    Las 3 son utilizadas y ejecutadas desde una funci�n principal llamada analizarOperacionAlohandes.
    Todas las funciones se pueden encontrar en la clase: PersistenciaAlohandes.
    
    A continuaci�n, se presentan los Queries SQL para cada una de las 3 funciones.
    
 */
 
 /* 
  * 1.calcularFechasMayorDemanda
  
  * Se presenta un ejemplo de ejecuci�n con el valor de categoria 'B�sico' y ModalidadTemporal = 'Semana'
 */
 
SELECT res.FECHAINICIALRESERVA, COUNT(res.IDOFERTAASOCIADA) AS CANTIDAD_RESERVAS
FROM RESERVA res
JOIN OFERTAALOJAMIENTO oa ON res.IDOFERTAASOCIADA = oa.IDOFERTA
JOIN INMUEBLE i ON oa.INMUEBLEASOCIADO = i.IDINMUEBLE
WHERE i.CATEGORIA = 'Ejecutivo' AND oa.MODALIDADTEMPORAL = 'Semestre'
GROUP BY res.FECHAINICIALRESERVA
ORDER BY CANTIDAD_RESERVAS DESC;

 /* 
  * 2.calcularFechasMayoresIngresos
  
  * Se presenta un ejemplo de ejecuci�n con el valor de categoria 'B�sico' y ModalidadTemporal = 'Semana'
 */
 
SELECT res.FECHAINICIALRESERVA, SUM((TRUNC(res.FECHAFINALRESERVA) - TRUNC(res.FECHAINICIALRESERVA)) * oa.PRECIOBASE) AS INGRESOS_EN_PESOS
FROM RESERVA res
JOIN OFERTAALOJAMIENTO oa ON res.IDOFERTAASOCIADA = oa.IDOFERTA
JOIN INMUEBLE i ON oa.INMUEBLEASOCIADO = i.IDINMUEBLE
WHERE i.CATEGORIA = 'Ejecutivo' AND oa.MODALIDADTEMPORAL = 'Semestre'
GROUP BY res.FECHAINICIALRESERVA
ORDER BY INGRESOS_EN_PESOS DESC;

 /* 
  * 3.calcularFechasMenorOcupacion
  
  * Se presenta un ejemplo de ejecuci�n con el valor de categoria 'B�sico' y ModalidadTemporal = 'Semana'
 */
 
SELECT res.FECHAINICIALRESERVA, COUNT(res.IDOFERTAASOCIADA) AS CANTIDAD_RESERVAS
FROM RESERVA res
JOIN OFERTAALOJAMIENTO oa ON res.IDOFERTAASOCIADA = oa.IDOFERTA
JOIN INMUEBLE i ON oa.INMUEBLEASOCIADO = i.IDINMUEBLE
WHERE i.CATEGORIA = 'Ejecutivo' AND oa.MODALIDADTEMPORAL = 'Semestre'
GROUP BY res.FECHAINICIALRESERVA
ORDER BY CANTIDAD_RESERVAS ASC;