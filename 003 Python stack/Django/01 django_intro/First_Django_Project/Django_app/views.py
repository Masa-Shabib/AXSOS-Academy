from django.shortcuts import render, HttpResponse , redirect 
from django.http import JsonResponse
def root(request):
    return redirect("/blogs") 
def index(request):
    return JsonResponse({"response": "placeholder to later display a list of all blogs", "status": True})
def new(request):
    return HttpResponse("placeholder to display a new form to create a new blog")
def creat (request):
    return redirect("/")
def show(request,number):
    return HttpResponse(f"placeholder to display blog number: {number}")
def edit(request,number):
    return HttpResponse(f"placeholder to edit blog {number}")
def delete(request,number):
    return redirect("/blogs") 
# Create your views here.
