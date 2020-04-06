# 删除学习“叶平”老师课的SC表记录； 
Delete SC 
from course ,Teacher  
where Course.C#=SC.C# and Course.T#= Teacher.T# and Tname='叶平';