from django.urls import path     
from . import views
urlpatterns = [
    path('books', views.book),
    path('new_book', views.new_book),
    path('books/<int:book_id>', views.this_book),
    path('books/<int:book_id>/update_book', views.update_book),
    path('books/<int:book_id>/delete_book', views.delete_book),
    path('books/<int:book_id>/add_fav', views.add_fav),
    path('books/<int:book_id>/unfav', views.unfav),
    path('books/user', views.user),
]