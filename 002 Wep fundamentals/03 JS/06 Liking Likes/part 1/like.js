var count = 0;
var lcount = document.querySelector("#likes");
function increase(){
    count++;
    lcount.innerText = count + "Like(s)"
}