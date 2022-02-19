from .models import User, Books
from django.shortcuts import render, redirect,HttpResponse
from django.contrib import messages

def book (request):
    this_user= User.objects.get(id= request.session['user_id'])
    context = {
        "all_books" : Books.objects.all().order_by("-created_at"),
        "like_by_user" : this_user.liked_books.all()
        }
    return render (request, 'book.html', context)

def new_book (request):
    errors = Books.objects.basic_validator1(request.POST)
    if not 'user_id' in request.session:
        return HttpResponse ('<a href="/entry">login first</a>')
    else:
        if len(errors) > 0:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect('/books')
        else:
            this_user=User.objects.get(id=request.session['user_id'])
            this_book=Books.objects.create(title=request.POST['title'],desc=request.POST['desc'],uploaded_by=this_user)
            this_book.users_who_like.add(this_user)
            return redirect ('/books')

def this_book (request,book_id):
    this_book=Books.objects.get(id=book_id)
    context = {
        "this_book" : Books.objects.get(id=book_id),
        "liked_by" :this_book.users_who_like.all(),
        "uploded_by" :this_book.uploaded_by.id,
        "this_user" :User.objects.get(id=request.session['user_id']),
        }
    print(this_book.users_who_like.all())
    return render (request, 'this_book.html', context)

def update_book (request,book_id):
    errors = Books.objects.basic_validator1(request.POST)
    if not 'user_id' in request.session:
        return HttpResponse ('<a href="/entry">login first</a>')
    else:
        if len(errors) > 0:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect(f'/books/{book_id}')
        else:
            this_book=Books.objects.get(id=book_id)
            this_book.title=request.POST['title']
            this_book.desc=request.POST['desc']
            this_book.save()
            return redirect (f'/books/{book_id}')

def delete_book (request,book_id): 
    this_book=Books.objects.get(id=book_id)
    this_book.delete()
    return redirect ('/books')

def add_fav (request,book_id):
    this_book=Books.objects.get(id=book_id)
    this_user=User.objects.get(id=request.session['user_id'])
    this_book.users_who_like.add(this_user)
    return redirect (f'/books/{book_id}')

def unfav (request,book_id):
    this_book=Books.objects.get(id=book_id)
    this_user=User.objects.get(id=request.session['user_id'])
    this_book.users_who_like.remove(this_user)
    return redirect (f'/books/{book_id}')

def user (request):
    this_user=User.objects.get(id=request.session['user_id'])
    context = {
        "like_by_user" : this_user.liked_books.all()
        }
    return render (request, 'user.html', context)

# Create your views here.
