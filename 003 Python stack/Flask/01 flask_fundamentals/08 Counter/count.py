from flask import Flask, render_template, request, redirect,session
app = Flask(__name__)
app.secret_key = 'keep it secret, keep it safe'

@app.route('/')
def counter():
    if not 'count' in session:
        session['count']=0
    else :
        session['count']+=1
    return render_template("index.html",count=session['count'],num=session['num'])
@app.route('/destroy_session')
def destroy():
    session.pop('count')
    session['num']=0
    return redirect('/')
@app.route('/add2')
def add2():
    session['count']+=1
    return redirect('/')
@app.route('/num',methods=['POST'])
def add():
    session['num']=int(request.form['num'])
    session['count']+=(session['num']-1)
    return redirect('/')




if __name__ == "__main__":
    app.run(debug=True)