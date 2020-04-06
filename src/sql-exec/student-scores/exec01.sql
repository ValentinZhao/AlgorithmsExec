# 就是说找出只有课程1和课程2的两张表，在这两张表里面对于同一个人（sid相同）成绩课程1较高的那个
select a.sid from (select sid, score from sc where cid = 1) a,
(select sid, score from sc where cid = 2) b where a.score > b.score and a.sid = b.sid;