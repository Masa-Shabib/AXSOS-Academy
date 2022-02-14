from django.shortcuts import render,redirect
from django.contrib import messages
from .models import Show


def show(request):
    context = {
        "all_shows": Show.objects.all()
    }
    return render(request,"show.html", context)

def new_show(request):
    return render(request,"new_show.html")

def addshow(request):
    errors = Show.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/show/new')
    else:
        this_show=Show.objects.create(title=request.POST['title'],network=request.POST['network'],release_date=request.POST['release_date'],desc=request.POST['desc'])
        x = this_show.id
        messages.success(request, "Show successfully creted")
        return redirect(f'/show/{x}')

def display(request,show_id):
    context = {
        "this_show": Show.objects.get(id=show_id)
    }
    return render(request,"this_show.html", context)

def edit(request,show_id):
    context = {
        "this_show": Show.objects.get(id=show_id)
    }
    return render(request,"edit_show.html", context)

def update(request,show_id):
    errors = Show.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect(f'/show/{show_id}/edit')
    else:
        this_show=Show.objects.get(id=show_id)
        this_show.title=request.POST['title']
        this_show.network=request.POST['network']
        this_show.release_date=request.POST['release_date']
        this_show.desc=request.POST['desc']
        this_show.save()
        messages.success(request, "Show successfully updated")
        return redirect(f'/show/{show_id}/edit')

def delete(request,show_id):
    this_show=Show.objects.get(id=show_id)
    this_show.delete()
    return redirect('/show')
# Create your views here.
