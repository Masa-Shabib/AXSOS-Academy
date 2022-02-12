from django.shortcuts import render, redirect
from .models import Dojos, Ninjas
def index(request):
    context = {
        "dojos": Dojos.objects.all(),
        "ninjas": Ninjas.objects.all()
    }
    return render(request, "index.html", context)
def result(request):
    newly_dojo = Dojos(name=request.POST['name'],city=request.POST['city'],state=request.POST['state'],desc="New dojo")
    newly_dojo.save()
    return redirect("/")
def result1(request):
    Ninjas.objects.create(first_name=request.POST['first_name'],last_name=request.POST['last_name'],dojo=Dojos.objects.get(name=request.POST['dojo_name']))
    return redirect("/")

# Create your views here.
