# Write your MySQL query statement below
select max(n) as num from (select num as n  from MyNumbers group by (num) having count(num) = 1) as uniqueNames ;
