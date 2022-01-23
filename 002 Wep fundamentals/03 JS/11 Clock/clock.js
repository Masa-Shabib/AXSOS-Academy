
var hr = document.querySelector('#hour');
var mn = document.querySelector('#minutes');
var sc = document.querySelector('#seconds');

function clock(){
    var date= new Date();
    console.log(date);
    var hh = date.getHours();
    console.log(hh);
    var mm = date.getMinutes();
    var ss = date.getSeconds();
    sc.style.transform = "rotate(" + (ss/60)*360 + "deg)"
    mn.style.transform = "rotate(" + (mm/60)*360 + "deg)"
    hr.style.transform = "rotate(" + hh*30 + "deg)"
}

setInterval(clock,1000);
clock();