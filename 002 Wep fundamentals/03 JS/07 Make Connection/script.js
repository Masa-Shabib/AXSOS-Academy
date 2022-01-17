console.log("page loaded...");
var newname = document.querySelector(".myname");
function edit(){
    var name1 = person = prompt("Please enter your name");
    newname.innerText = name1;
}
var count = 2;
var lcount = document.querySelector(".badge");
var hidden = [document.querySelector(".card-list-item"),document.querySelector(".card-list-item0")]
function hideD(x){
    hidden[x].remove();
    count--;
    lcount.innerText = count 
}
var count1 = 500;
var lcount1 = document.querySelector(".badge1");
function hideI(x){
    hidden[x].remove();
    count--;
    lcount.innerText = count 
    count1++;
    lcount1.innerText = count1 
}



