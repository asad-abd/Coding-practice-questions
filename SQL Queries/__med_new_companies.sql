-- https://www.hackerrank.com/challenges/the-company/problem?h_r=next-challenge&h_v=zen
--company_code, founder name, total number of lead managers, total number of senior managers, total number of managers, and total number of employees. Order your output by ascending company_code.
-- Company, Lead_Manager, Senior_Manager, Manager, Employee

Select 
    c.company_code, c.founder, COUNT(DISTINCT l.lead_manager_code), 
    COUNT(DISTINCT s.senior_manager_code), COUNT(DISTINCT m.manager_code),
    COUNT(DISTINCT e.employee_code)
FROM Company c
    INNER JOIN Lead_Manager l on c.company_code = l.company_code
    INNER JOIN Senior_Manager s on c.company_code = s.company_code
    INNER JOIN Manager m on c.company_code = m.company_code
    INNER JOIN Employee e on c.company_code = e.company_code
GROUP BY c.company_code, c.founder
ORDER BY c.company_code ASC

-- though if we see the tables properly we need only employee and company tables for counting everything else
select c.company_code, c.founder, 
    count(distinct e.lead_manager_code), 
    count(distinct e.senior_manager_code), 
    count(distinct e.manager_code), 
    count(distinct e.employee_code)
from company c
    inner join employee e on e.company_code = c.company_code
group by c.company_code,c.founder
order by c.company_code;