with validate_date  as (

      select customer_id , min( transaction_date ) as minDate , max( transaction_date ) as maxDate from customer_transactions group by customer_id having DATEDIFF( maxDate , minDate ) >= 30

)
, validate_purchased_customer as (
    
    select c.customer_id , count( transaction_type ) as purchase_cnt from customer_transactions c join ( select * from validate_date ) as v on v.customer_id = c.customer_id where c.transaction_type = 'purchase' group by c.customer_id  having count( transaction_type ) >= 3

) 

, validate_avergae as (
    select c.customer_id , round( ( count( transaction_type ) - v.purchase_cnt ) / count( transaction_type ) * 100 ) as average from customer_transactions c inner join ( select * from validate_purchased_customer ) as v on v.customer_id = c.customer_id group by c.customer_id having average < 20 
)

select customer_id from validate_avergae;
