select id, 
	max(case when month = 'jan' then revenue else null end) as Jan_Revenue,
	max(case when month = 'feb' then revenue else null end) as Feb_Revenue,
	max(case when month = 'mar' then revenue else null end) as Mar_Revenue,
	max(case when month = 'apr' then revenue else null end) as Apr_Revenue,
	max(case when month = 'may' then revenue else null end) as May_Revenue,
	max(case when month = 'jun' then revenue else null end) as Jun_Revenue,
	max(case when month = 'jul' then revenue else null end) as Jul_Revenue,
	max(case when month = 'aug' then revenue else null end) as Aug_Revenue,
	max(case when month = 'sep' then revenue else null end) as Sep_Revenue,
	max(case when month = 'oct' then revenue else null end) as Oct_Revenue,
	max(case when month = 'nov' then revenue else null end) as Nov_Revenue,
	max(case when month = 'dec' then revenue else null end) as Dec_Revenue
from department
group by id
order by id;
