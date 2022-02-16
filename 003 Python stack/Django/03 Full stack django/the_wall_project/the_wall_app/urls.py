from django.urls import path     
from . import views
urlpatterns = [
    path('', views.main_wall),
    path('wall', views.wall),
    path('post_message', views.wall_message),
    path('post_comment', views.wall_comment),
    path('msg_delete', views.msg_delete),
]