# 这个子查询非常细节，它代表说我们也是从sc表来查，并且是当前和sc表里面同一个人的时候，这个人也有课程cid为2的课
# 那就代表同一个人也上了cid==2的课 所以子查询也一定是从sc_2表里面拿sid，查同一张表
select student.sid, student.sname from student, sc where student.sid = sc.sid and sc.cid = '1' and exists 
(select * from sc as sc_2 where sc_2.sid = sc.sid and sc_2.cid = '2')
