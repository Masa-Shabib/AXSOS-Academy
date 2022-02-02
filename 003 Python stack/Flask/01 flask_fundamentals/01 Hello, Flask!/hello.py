from flask import Flask , render_template
app= Flask(__name__)
@app.route("/")
def hello():
    return render_template("index.html", phrase="hello", times=5)
@app.route('/hello/<name>')
def hello1(name):
    print(name)
    return "Hello "+ name

@app.route('/users/<username>/<id>') # for a route '/users/____/____', two parameters in the url get passed as username and id
def show_user_profile(username, id):
    print(username)
    print(id)
    return "username: " + username + ", id: " + id


if __name__=="__main__":
    app.run(debug=True)