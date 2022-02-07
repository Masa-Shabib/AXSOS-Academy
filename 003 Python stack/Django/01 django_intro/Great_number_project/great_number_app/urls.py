from django.urls import path     
from . import views
urlpatterns = [
    path('', views.index),
    path('num', views.number),
    path('show', views.show),
    path('correct', views.correct),
]
