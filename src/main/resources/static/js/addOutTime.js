function addOutTime(){
    let token3 = document.getElementById('token').value;
var a = document.forms["addOutTime"]["orderNumber"].value;
var b = document.forms["addOutTime"]["password"].value;

console.log(a);
console.log(b);

var obj = { orderNumber: a, password: b };

var addOutTimeRequest = new XMLHttpRequest();
    addOutTimeRequest.open('POST', 'http://192.168.40.100:8888/addVisitorOutTime','charset=utf-8', true);
    addOutTimeRequest.setRequestHeader("Content-Type", "application/json");
    addOutTimeRequest.setRequestHeader('Authorization', token3);


var data = JSON.stringify(obj);

    addOutTimeRequest.send(data);


    addOutTimeRequest.onload= function() {
        if (this.status < 400 && this.status >= 200) {
            console.log(addOutTimeRequest.responseText);
            var parsedData = JSON.parse(this.response);
            alert("Uzredzesanos");
        }

    var table1 = document.getElementById("myTable");
    var row1 = table1.deleteRow(parsedData.orderNumber);
    var row = table1.insertRow(parsedData.orderNumber);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);
    var cell6 = row.insertCell(5);
    var cell7 = row.insertCell(6);
    var cell8 = row.insertCell(7);
    var cell9 = row.insertCell(8);
    var cell10 = row.insertCell(9);
    var cell11 = row.insertCell(10);
    var cell12 = row.insertCell(11);
        cell1.innerHTML = parsedData.orderNumber;
        cell2.innerHTML = parsedData.inDateString;
        cell3.innerHTML = parsedData.inTimeString;
        cell4.innerHTML = parsedData.outDateString;
        cell5.innerHTML = parsedData.outTimeString;
        cell6.innerHTML = parsedData.firstName;
        cell7.innerHTML = parsedData.lastName;
        cell8.innerHTML = parsedData.cardNumber;
        cell9.innerHTML = parsedData.company;
        cell10.innerHTML = parsedData.responsiblePerson;
        cell11.innerHTML = parsedData.roomName;
        cell12.innerHTML = parsedData.responsiblePersonIdentity;

    };
 document.getElementById("myForm").style.display = "none";


}