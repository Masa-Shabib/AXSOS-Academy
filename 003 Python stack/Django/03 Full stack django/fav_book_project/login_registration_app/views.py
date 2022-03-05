from importlib.resources import contents
from msilib import gen_uuid
from multiprocessing import context
from django.shortcuts import render,redirect
from .models import User
import bcrypt
from django.contrib import messages
def register(request):
    return render (request, 'index.html')

def add_new_user (request):
    errors = User.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/')
    else:
        user = User.objects.filter(email=request.POST['email'])
        
        if user:
            request.session['error2']=str('Email already exists')
            return redirect('/')
        else:
            password = request.POST['password']
            pw_hash = bcrypt.hashpw(password.encode(), bcrypt.gensalt()).decode()
            new_user = User.objects.create(first_name=request.POST['first_name'],last_name=request.POST['last_name'],
            email=request.POST['email'],password=pw_hash)
            messages.success(request, "User successfully craeted")
            request.session['name']=str(f'Success! Welcome!, {new_user.first_name}!')
            return redirect('/')

def log_in(request):
    user = User.objects.filter(email=request.POST['email'])
    if user: 
        logged_user = user[0] 
        if bcrypt.checkpw(request.POST['password'].encode(), logged_user.password.encode()):
            request.session['userid'] = logged_user.id
            request.session['name']=str(f'Success! Welcome!, {logged_user.first_name}!')
            request.session['first_name']=str(f'{logged_user.first_name}')
            request.session['user_id']=logged_user.id
            # del request.session['error2']
            # del request.session['error1']
            return redirect('/books')
        else:
            request.session['error1']=str('Wrong password')
            print('wrong password')
            return redirect('/')
    else:
        request.session['error1']=str('Register first')
        print('register first')
        return redirect('/')

def delete(request):
    del request.session['name']
    del request.session['first_name']
    del request.session['user_id']
    if 'error2' in request.session:
        del request.session['error2']
    if 'error1' in request.session:
        del request.session['error1']
    return redirect('/')
# Create your views here.
