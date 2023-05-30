
ALTER SESSION SET CURRENT_SCHEMA = PARRANDEROS;
select bar.nombre, count(bar.id) as apariciones 
from bares bar
full outer join frecuentan f on bar.id=f.id_bar
full outer join bebedores bebs on bebs.id=f.id_bebedor
full outer join sirven s on s.id_bar=bar.id
group by bar.nombre
order by apariciones desc
FETCH first 10 rows only;



