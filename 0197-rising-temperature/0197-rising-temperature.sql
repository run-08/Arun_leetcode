# Write your MySQL query statement below
with cte as (
    select id , recordDate , temperature , ROW_NUMBER() OVER ( order by recordDate asc ) as rankA from Weather
)
select c.id  from cte c WHERE c.temperature > ( select cc.temperature from cte cc where cc.rankA = c.rankA - 1 and datediff(c.recordDate , cc.recordDate) = 1 );
