from django.shortcuts import render
from time import localtime, strftime
    
def index(request):
    context = {
        "time": strftime("%b %d, %Y %H:%M:%S %p", localtime())
    }
    print("time")
    return render(request,'index.html', context)


# Create your views here.
