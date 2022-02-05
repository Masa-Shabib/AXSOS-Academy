from flask import Flask, render_template, request
app = Flask(__name__)
# our index route will handle rendering our form
@app.route('/')
def index():
    return render_template("index.html")

@app.route('/result', methods=['POST'])
def create_user():
    print(request.form['location'])
    return render_template("show.html", name=request.form['name'],location =request.form['location'],
    language =request.form['lang'],comment =request.form['comment'],jop=request.form['jop'],exp=request.form['exp'])

if __name__ == "__main__":
    app.run(debug=True)