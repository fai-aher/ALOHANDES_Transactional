-- REQUERIMIENTO 5 

/*Se quiere tener un listado del subconjunto de columnas de la base de datos de Parranderos,
cuyo nombre no contiene la letra “R” y que tiene máximo 2 vocales, indicando para cada columna su nombre,
tabla a la que pertenece y el número de restricciones que la afectan (por ejemplo, si una columna es parte
de la llave primaria de la tabla y tiene una restricción de llave foránea, el resultado en esta columna debe ser mayor o igual a dos (2))

Este listado puede ser solicitado en cualquier momento y por lo tanto debe generarse de forma semiautomática, mediante el siguiente proceso:

a. Mediante UNA consulta al catálogo, obtener un listado donde, para cada columna de Parranderos que debe ser incluida en el resultado, hay una fila de respuesta.
Cada fila de respuesta de la consulta anterior contiene una sentencia SQL que permite encontrar la información solicitada
para la columna correspondiente, terminado con punto y coma (;).
Este listado contiene las sentencias SQL que se requieren para la segunda etapa.

b. Utilizar el listado de la etapa a) como un script, cuya ejecución devuelve un nuevo listado donde cada fila contiene la
información solicitada de las columnas solicitadas de Parranderos.
 */

-- Soluciones

-- Parte a
ALTER SESSION SET CURRENT_SCHEMA = PARRANDEROS;
SELECT 'SELECT ''' || c.column_name || ''' AS Columna, ''' || c.table_name || ''' AS Tabla, COUNT(*)
AS Num_Restricciones FROM all_cons_columns acc JOIN all_constraints ac ON acc.constraint_name = ac.constraint_name
AND acc.owner = ac.owner WHERE acc.table_name = ''' || c.table_name || ''' AND acc.column_name = '''
|| c.column_name || ''';' AS SQL_Sentencia
FROM all_tab_columns c
WHERE c.owner = 'PARRANDEROS' AND c.column_name NOT LIKE '%R%' AND REGEXP_COUNT(c.column_name, '[AEIOU]') <= 2
ORDER BY c.table_name, c.column_name;
  
-- Parte b

-- Primera fila
SELECT 'ID' AS Columna, 'BARES' AS Tabla, COUNT(*) AS Num_Restricciones
FROM all_cons_columns acc JOIN all_constraints ac ON acc.constraint_name = ac.constraint_name AND acc.owner = ac.owner
WHERE acc.table_name = 'BARES' AND acc.column_name = 'ID';
-- Segunda fila
SELECT 'ID' AS Columna, 'BEBEDORES' AS Tabla, COUNT(*) AS Num_Restricciones
FROM all_cons_columns acc JOIN all_constraints ac ON acc.constraint_name = ac.constraint_name AND acc.owner = ac.owner
WHERE acc.table_name = 'BEBEDORES' AND acc.column_name = 'ID';
-- Tercera fila
SELECT 'ID' AS Columna, 'BEBIDAS' AS Tabla, COUNT(*) AS Num_Restricciones
FROM all_cons_columns acc JOIN all_constraints ac ON acc.constraint_name = ac.constraint_name
WHERE acc.table_name = 'BEBIDAS' AND acc.column_name = 'ID';  
-- Cuarta fila
SELECT 'TIPO' AS Columna, 'BEBIDAS' AS Tabla, COUNT(*) AS Num_Restricciones
FROM all_cons_columns acc JOIN all_constraints ac ON acc.constraint_name = ac.constraint_name
WHERE acc.table_name = 'BEBIDAS' AND acc.column_name = 'TIPO';
-- Quinta fila
SELECT 'ID' AS Columna, 'TIPO_BEBIDA' AS Tabla, COUNT(*) AS Num_Restricciones
FROM all_cons_columns acc JOIN all_constraints ac ON acc.constraint_name = ac.constraint_name AND acc.owner = ac.owner
WHERE acc.table_name = 'TIPO_BEBIDA' AND acc.column_name = 'ID';