# 求各科成绩的最高最低分 思路很简单就是从成绩表里面 group cid 然后直接取max和min函数

select sc.cid as 课程名, max(sc.score) as 最高分, min(sc.score) as 最低分
from sc left join course on sc.cid = course.cid
group by sc.cid;