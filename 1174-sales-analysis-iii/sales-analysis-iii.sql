select p.product_id, p.product_name from Product as p
join Sales as s on p.product_id = s.product_id
group by product_id
having min(s.sale_date)>='2019-01-01' AND max(s.sale_date)<='2019-03-31'