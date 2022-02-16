
from .models import User, Message,Comment
from django.shortcuts import render, redirect ,HttpResponse
from django.contrib import messages

def main_wall(request):
    context = {
        "all_messages" : Message.objects.all().order_by("-created_at"),
        "comments" : Comment.objects.all(),
        }
    return render (request, 'main_wall.html',context)

def wall(request):
    context = {
        "all_messages" : Message.objects.all().order_by("-created_at"),
        "comments" : Comment.objects.all(),
        }
    return render (request, 'wall_message.html',context)

def wall_message(request):
    errors = Message.objects.basic_validator1(request.POST)
    if not 'user_id' in request.session:
        return HttpResponse ('<a href="/entry">login first</a>')
    else:
        if len(errors) > 0:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect('/wall')
        else:
            this_user=User.objects.get(id=request.session['user_id'])
            Message.objects.create(post=request.POST['m_post'],user=this_user)
            return redirect ('/wall')

def wall_comment(request):
    if not 'user_id' in request.session:
        return HttpResponse ('<a href="/entry">login first</a>')
    else:
        this_user=User.objects.get(id=request.session['user_id'])
        this_message=Message.objects.get(id=request.POST['m_id'])
        Comment.objects.create(comment=request.POST['comment'],user=this_user,message=this_message)
        return redirect ('/wall')

def msg_delete(request):
    this_message=Message.objects.get(id=request.POST['message_id'])
    print( type(request.session['user_id']))
    print(type (this_message.user.id))

    if str(this_message.user.id)== request.session['user_id']:
        print(this_message.post)
        this_message.delete()
        return redirect ('/wall')
    else :
        return redirect ('/wall')
