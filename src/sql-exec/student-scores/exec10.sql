select student.sid, sname from student, sc where student.sid = sc.sid
group by student.sid, student.sname having count(sc.cid) < (select count(cid) from course);
