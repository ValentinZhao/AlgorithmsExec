# 查询至少学过学号为“001”同学所有一门课的其他同学学号和姓名； 
select distinct SC.S#,Sname 
from Student,SC 
where Student.S#=SC.S# and C# in (select C# from SC where S#='001');