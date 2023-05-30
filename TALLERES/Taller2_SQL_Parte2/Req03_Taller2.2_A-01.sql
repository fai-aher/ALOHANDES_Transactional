-- Requerimiento 3
/*Caracterización de los tipos de datos de las tablas: Para todas las tablas de la aplicación (Parranderos)
y para cada tipo de dato que utilice, se quiere mostrar cuántas columnas hay en la tabla de ese tipo de datos
y el promedio de las longitudes de dichas columnas. El resultado debe estar ordenado de forma ascendente por
el nombre de la tabla, el nombre, tipo de dato y el número de columnas con ese tipo de dato. Note que
el nombre de la tabla se repite para cada tipo de dato que utilice. */

ALTER SESSION SET CURRENT_SCHEMA = PARRANDEROS;    
SELECT
    table_name AS NombreTabla,
    data_type AS TipoDeDato,
    COUNT(column_name) AS NumColsTipoDato,
    ROUND(AVG(data_length), 2) AS PromedioLongitudCol
FROM
    ALL_TAB_COLUMNS
WHERE
    table_name IN ('BARES', 'BEBEDORES', 'BEBIDAS', 'FRECUENTAN', 'GUSTAN', 'SIRVEN', 'TIPO_BEBIDA')
GROUP BY
    table_name, data_type
ORDER BY
    table_name ASC,
    data_type ASC,
    COUNT(column_name) ASC;
