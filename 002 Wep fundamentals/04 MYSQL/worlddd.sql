select count(countries.name) , countries.region  from countries 
group by countries.region
order by count(countries.name) desc







