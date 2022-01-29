
-- select count(friendships.id) from friendships

-- SELECT users.first_name as first_name,users.last_name as last_name, user2.first_name as frind_first_name ,user2.last_name as friend_last_name FROM users 
-- JOIN friendships ON users.id = friendships.user_id
-- JOIN users as user2 ON user2.id = friendships.friend_id

 SELECT users.first_name as first_name,  count(friendships.id) FROM users 

JOIN friendships ON users.id = friendships.user_id
JOIN users as user2 ON user2.id = friendships.friend_id
 group by first_name




