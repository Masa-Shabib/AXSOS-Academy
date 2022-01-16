var count = [0,0,0];
var lcount = [
    document.querySelector("#likes1"),
    document.querySelector("#likes2"),
    document.querySelector("#likes3")]
function increase(x){
    count[x]++
    lcount[x].innerText= count[x] +" Like(s)" 
}



