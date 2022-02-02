from flask import Flask, render_template
app= Flask(__name__)
@app.route("/")
def hello():
    return "Hello"
@app.route("/play")
def welcome():
    return render_template("index.html", i=3,color="#9fc5f8")
@app.route("/play/<int:num>")
def boxes(num):
    return render_template("index.html",i=num,color="#9fc5f8")
@app.route("/play/<int:num>/<coll>")
def boxescol(num,coll):
    return render_template("index.html",i=num, color = coll)



if __name__=="__main__":
    app.run(debug=True)