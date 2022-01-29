-- select customer.first_name ,customer.last_name,customer.email, address.address from city
-- join address on city.city_id = address.city_id
-- join customer on customer.address_id=  address.address_id
-- where city.city_id = 312 

-- select film.title, film.description,film.release_year,film.rating,film.special_features  from film
-- join film_category on film.film_id = film_category.film_id
-- join category on category.category_id = film_category.category_id
-- where category.name ='comedy'

-- select actor.actor_id,concat(actor.first_name,' ',actor.last_name) , film.title, film.description,film.release_year from film
-- join film_actor on film.film_id = film_actor.film_id
-- join actor on actor.actor_id = film_actor.actor_id
-- where actor.actor_id =5

-- select customer.first_name ,customer.last_name,customer.email, address.address from city
-- join address on city.city_id = address.city_id
-- join customer on customer.address_id=  address.address_id
-- join store on store.store_id = customer.store_id
-- where store.store_id = 1 and (city.city_id = 1 or city.city_id = 42 or city.city_id = 312 or city.city_id = 459)

-- select film.title, film.description,film.release_year,film.rating,film.special_features  from film
-- join film_actor on film.film_id = film_actor.film_id
-- join actor on actor.actor_id = film_actor.actor_id
-- where  actor.actor_id =15 and film.rating ='G' and film.special_features  like '%behind the scenes%'

-- select actor.actor_id,concat(actor.first_name,' ',actor.last_name) , film.title, film.film_id from film
-- join film_actor on film.film_id = film_actor.film_id
-- join actor on actor.actor_id = film_actor.actor_id
-- where film.film_id= 369

-- select film.title, film.description,film.release_year,film.rating,film.special_features, category.name  from film
-- join film_category on film.film_id = film_category.film_id
-- join category on category.category_id = film_category.category_id
-- where category.name ='drama' and film.rental_rate= 2.99

select film.title, film.description,film.release_year,film.rating,film.special_features,concat(actor.first_name,' ',actor.last_name) as actor_name,category.name  from film
join film_actor on film.film_id = film_actor.film_id
join actor on actor.actor_id = film_actor.actor_id
join film_category on film.film_id = film_category.film_id
join category on category.category_id = film_category.category_id

where  category.name ='Action'  and concat(actor.first_name,' ',actor.last_name)='SANDRA KILMER'
