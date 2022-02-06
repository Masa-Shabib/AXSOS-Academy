from random import random
from flask import Flask, render_template, request, redirect,session
app = Flask(__name__)
app.secret_key = 'keep it secret, keep it safe'

@app.route('/')
def gamer():
    import random
    session['random']= random.randint(1, 100) 	
    print(session['random'] )
    return render_template("index.html",random = int(session['random']),num=int(session['num']))
@app.route('/num', methods=['POST'])
def number():
    session['num']=int(request.form['num'])
    # print(session['num'])
    return redirect('/')
@app.route('/show')
def show():
    return redirect('/')

# @app.route('/destroy_session')
# def destroy():
#     session.pop('count')
#     session['num']=0
#     return redirect('/')


if __name__ == "__main__":
    app.run(debug=True)