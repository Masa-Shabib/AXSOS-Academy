from django.urls import path     
from . import views
urlpatterns = [
    path('', views.register),
    path('register', views.add_new_user),
    path('log_in', views.log_in),
    path('success', views.success),
    path('delete', views.delete),
]