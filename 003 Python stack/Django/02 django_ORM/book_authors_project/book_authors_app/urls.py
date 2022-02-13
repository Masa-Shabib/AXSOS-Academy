from django.urls import path     
from . import views
urlpatterns = [
    path('', views.index),
    path('goto', views.goto),
    path('book', views.book),
    path('add_book', views.add_book),
    path('book/<int:book_id>', views.show_book, name='book'),
    path('book/addauthor', views.addauthor),
    path('author', views.author),
    path('add_author', views.add_author),
    path('author/<int:author_id>', views.show_author, name='author'),
    path('author/addbook', views.addbook),
]