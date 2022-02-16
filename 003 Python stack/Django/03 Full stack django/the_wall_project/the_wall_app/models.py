from django.db import models

from login_registration_app.models import User

class UserManager1(models.Manager):
    def basic_validator1(self, postData):
        errors = {}
        # add keys and values to errors dictionary for each invalid field
        if len(postData['m_post']) < 10:
            errors["m_post"] = "Message should be at least 10 characters"
        return errors

class Message(models.Model):
    post=models.TextField()
    user = models.ForeignKey(User, related_name="messages", on_delete = models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = UserManager1()

class Comment(models.Model):
    comment=models.TextField()
    user = models.ForeignKey(User, related_name="comments", on_delete = models.CASCADE)
    message = models.ForeignKey(Message, related_name="comments_message", on_delete = models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = UserManager1()