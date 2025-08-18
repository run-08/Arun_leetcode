# Write your MySQL query statement below
with partioned as (
    select s.store_id , (
      select inventory_id from inventory i where s.store_id = i.store_id order by i.price desc limit 1 
    ) as high, ( select inventory_id from inventory i where s.store_id = i.store_id order by i.price limit 1
    ) as low from stores s 
)
,
validIds as (
    select store_id from inventory group by store_id having count(product_name) >= 3
)

select s.store_id , s.store_name , s.location , (
    select product_name from inventory where inventory_id = p.high
) as most_exp_product , ( select product_name from inventory where inventory_id = p.low ) as cheapest_product , ( select round( ( select quantity from inventory where inventory_id = p.low ) / ( select quantity from inventory where inventory_id = p.high) , 2 ) ) as imbalance_ratio  from stores s inner join (select * from partioned ) p on p.store_id = s.store_id where s.store_id in ( select * from validIds ) and (select quantity from inventory where inventory_id = p.high ) < (select quantity from inventory where inventory_id = p.low ) order by imbalance_ratio desc , s.store_name asc;
