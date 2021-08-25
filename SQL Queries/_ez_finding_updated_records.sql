--my OBS: add a function to the one that is NOT in GROUP BY 

--from each group of rows whic have the same id, first_name, last_name, department_id
--select only one of them! (max in this case)

-- https://platform.stratascratch.com/coding-question?python=&id=10299
select id, first_name, last_name, department_id, MAX(salary)
from ms_employee_salary
group by id, first_name, last_name, department_id
order by id ASC;