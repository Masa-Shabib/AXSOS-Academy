from django.urls import path     
from . import views
urlpatterns = [
    path('', views.index),
    path('result', views.result),
    path('result1', views.result1),
]