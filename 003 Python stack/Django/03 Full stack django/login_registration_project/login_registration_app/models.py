from django.db import models
import re
from datetime import datetime


class UserManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        # add keys and values to errors dictionary for each invalid field
        if len(postData['first_name']) < 2:
            errors["first_name"] = "first_name should be at least 2 characters"
        name_REGEX = re.compile(r'^[a-zA-Z]+$')
        if not name_REGEX.match(postData['first_name']):               
            errors['first_name'] = "first_name should be letters only"
        if len(postData['last_name']) < 2:
            errors["last_name"] = "last_name should be at least 2 characters"
        if not name_REGEX.match(postData['last_name']):               
            errors['last_name'] = "last_name should be letters only"
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if not EMAIL_REGEX.match(postData['email']):    # test whether a field matches the pattern            
            errors['email'] = "Invalid email address!"
        if len(postData['password']) < 8 :
            errors["password"] = "password should be at least 8 characters"
        if  postData['password'] != postData['password_con']:
            errors["password"] = "Password dose not match confirm PW"
        if  postData['birthday'] > str(datetime.now()) :
            errors["birthday"] = "Birthday should be in the past"
        if  postData['birthday'] > str(datetime(2011,1,1)):
            errors["age"] = "Users should be at least 13 years old"
        return errors


class User(models.Model):
    first_name=models.CharField(max_length=255)
    last_name=models.CharField(max_length=255)
    email=models.CharField(max_length=255)
    password=models.CharField(max_length=255)
    birthday=models.DateField(null=True)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects = UserManager()

# Create your models here.
