from django.shortcuts import render
    
def index(request):
    return render(request,'index.html')
def result(request):
    context = {
    	"name" : request.POST['name'],
    	"location" : request.POST['location'],
        "language" : request.POST['lang'],
        "jop" : request.POST['jop'],
        "exp" : request.POST['exp'],
        "comment" : request.POST['comment'],
    }
    return render(request,'show.html',context)


# Create your views here.
