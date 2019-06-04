function startTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    // add a zero in front of numbers<10
    m = checkTime(m);
    s = checkTime(s);
    document.getElementById("time").innerHTML = h + ":" + m + ":" + s;
    var t = setTimeout(function(){ startTime() }, 500);



    var d = new Date();
    var y = d.getFullYear();
    var month = d.getMonth() + 1;
    var day = d.getDate();
    month = checkDate(month);
    day = checkDate(day);

    document.getElementById("date").innerHTML = day+"."+month+"."+y;

}

function checkDate(i) {
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}








function checkTime(i) {
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}