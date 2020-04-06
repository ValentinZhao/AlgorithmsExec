# 把“SC”表中“叶平”老师教的课的成绩都更改为此课程的平均成绩； 
# 这个真的很trick，首先不管子查询，我们会发现update SC的这个SC，其实就是查询过course和teacher表之后的
# 叶平老师的所有的课的结果集。这时候再跟子查询就有这时候的sc_2其实就是一样的叶平老师所有的课，但是被用来计算avg了而已
update SC set score=(select avg(SC_2.score) 
from SC as SC_2 
where SC_2.C#=SC.C# ) from Course,Teacher where Course.C#=SC.C# and Course.T#=Teacher.T# and Teacher.Tname='叶平');