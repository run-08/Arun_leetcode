# Write your MySQL query statement below
with cte_as as (
     select sum(if(income > 50000 , 1 , 0)) as 'accounts_count' from Accounts
     union all
     select sum(if(income < 20000 , 1 , 0))  from Accounts
     union all
     select sum(if(income >= 20000 and income <= 50000 , 1 , 0)) from Accounts
),
cte_name as (
    select 'High Salary' as category union select 'Low Salary' union select 'Average Salary'
),
numbered_salary as (
    select accounts_count , row_number() over() as rn from cte_as
),
numbered_name as (
    select category , row_number() over() as rn from cte_name 
)
select numbered_name.category , numbered_salary.accounts_count from numbered_name inner join numbered_salary on numbered_salary.rn = numbered_name.rn;
