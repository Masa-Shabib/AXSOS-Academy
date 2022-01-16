var count = [0,0,0];
var lcount = [
    document.querySelector("#likes1"),
    document.querySelector("#likes2"),
    document.querySelector("#likes3")]
function increase(id){
    count[id]++
    lcount[id].innerText= count[id] +"like(s)" 
}



