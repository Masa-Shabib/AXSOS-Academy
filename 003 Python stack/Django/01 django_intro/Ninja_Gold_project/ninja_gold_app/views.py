from ssl import AlertDescription
from django.shortcuts import render, redirect
import random
from time import localtime, strftime
def index(request):
    if not 'gold' in request.session:
            request.session['gold']=0
    if not 'result' in request.session:
            request.session['result']= ""
    return render(request, 'index.html')

def process(request):
    request.session['time']=strftime("%Y/%m/%d  %H:%M %p", localtime())
    if request.POST['which_form'] == 'farm':
        x=[1,1]
        request.session['num']=random.randint(10,20)*random.choice(x)
        request.session['gold']+=request.session['num']
        request.session['result']+=f"Earned {request.session['num']} golds from the farm! {request.session['time']}\r"
    elif request.POST['which_form'] == 'cave':
        request.session['place']=request.POST['which_form']
        x=[1,1]
        request.session['num']=random.randint(5,10)*random.choice(x)
        request.session['gold']+=request.session['num']
        request.session['result']+=f"Earned {request.session['num']} golds from the cave! {request.session['time']}\r"
    elif request.POST['which_form'] == 'house':
        x=[1,1]
        request.session['num']=random.randint(2,5)*random.choice(x)
        request.session['gold']+=request.session['num']
        request.session['result']+=f"Earned {request.session['num']} golds from the house! {request.session['time']}\r"
    else:
        x=[-1,1]
        request.session['num']=random.randint(0,50)*random.choice(x)
        request.session['gold']+=request.session['num']
        if request.session['num'] > 0:
            request.session['result']+=f"Enterae a casino and earned {request.session['num']} golds {request.session['time']}\r"
        else:
            request.session['result']+=f"Enterae a casino and lost {request.session['num']} golds...Ouch!!...{request.session['time']}\r"
    return redirect('/')
def destroy(request):
    request.session['gold']=0
    del request.session['num']
    del request.session['result']
    return redirect('/')

