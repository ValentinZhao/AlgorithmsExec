# 查询 所有课程成绩都小于60分 的同学的学号、姓名
select sid, sname from student where sid not in
(select sc.sid from sc where sc.score > 60);
