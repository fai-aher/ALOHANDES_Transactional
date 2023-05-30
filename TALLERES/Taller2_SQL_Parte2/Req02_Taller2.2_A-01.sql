ALTER SESSION SET CURRENT_SCHEMA = PARRANDEROS;  

SELECT distinct c.table_name as NOMBRE_TABLA,t.column_name as NOMBRE_COLUMNAS_PK, tt.data_type as TIPO_DATOS 
FROM ALL_constraints c inner join ALL_cons_COLUMNS t ON t.constraint_NAME=c.constraint_NAME inner join all_tab_columns tt on tt.column_name=t.column_name
WHERE tt.table_name IN ('BARES', 'BEBEDORES', 'BEBIDAS', 'FRECUENTAN', 'GUSTAN', 'SIRVEN', 'TIPO_BEBIDA') 
and t.table_name IN ('BARES', 'BEBEDORES', 'BEBIDAS', 'FRECUENTAN', 'GUSTAN', 'SIRVEN', 'TIPO_BEBIDA')
and c.table_name IN ('BARES', 'BEBEDORES', 'BEBIDAS', 'FRECUENTAN', 'GUSTAN', 'SIRVEN', 'TIPO_BEBIDA')and c.constraint_type='P'
order by c.table_name ,t.column_name asc;