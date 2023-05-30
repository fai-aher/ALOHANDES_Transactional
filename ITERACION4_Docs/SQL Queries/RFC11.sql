select * 
from cliente c inner join reserva r on c.idcliente = r.idclienteasociado
where r.idofertaasociada=401311 and r.fechainicialreserva between to_date('15/03/22','dd,mm,yy') and to_date('31/03/22','dd,mm,yy') and c.idcliente=1310 
group by c.idcliente
order by r.idofertaasociada;


select * from cliente c inner join reserva r on c.idcliente = r.idclienteasociado where r.idofertaasociada=401311 and r.fechainicialreserva between to_date('15/03/22','dd/mm/yy') and to_date('31/03/22','dd/mm/yy') and c.idcliente=1310; 
select * from cliente c inner join reserva r on c.idcliente = r.idclienteasociado where r.idofertaasociada=401311 and r.fechainicialreserva between to_date('15/03/22','dd/mm/yy') and to_date('31/03/22','dd/mm/yy') and c.idcliente=1310;
select * from cliente c inner join reserva r on c.idcliente = r.idclienteasociado where r.idofertaasociada=401311 and r.fechainicialreserva between to_date('15/03/22','dd/mm/yy') and to_date('31/03/22','dd/mm/yy') and c.idcliente=1310;

select * from reserva;
select * from cliente;


