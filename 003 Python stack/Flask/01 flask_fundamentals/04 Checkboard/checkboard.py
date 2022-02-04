import math
from flask import Flask, render_template
app= Flask(__name__)
@app.route("/")
def hello():
    return render_template("index.html", i = 4, x= 4,color1="red",color2="black")
@app.route("/<int:num>")
def num1(num):
    return render_template("index.html", i = 4, x =  int(num/2),color1="red",color2="black")
@app.route("/<int:num>/<int:num1>")
def num2(num,num1):
    return render_template("index.html", i =int(num/2), x = int(num1/2),color1="red",color2="black")
@app.route("/<int:num>/<int:num1>/<color1>/<color2>")
def color(num,num1,color1,color2):
    return render_template("index.html", i =int(num/2), x = int(num1/2),color1=color1,color2=color2)



if __name__=="__main__":
    app.run(debug=True)