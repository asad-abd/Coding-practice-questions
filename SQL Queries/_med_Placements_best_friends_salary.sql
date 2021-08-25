-- https://www.hackerrank.com/challenges/placements/problem

-- Students, Friends and Packages. Students contains two columns: ID and Name. Friends contains two columns: ID and Friend_ID (ID of the ONLY best friend). Packages contains two columns: ID and Salary (offered salary in $ thousands per month).
-- query to output the names of those students whose best friends got offered a higher salary than them. Names must be ordered by the salary amount offered to the best friends. It is guaranteed that no two students got same salary offer.

---- | id | name | fr_id | package | friend package | (this last one is 'the' trick)
Select s.name 
From Students s 
    INNER JOIN Friends f on s.id = f.id
    INNER JOIN Packages p1 on s.id = p1.id
    INNER JOIN Packages p2 on f.Friend_ID = p2.id
Where 
    p1.Salary < p2.Salary
Order By p2.Salary    

