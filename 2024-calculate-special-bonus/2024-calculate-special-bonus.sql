# Write your MySQL query statement below
select employee_id , case when employee_id % 2 != 0 && name not Like 'M%' then salary  else 0 end as bonus from Employees order by employee_id asc;