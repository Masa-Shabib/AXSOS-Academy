var displayDiv = document.querySelector("#display");
var oprtype = "";
var values = {prev:null , new:null};
var lastenternum = false;

function press(num){
    if(lastenternum){
        var newnum ;
        if(values.new){
            newnum= values.new +'' +num;
            values.new = newnum
            displayDiv.innerText =newnum
        }
        else{
            newnum = values.prev +'' +num;
            values.prev= newnum
            displayDiv.innerText =newnum
        }
    }
    else{
        displayDiv.innerText = num
        if(values.prev){
            values.new = num;
        }
        else{
            values.prev = num;
        }
        lastenternum= true;
    }
}

function setOP(op){
    console.log(values)
    oprtype = op;
    lastenternum = false;
}

function calculate(){
    if(!values.new){
        return;
    }
    if (values.new && values.prev && oprtype){

        if(oprtype == "+"){
            var newvalue =Number(values.prev) + Number(values.new)
            displayDiv.innerText = newvalue
            values.prev= newvalue
        }
        if(oprtype == "*"){
            var newvalue = Number(values.prev) * Number(values.new)
            displayDiv.innerText = newvalue
            values.prev= newvalue
        }
        if(oprtype == "/"){
            newvalue = Number(values.prev) / Number(values.new)
            displayDiv.innerText =newvalue
            values.prev= newvalue
        }
        if(oprtype == "-"){
            newvalue = Number(values.prev) - Number(values.new)
            displayDiv.innerText =newvalue
            values.prev= newvalue
        }
        lastenternum = false;
    }
}
function clr(){
    values = {prev:null , new:null};
    displayDiv.innerText =0
}
