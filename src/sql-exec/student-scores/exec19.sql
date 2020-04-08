# 假如表名为Tab, 人名字段为 myname, 用SQL语句查询一个表名中重名的人
select myname, count(*) from tab group by myname
having count(*) > 1;