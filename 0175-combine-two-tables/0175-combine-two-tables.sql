# Write your MySQL query statement below
-- alter table Person add foreign key(personId) references Address(personId);
select firstName , lastName , city , state from Person left join Address on Person.PersonId = Address.PersonId;