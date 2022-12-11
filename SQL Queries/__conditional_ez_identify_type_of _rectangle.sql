/*
    Write a query identifying the type of each record in the TRIANGLES table using its three side lengths. Output one of the following statements for each record in the table:

    Equilateral: It's a triangle with  sides of equal length.
    Isosceles: It's a triangle with  sides of equal length.
    Scalene: It's a triangle with  sides of differing lengths.
    Not A Triangle: The given values of A, B, and C don't form a triangle.
    Input Format

    The TRIANGLES table is described as follows:
*/

/*
Our usual format of 
    SELECT .
    FROM ..
    WHERE ...

becomes 
    SELECT ., our_conditional_stmt
    FROM ..
    WHERE ...

=>
    SELECT .,  
        CASE
            WHEN //if// x THEN y
            WHEN //if// z THEN a
            ELSE b
        END
    FROM ..
    WHERE ...

*/

SELECT 
    CASE 
        WHEN A=B AND B=C AND C=A THEN 'Equilateral' 
        WHEN A+B<=C OR B+C<=A OR A+C<=B THEN 'Not A Triangle' 
        WHEN A<>B AND B<>C AND C<>A THEN 'Scalene' 
        ELSE 'Isosceles' 
    END 
FROM TRIANGLES;
