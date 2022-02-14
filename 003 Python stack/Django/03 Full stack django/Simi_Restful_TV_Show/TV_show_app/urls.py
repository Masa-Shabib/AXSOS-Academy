from django.urls import path     
from . import views
urlpatterns = [
    path('show', views.show),
    path('show/new', views.new_show),
    path('show/addshow', views.addshow),
    path('show/<int:show_id>', views.display, name='show'),
    path('show/<int:show_id>/edit', views.edit, name='edit'),
    path('update/<int:show_id>', views.update),
    path('show/<int:show_id>/delete', views.delete),
    

]