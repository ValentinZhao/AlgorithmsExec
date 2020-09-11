# https://leetcode.com/problems/department-top-three-salaries/discuss/53692/Accepted-solution-without-group-by-or-order-by
SELECT d.Name as Department, e1.Name as Employee, e1.Salary as Salary
FROM Employee e1 JOIN Department d
ON e1.DepartmentId = d.Id
WHERE (SELECT count(distinct(e2.Salary)) FROM Employee e2
            WHERE e1.DepartmentId = e2.DepartmentId AND
            e2.Salary > e1.Salary) < 3;