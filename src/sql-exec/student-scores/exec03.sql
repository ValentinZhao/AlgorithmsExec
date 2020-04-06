# 注意后面的两个group by，我们在join之后其实得到的是第二个表直接join进来的整表
# 这就意味着我们的sid和name其实都是有多个的，只group by一个field是报错的

select student.sid, student.sname, count(sc.cid) as course_num, sum(score) as total
from student left join sc on student.sid = sc.sid
group by student.sid, student.sname;