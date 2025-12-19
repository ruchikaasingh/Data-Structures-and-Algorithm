CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    RETURN (
        WITH ranked AS (
            SELECT 
                Salary,
                DENSE_RANK() OVER (ORDER BY Salary DESC) AS rnk
            FROM Employee
        )
        SELECT DISTINCT Salary
        FROM ranked
        WHERE rnk = N
    );
END;
