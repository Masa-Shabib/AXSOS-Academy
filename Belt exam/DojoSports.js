var sub = document.querySelector(".subs")
function hide(){
    sub.remove()
}
var result = [document.querySelector(".score"),document.querySelector(".score1")]
var sum = [314,159]
var count = 1;
function add(x){
    result[x].innerText = sum[x]+ count
    count++
}
function message(){
    alert("The Ninjas have Won")
}
setTimeout(message, 13000)