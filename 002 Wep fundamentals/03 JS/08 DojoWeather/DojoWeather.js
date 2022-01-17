var city =[document.querySelector(".B"),document.querySelector(".C"),document.querySelector(".D")]
function alert1(x){
    alert("Loading"+" "+city[x].innerText +" "+ "weather report..." )
}
var msg = document.querySelector("footer");
function hide(){
    msg.remove();
}
var cel1 =[
document.querySelector("#C1"),
document.querySelector("#C2"), 
document.querySelector("#C3"),
document.querySelector("#C4"),
document.querySelector("#C5"),
document.querySelector("#C6"),
document.querySelector("#C7"),
document.querySelector("#C8")
];
function convert(){
    for(var i = 0; i < cel1.length; i++){
        var feh = (cel1[i].innerText * 1.8 +32)
        cel1[i].innerText = feh.toFixed(2)
    }
}