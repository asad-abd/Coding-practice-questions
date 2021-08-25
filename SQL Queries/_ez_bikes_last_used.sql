--https://platform.stratascratch.com/coding-question?python=&id=10176
--easy
select bike_number, MAX(end_time) as last_used
from dc_bikeshare_q1_2012
group by bike_number
order by last_used DESC