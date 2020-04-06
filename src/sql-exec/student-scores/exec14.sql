# 这题真的不错！要查完全相同的课程，选用count(*)找出所有的返回行，并用另一个count(*)来对比
# 这样就能做到数据完全一致的对比
# 基本思路是，先用sid找1002的所有课，然后找所有有这些cid也就是课的sid，group by sid一下用来集合数据
# 然后在having条件里面，我们count*，去比较sc里面直接取1002的count*是否一致，就能知道是不是选了完全一样的课

select sid, sname from student where sid in (select sc.sid from sc where sc.cid in
(select sc_2.cid from sc as sc_2 where sc_2.sid='1') group by sc.sid having
count(*)=(select count(*) from sc as sc_3 where sc_3.sid='1'));