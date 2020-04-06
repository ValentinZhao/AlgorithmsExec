# 非常经典的一道题
select sid as 学生ID,
(select score from sc where sc.sid=t.sid and cid='1') as 数据库,
(select score from sc where sc.sid=t.sid and cid='2') as 企业管理,
(select score from sc where sc.sid=t.sid and cid='3') as 英语,
count(*) as 有效课程数, avg(t.score) as 平均分 from sc as t
group by sid order by avg(t.score);