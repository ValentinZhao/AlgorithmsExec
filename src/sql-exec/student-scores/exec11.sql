select distinct sid,sname from student,sc where student.sid=sc.sid and sc.cid in (select cid from sc where sid='1001');
# 子查询找1001学号上的所有课，然后遍历所有学生和他学的课来比较是否存在