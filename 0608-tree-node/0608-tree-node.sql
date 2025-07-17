# Write your MySQL query statement below
select T.id ,  case 
            when T.p_id is null then 'Root'
            when exists (select true from Tree sT where T.id = sT.p_id )  then 'Inner'
            else 'Leaf' end as type
from Tree T;
