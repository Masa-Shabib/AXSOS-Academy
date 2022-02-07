import random
from flask import Flask, render_template, request, redirect,session
app = Flask(__name__)
app.secret_key = 'keep it secret, keep it safe'

@app.route('/')
def gamer():
    print(session['random'] )
    return render_template("index.html",random = int(session['random']),num=int(session['num']), result=session['p'])
@app.route('/num', methods=['POST'])
def number():
    if session['random']==int(request.form['num']):
        session['p'] = str('was the number!')
        session['random']=random.randint(1, 100)
        session['num']=request.form['num']
        print(session['count'])
    
    elif session['random']>int(request.form['num']):
        session['p'] =str('Too Low!')
        if not 'count' in session:
            session['count']=0
        else :
            session['count']+=1
    
    else:
        session['p'] =str('Too High!')
        if not 'count' in session:
            session['count']=0
        else :
            session['count']+=1
    return redirect('/')
@app.route('/show')
def show():
    session['random']= random.randint(1, 100)
    return redirect('/')
@app.route('/correct')
def correct():
    session['p'] =str('again')
    session.pop('count')
    return redirect('/')


if __name__ == "__main__":
    app.run(debug=True)