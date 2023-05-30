alter session set current_schema=PARRANDEROS;

with baress as
(select bar.ciudad as CIUDAD, count(bar.id) AS Bares_presupuesto_alto
from bares bar
where bar.presupuesto='Alto' 
group by bar.ciudad),
bebis as
(select bebs.ciudad as CIUDAD1, count(bebs.id) AS Bebedores_presupuesto_medio
from  bebedores bebs 
where bebs.presupuesto='Medio' 
group by bebs.ciudad)
select ciudad, Bares_presupuesto_alto, Bebedores_presupuesto_medio
from bebis
inner join baress on ciudad=ciudad1
;


