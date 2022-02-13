from django.shortcuts import render, redirect
from .models import Book , Author

def index(request):
    return render(request,"index.html")

def goto(request):
    if request.POST['which_form'] == 'Books':
        return redirect("/book")
    else:
        return redirect("/author")
def book(request):
    context = {
        "Books": Book.objects.all(),
        "Authors": Author.objects.all()
    }
    return render(request, "indexbook.html", context)

def add_book(request):
    Book.objects.create(title=request.POST['title'],desc=request.POST['desc'])
    return redirect("/book")

def show_book(request,book_id):
    bookk=Book.objects.get(id=book_id)
    request.session['bookid']=book_id
    context = {
        "Books": Book.objects.get(id=book_id),
        "Authors": Author.objects.filter(books=bookk),
        "all_Authors": Author.objects.exclude(books=bookk)
    }
    return render(request,"show_book.html", context)

def addauthor(request):
    author_id =request.POST['author_name']
    book_id = request.session['bookid']
    new_author=Author.objects.get(id=author_id)
    bookk=Book.objects.get(id=request.session['bookid'])
    bookk.authors.add(new_author)
    return redirect("/book/" + str(book_id))

def author(request):
    context = {
        "Books": Book.objects.all(),
        "Authors": Author.objects.all()
    }
    return render(request, "indexauthor.html", context)

def add_author(request):
    Author.objects.create(first_name=request.POST['first_name'],last_name=request.POST['last_name'],notes=request.POST['note'])
    return redirect("/author")

def show_author(request,author_id):
    authorr=Author.objects.get(id=author_id)
    request.session['authorid']=author_id
    context = {
        "Books": Book.objects.filter(authors=authorr),
        "Authors":Author.objects.get(id=author_id) ,
        "all_Books": Book.objects.exclude(authors=authorr)
    }
    return render(request,"show_author.html", context)

def addbook(request):
    book_id =request.POST['book_name']
    author_id = request.session['authorid']
    new_book=Book.objects.get(id=book_id)
    authorr=Author.objects.get(id=request.session['authorid'])
    authorr.books.add(new_book)
    return redirect("/author/" + str(author_id))
# Create your views here.
