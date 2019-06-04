function addVisitor(firstName, lastName, cardNumber, company, responsiblePerson, roomName){

    let token2 = document.getElementById('token').value;


var obj = { firstName: firstName.value, lastName: lastName.value, cardNumber: cardNumber.value, company: company.value, responsiblePerson: responsiblePerson.value, roomName:roomName.value };

var addVisitorRequest = new XMLHttpRequest();
addVisitorRequest.open('POST', 'http://192.168.40.100:8888/addVisitor',true);
addVisitorRequest.setRequestHeader("Content-Type", "application/json");
    addVisitorRequest.setRequestHeader('Authorization', token2);

var data = JSON.stringify(obj);

addVisitorRequest.send(data);

    addVisitorRequest.onload = function() {

        if (addVisitorRequest.status >= 200 && addVisitorRequest.status < 400) {
            console.log(addVisitorRequest.responseText);

            var newVisitor = JSON.parse(this.response);

        }

/*console.log(newVisitor.lastName);
var para = document.createElement("p");
    var node = document.createTextNode(newVisitor.orderNumber +" "+ newVisitor.inDateString + " "+ newVisitor.inTimeString+" "+ newVisitor.outDateString+" "+ newVisitor.outTimeString +" "+ newVisitor.firstName+" "+ newVisitor.lastName+" "+ newVisitor.cardNumber+" "+ newVisitor.company+" "+ newVisitor.responsiblePerson+" "+ newVisitor.roomName+" "+newVisitor.responsiblePersonIdentity);
    para.appendChild(node);
      var element = document.getElementById("test");
      element.appendChild(para);*/
        var table1 = document.getElementById("myTable");
        var row = table1.insertRow(-1);

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
        cell1.innerHTML = newVisitor.orderNumber;
        cell2.innerHTML = newVisitor.inDateString;
        cell3.innerHTML = newVisitor.inTimeString;
        cell4.innerHTML = newVisitor.outDateString;
        cell5.innerHTML = newVisitor.outTimeString;
        cell6.innerHTML = newVisitor.firstName;
        cell7.innerHTML = newVisitor.lastName;
        cell8.innerHTML = newVisitor.cardNumber;
        cell9.innerHTML = newVisitor.company;
        cell10.innerHTML = newVisitor.responsiblePerson;
        cell11.innerHTML = newVisitor.roomName;
        cell12.innerHTML = newVisitor.responsiblePersonIdentity;


};

 document.getElementById("addVisitorForm").style.display = "none";


}