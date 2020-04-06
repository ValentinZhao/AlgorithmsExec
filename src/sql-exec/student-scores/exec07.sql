select sid, sname from student where sid in
(select sid from sc, course, teacher where sc.cid = course.cid and course.tid = teacher.tid and teacher.tname = '叶平');
# 实测上面就够了
-- select sid, sname from student where sid in
-- (select sid from sc, course, teacher where sc.cid = course.cid and course.tid = teacher.tid and teacher.tname = '叶平'
-- group by sid having count(sc.cid) = (select count(cid) from course, teacher where course.tid = teacher.tid and teacher.tname = '叶平'));