# 向SC表中插入一些记录，这些记录要求符合以下条件：没有上过编号“003”课程的同学学号、2号课的平均成绩；
# 直接在insert里面用select可以插入一组数据

insert sc select sid, '5', (select avg(score) from sc where cid='2')
from student where sid not in (select sid from sc where cid='3');