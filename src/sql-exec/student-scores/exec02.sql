select S#,avg(score) 
from sc 
group by S# having avg(score) >60;