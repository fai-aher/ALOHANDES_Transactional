ALTER SESSION SET CURRENT_SCHEMA = PARRANDEROS;
with baress as
(
select distinct bds.tipo as tipo11,br.presupuesto as presupuesto_bar, count (distinct br.id) num_bares
from bebidas bds
inner join sirven s on s.id_bebida=bds.id
inner join bares br on s.id_bar=br.id
group by bds.tipo, br.presupuesto
order by bds.tipo,br.presupuesto
),
bebedoress as
(
select distinct bds.tipo as TIPO1, bs.presupuesto as presupuesto_bebedor, count(distinct bs.id) as num_bebedores
from bebidas bds
inner join gustan g on g.id_bebida=bds.id
inner join bebedores bs on bs.id=g.id_bebedor
group by bds.tipo, bs.presupuesto
order by bds.tipo
)
select distinct bdss.tipo, round(avg(bdss.grado_alcohol),2) as alcohol_promedio, baress.presupuesto_bar, baress.num_bares,
bebedoress.presupuesto_bebedor, bebedoress.num_bebedores
from  baress, bebedoress, bebidas bdss
where tipo11=tipo1 and tipo1=tipo
group by bdss.tipo, baress.presupuesto_bar, baress.num_bares,
bebedoress.presupuesto_bebedor, bebedoress.num_bebedores
order by bdss.tipo
;


