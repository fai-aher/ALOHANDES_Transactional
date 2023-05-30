/* Requerimiento 4
La ciudad para lanzar una nueva bebida. se quiere sacar al mercado un nuevo licor, de 35 grados de alcohol y de costo alto, y
entonces se quiere saber en qué ciudad sería mejor lanzar el piloto. La ciudad apropiada es aquella en la que hay más bebedores
de presupuesto alto a quienes les gustan más de 4 bebidas de más de 25 grados de alcohol. La respuesta esperada debe ser una
tabla con el nombre de la ciudad y el número de bebedores de esa ciudad que cumplen con las características descritas.

Pareja de trabajo A-01
Sistemas Transaccionales 2023-10
*/

ALTER SESSION SET CURRENT_SCHEMA = PARRANDEROS;
SELECT b.ciudad, COUNT(b.id) as num_bebedores
FROM BEBEDORES b
INNER JOIN GUSTAN g ON b.id = g.id_bebida
INNER JOIN BEBIDAS be ON be.id = g.id_bebida
WHERE be.grado_alcohol > 25 AND b.presupuesto = 'Alto'
GROUP BY b.ciudad
HAVING COUNT(CASE WHEN be.grado_alcohol > 25 THEN 1 END) > 4
ORDER BY num_bebedores DESC;





