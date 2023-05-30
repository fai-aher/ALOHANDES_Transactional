-- Requerimiento 4
/*      Listado general de las columnas y sus restricciones: Para todas las columnas de las
tablas de Parranderos se debe mostrar el nombre de la tabla, el nombre de la columna,
el tipo de dato de la columna, el nombre de la restricción y si permite nulos o no.
El resultado debe estar ordenado de forma ascendente por el nombre de la tabla, el nombre
de la columna y el nombre de la restricción. Para las columnas que no tienen restricciones,
en el nombre de la restricción debe aparecer “NO TIENE”. Note que para las columnas que
tienen más de una restricción, la información de la columna se repite.*/

ALTER SESSION SET CURRENT_SCHEMA = PARRANDEROS; 
SELECT 
  tc.table_name AS NombreTabla,
  tc.column_name AS NombreColumna,
  tc.data_type AS TipoDeDato,
  COALESCE(ucc.constraint_name,'NO TIENE') AS NombreRestriccion,
  CASE
    WHEN tc.nullable = 'Y' THEN 'Sí'
    ELSE 'No'
  END AS PermiteNulos
FROM 
  ALL_TAB_COLUMNS tc
LEFT JOIN 
  ALL_CONS_COLUMNS ucc ON tc.table_name = ucc.table_name AND tc.column_name = ucc.column_name

WHERE 
  tc.table_name IN ('BARES', 'BEBEDORES', 'BEBIDAS', 'FRECUENTAN', 'GUSTAN', 'SIRVEN', 'TIPO_BEBIDA')
ORDER BY 
  tc.table_name ASC, 
  tc.column_name ASC, 
  NombreRestriccion ASC;