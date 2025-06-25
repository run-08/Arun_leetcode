# Write your MySQL query statement below
select Eu.unique_id , e.name from Employees  e left join EmployeeUNI  Eu on e.id = Eu.id;