from django.shortcuts import render, redirect
    
def index(request):
    if not 'count' in request.session:
        request.session['count']=0
    else :
        request.session['count']+=1
    return render(request,'index.html')
def destroy(request):
    del request.session['count']
    request.session['num']=0
    return redirect('/')
def add2(request):
    request.session['count']+=1
    return redirect('/')
def add(request):
    request.session['num']=int(request.POST['num'])
    request.session['count']+=(request.session['num']-1)
    return redirect('/')
# Create your views here.
