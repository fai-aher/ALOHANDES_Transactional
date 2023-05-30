ALTER SESSION SET CURRENT_SCHEMA = PARRANDEROS;
with bebs as
(
select bdr.id
from bebedores bdr
inner join gustan g on g.id_bebedor=bdr.id
inner join bebidas bds on bds.id=g.id_bebida
where (grado_alcohol BETWEEN 15 and 25) and bdr.presupuesto='Alto'
group by bdr.id
having count (distinct bds.id)>2
order by bdr.id asc
)
select distinct brs.ciudad,bds.nombre, bds.grado_alcohol
from bebs
inner join frecuentan f on f.id_bebedor=bebs.id
inner join bares brs on f.id_bar=brs.id
inner join sirven s on s.id_bar=brs.id
inner join bebidas bds on s.id_bebida=bds.id
where brs.presupuesto='Alto'
order by brs.ciudad,bds.nombre asc;

with bebs as
(
select bdr.id
from bebedores bdr
inner join gustan g on g.id_bebedor=bdr.id
inner join bebidas bds on bds.id=g.id_bebida
where (grado_alcohol BETWEEN 15 and 25) and bdr.presupuesto='Alto'
group by bdr.id
having count (distinct bds.id)>2
order by bdr.id asc
)
select distinct brs.ciudad, brs.nombre, bds.nombre
from bebs
inner join frecuentan f on f.id_bebedor=bebs.id
inner join bares brs on f.id_bar=brs.id
inner join sirven s on s.id_bar=brs.id
inner join bebidas bds on s.id_bebida=bds.id
where brs.presupuesto='Alto' and bebs.id=ID_BEBIDA
order by brs.ciudad, brs.nombre asc;

with bebs as
(
select bdr.id
from bebedores bdr
inner join gustan g on g.id_bebedor=bdr.id
inner join bebidas bds on bds.id=g.id_bebida
where (grado_alcohol BETWEEN 15 and 25) and bdr.presupuesto='Alto'
group by bdr.id
having count (distinct bds.id)>2
order by bdr.id asc
)
select distinct brs.ciudad, brs.nombre, bds.nombre
from bebedores bbebs
inner join frecuentan f on f.id_bebedor=bbebs.id
inner join bares brs on f.id_bar=brs.id
inner join sirven s on s.id_bar=brs.id
inner join bebidas bds on s.id_bebida=bds.id
where brs.presupuesto='Alto' and bbebs.id=ID_BEBIDA
order by brs.ciudad, brs.nombre asc;



