/* soln 1 */
SELECT DISTINCT city 
FROM station 
WHERE city REGEXP '^[a,e,i,o,u]'

/* soln 2 */
SELECT DISTINCT city 
FROM station 
WHERE LOWER(SUBSTR(CITY,1,1)) IN ('a', 'e', 'i', 'o', 'u')