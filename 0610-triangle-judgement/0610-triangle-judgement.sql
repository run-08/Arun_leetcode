# Write your MySQL query statement below
select x , y , z , if(x+y > z &&  x+z > y && y+z > x , 'Yes' , 'No' ) as 'triangle'  from Triangle