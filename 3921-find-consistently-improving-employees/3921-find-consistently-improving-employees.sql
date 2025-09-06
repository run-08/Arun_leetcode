with highDate as(
   select employee_id, max(review_date) as maxDate from performance_reviews group by employee_id
)
, midDate as (
   select m.employee_id, max(m.review_date ) as midDate from performance_reviews m where m.review_date < ( select h.maxDate from highDate h where h.employee_id = m.employee_id) group by employee_id 
)
,lowDate as (
    select l.employee_id, max(l.review_date ) as lowDate   from performance_reviews l where l.review_date < ( select m.midDate from midDate m where m.employee_id = l.employee_id) group by employee_id 
)
, combineDate as(
    select h.employee_id, h.maxDate, l.lowDate, m.midDate, ( 
        select p.rating from performance_reviews p where p.employee_id = h.employee_id and p.review_date = h.maxDate
    ) as maxRating,
    ( 
        select p.rating from performance_reviews p where p.employee_id = m.employee_id and p.review_date = m.midDate
    ) as midRating,
    ( 
        select p.rating from performance_reviews p where p.employee_id = l.employee_id and p.review_date = l.lowDate
    ) as lowRating
    from highDate h join midDate m on h.employee_id = m.employee_id
    join lowDate l on l.employee_id = h.employee_id 
)
select c.employee_id, e.name, ( c.maxRating- c.lowRating ) as improvement_score from employees e join  ( select * from combineDate ) as c on c.employee_id = e.employee_id where c.maxRating > c.midRating and c.midRating > c.lowRating order by improvement_score desc, e.name;
