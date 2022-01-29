select * from authors

JOIN favorites ON authors.id = favorites.author_id
JOIN books ON books.id = favorites.book_id

where favorites.book_id= 5


