--link: https://platform.stratascratch.com/coding-question?id=10308&python=

--my solution
select (select Max(salary) from (db_employee left join db_dept on db_employee.department_id = db_dept.id)
where department = 'marketing')- (select Max(salary) from (db_employee left join db_dept on db_employee.department_id = db_dept.id) 
where department = 'engineering');