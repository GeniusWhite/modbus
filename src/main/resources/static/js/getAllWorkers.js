var app = document.getElementById('root');


var container = document.createElement('div');
container.setAttribute('class', 'container');

//app.appendChild(logo);
app.appendChild(container);

var d = new Date();

var y = d.getFullYear();
var m = d.getMonth()+1;
var day = d.getDate();
m = checkDate(m);
day = checkDate(day);

function checkDate(i) {
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}

var date = day+"."+m+"."+y;



var request = new XMLHttpRequest();
request.open('GET', 'http://192.168.40.100:8888/getWorkers', true);


request.send();


request.onload = function () {
try{
  // Begin accessing JSON data here
  var data = JSON.parse(this.response);
  }catch(err){

  }
  if (data==null){


      var para = document.createElement("p");
      var node = document.createTextNode("pagaidam neka nava...");
      para.appendChild(node);
      var element = document.getElementById("root");
      element.appendChild(para);
        }

  else if (request.status >= 200 && request.status < 400) {
    data.reverse();
    for(i=0; i<data.length; i++){


          var table = document.getElementById("myTable");
          var row = table.insertRow(1);
          var cell1 = row.insertCell(0);
          var cell2 = row.insertCell(1);
          var cell3 = row.insertCell(2);
          var cell4 = row.insertCell(3);
          var cell5 = row.insertCell(4);
          var cell6 = row.insertCell(5);
        var cell7 = row.insertCell(6);

          cell1.innerHTML = data[i].workerID;
          cell2.innerHTML = data[i].firstName;
          cell3.innerHTML = data[i].lastName;
        cell4.innerHTML = data[i].keyString;
        cell5.innerHTML = data[i].keyLifeStart;
        cell6.innerHTML = data[i].keyLifeEnd;

        }
  }
};



