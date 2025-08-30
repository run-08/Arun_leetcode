# Write your MySQL query statement below
with user_name as ( 

  select name , count(distinct m.movie_id) as count from Users u join MovieRating m where m.user_id = u.user_id group by u.user_id order by count desc , name limit 1

),

rating as (

   select title , avg(rating) as rating from Movies m inner join MovieRating mr on mr.movie_id = m.movie_id where month( created_at ) = 2 and year( created_at ) = 2020 group by (m.movie_id)  order by rating desc , title limit 1 

)
select name as results from user_name union all select title from rating;