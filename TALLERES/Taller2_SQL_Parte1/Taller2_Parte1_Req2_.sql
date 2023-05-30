/* Requerimiento 2
Se quiere conocer quiénes son los bebedores arribistas todas las ciudades. Para cada bebedor arribista, se debe mostrar su
identificador, su nombre, su ciudad, su presupuesto y cuántos bares de cada presupuesto frecuenta. Ordene el resultado por
la ciudad, presupuesto y nombre del bebedor.

Pareja de trabajo A-01
Sistemas Transaccionales 2023-10
*/
ALTER SESSION SET CURRENT_SCHEMA = PARRANDEROS;
SELECT bebedores.id, bebedores.nombre, bebedores.ciudad, bebedores.presupuesto,
    COALESCE(bajo_pres.conteo_bares_bajo_presupuesto, 0) AS bares_bajo_presupuesto,
    COALESCE(medio_pres.conteo_bares_medio_presupuesto, 0) AS bares_medio_presupuesto,
    COALESCE(alto_pres.conteo_bares_alto_presupuesto, 0) AS bares_alto_presupuesto
FROM BEBEDORES
LEFT JOIN (SELECT id_bebedor, COUNT(*) AS conteo_bares_bajo_presupuesto
           FROM FRECUENTAN f INNER JOIN BARES ba ON f.id_bar = ba.id
           WHERE ba.presupuesto = 'Bajo'
           GROUP BY id_bebedor) bajo_pres ON bebedores.id = bajo_pres.id_bebedor
LEFT JOIN (SELECT id_bebedor, COUNT(*) AS conteo_bares_medio_presupuesto
           FROM FRECUENTAN f INNER JOIN BARES ba ON f.id_bar = ba.id
           WHERE ba.presupuesto = 'Medio'
           GROUP BY id_bebedor) medio_pres ON bebedores.id = medio_pres.id_bebedor
LEFT JOIN (SELECT id_bebedor, COUNT(*) AS conteo_bares_alto_presupuesto
           FROM FRECUENTAN f INNER JOIN BARES ba ON f.id_bar = ba.id
           WHERE ba.presupuesto = 'Alto'
           GROUP BY id_bebedor) alto_pres ON bebedores.id = alto_pres.id_bebedor
WHERE bebedores.presupuesto IN ('Alto', 'Medio', 'Bajo')
AND NOT EXISTS (SELECT *
                FROM FRECUENTAN f INNER JOIN BARES ba ON f.id_bar = ba.id
                WHERE f.id_bebedor = bebedores.id
                AND (bebedores.presupuesto = ba.presupuesto)
                OR (bebedores.presupuesto = 'Medio' AND bajo_pres.conteo_bares_bajo_presupuesto > 0)
                OR (bebedores.presupuesto = 'Alto' AND medio_pres.conteo_bares_medio_presupuesto > 0)
                OR (bebedores.presupuesto = 'Alto' AND bajo_pres.conteo_bares_bajo_presupuesto > 0)
                )
ORDER BY bebedores.ciudad, bebedores.presupuesto, bebedores.nombre;

