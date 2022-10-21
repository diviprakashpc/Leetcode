# Write your MySQL query statement below



select u.user_id , concat(upper(substring(u.name,1,1)),lower(substring(u.name,2))) as name
from Users as u
order by u.user_id;