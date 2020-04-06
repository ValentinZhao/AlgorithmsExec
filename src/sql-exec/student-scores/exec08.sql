select sid, sname from student where sid in (select sc_1.sid from 
(select sid, score from sc where sc.cid = '1') as sc_1,
(select sid, score from sc where sc.cid = '2') as sc_2
where sc_1.sid = sc_2.sid and sc_1.score > sc_2.score);