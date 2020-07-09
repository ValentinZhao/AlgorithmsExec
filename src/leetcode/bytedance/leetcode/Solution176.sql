SELECT IFNULL((SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT 1,1), NULL) AS SecondHighestSalary;

SELECT max(Salary) FROM Employee WHERE Salary < (SELECT max(Salary) FROM Employee);
-- Using max() will return a NULL if the value doesn't exist.