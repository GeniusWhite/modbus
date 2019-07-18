function loadEventHistory(selectedDate, selectedDateEnd){

        var d = new Date(selectedDate.value);
    var d1 = new Date(selectedDateEnd.value);

        var y = d.getFullYear();
        var m = d.getMonth() + 1;
        var day = d.getDate();
        m = checkDate(m);
        day = checkDate(day);



    var y1 = d1.getFullYear();
    var m1 = d1.getMonth() + 1;
    var day1 = d1.getDate();
    m1 = checkDate(m1);
    day1 = checkDate(day1);

    function checkDate(i) {
        if (i < 10) {
            i = "0" + i;
        }
        return i;
    }

 let date = day + "." + m + "." + y+"/";
    let date1 = day1 + "." + m1 + "." + y1;

    console.log(date + date1);
    let request = new XMLHttpRequest();
        request.open('GET', 'http://192.168.40.100:8888/getEvents?date=' + date+date1, true);


        request.onload = function () {
            try {

                var data = JSON.parse(this.response);
            } catch (err) {

            }
            if (data.length <1) {

                var parameter = document.createElement("p");
                var node = document.createTextNode("pagaidam neka nava...");
                parameter.appendChild(node);

                var element = document.getElementById("history");
                element.appendChild(parameter);

            } else if (request.status >= 200 && request.status < 400) {
                data.reverse();


                var button = document.createElement('button');
                button.setAttribute('class', 'collapsible');
                button.setAttribute('onclick', 'expand()');
                button.innerHTML = date+date1;

                var div = document.createElement('div');
                div.setAttribute('class', 'content');



                var table = document.createElement("table");
                div.appendChild(table);

                var historyElement = document.getElementById("history");


                historyElement.appendChild(button);
                historyElement.appendChild(div);

                var header = table.createTHead();
                var headerRow = header.insertRow(0);

                var headerCell1 = headerRow.insertCell(0);
                var headerCell2 = headerRow.insertCell(1);
                var headerCell3 = headerRow.insertCell(2);
                var headerCell4 = headerRow.insertCell(3);
                var headerCell5 = headerRow.insertCell(4);
                var headerCell6 = headerRow.insertCell(5);

                var headerCell7 = headerRow.insertCell(6);
                var headerCell8 = headerRow.insertCell(7);
                var headerCell9 = headerRow.insertCell(8);
                var headerCell10 = headerRow.insertCell(9);
                var headerCell11 = headerRow.insertCell(10);
                var headerCell12 = headerRow.insertCell(11);

                headerCell1.innerHTML = "npk";
                headerCell2.innerHTML = "in datums";
                headerCell3.innerHTML = "in laiks";
                headerCell4.innerHTML = "info";


                for (i = 0; i < data.length; i++) {



                    var row = table.insertRow(1);
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
                    cell1.innerHTML = data[i].eventID;
                    cell2.innerHTML = data[i].eventDateString;
                    cell3.innerHTML = data[i].eventTimeString;
                    cell4.innerHTML = data[i].eventInfo;



                }
            }
        };

        request.send();


}