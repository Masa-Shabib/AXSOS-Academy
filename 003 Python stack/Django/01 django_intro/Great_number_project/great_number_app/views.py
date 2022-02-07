from django.shortcuts import render, redirect
import random
def index(request):
    print(request.session['random'])
    return render(request,'index.html')
def number(request):
    if request.session['random']==int(request.POST['number']):
        request.session['p'] = str('was the number!')
        request.session['random']=random.randint(1, 100)
        request.session['num']=request.POST['number']
    elif request.session['random']>int(request.POST['number']):
        request.session['p'] =str('Too Low!')
    else:
        request.session['p'] =str('Too High!')
    return redirect('/')
def show(request):
    request.session['random']=random.randint(1, 100)
    return redirect('/')
def correct(request):
    request.session['p'] =str('again')
    return redirect('/')

