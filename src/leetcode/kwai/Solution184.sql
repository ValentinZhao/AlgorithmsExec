SELECT d.Name as Department, e.Name as Employee, e.Salary as Salary
FROM Employee e,
     (SELECT DepartmentId, max(Salary) as Salary FROM Employee GROUP BY DepartmentId) t,
     Department d
WHERE e.Salary = t.Salary AND
      e.DepartmentId = t.DepartmentId AND
      e.DepartmentId = d.Id;