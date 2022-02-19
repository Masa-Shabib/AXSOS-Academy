from django.db import models
from login_registration_app.models import User

class BookManager(models.Manager):
    def basic_validator1(self, postData):
        errors = {}
        # add keys and values to errors dictionary for each invalid field
        if len(postData['title']) < 1:
            errors["title"] = "Title is required"
        if len(postData['desc']) < 5:
            errors["m_post"] = "Descreption should be at least 5 characters"
        return errors


class Books(models.Model):
    title=models.CharField(max_length=90)
    desc=models.TextField()
    uploaded_by = models.ForeignKey(User, related_name="books_uploaded", on_delete = models.CASCADE)
    users_who_like = models.ManyToManyField(User, related_name="liked_books")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = BookManager()


# Create your models here.
