# 这道题不需要使用join，区别就在于我们不需要基于join表做一些聚合函数
# 我们只是借用这些表里某些字段做引用，跳板查第三张表，那这样的话只要把所要的表
# 全部放在from语句后就能加载进来，对应去查询即可
select sid, sname from student
where sid not in (select distinct(sc.sid) from sc, course, teacher where
sc.cid = course.cid and course.tid = teacher.tid and teacher.tname = '叶平');