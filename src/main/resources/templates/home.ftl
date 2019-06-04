<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Visitors App</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link href="css/style2.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/popupStyle.css" rel="stylesheet">


</head>

<body onload="startTime()">

<div class="icon-bar">
    <a class="active" href="#"><i class="fa fa-home"></i></a>
    <a href="#about"><i class="fa fa-search"></i></a>
    <a href="#" onclick="openAddVisitorForm()"><i class="fa fa-user-plus"></i></a>
    <a href="#" onclick="openWindow()"><i class="fa fa-user-times"></i></a>
    <a href="/"><i class="fa fa-sign-out"></i></a>
</div>

<div class="test">
    <span class="a" id="date"></span>
    <span class="b" id="accessPoint"></span>
    <span class="a" id="time"></span>
</div>
<script src="js/getAccessPoint.js"></script>
<script src="js/time.js"></script>


<div id="page1" style="overflow-x:auto;" class="page-padding">

<table id="myTable">
    <tr>
        <th>Nr.p.k.</th>
        <th>Ienākšanas datums</th>
        <th>Ienākšanas laiks</th>
        <th>Iziešanas datums</th>
        <th>Iziešanas laiks</th>
        <th>Vārds</th>
        <th>Uzvārds</th>
        <th>Caurlaides nr.</th>
        <th>Firma</th>
        <th>Atbildīga persona</th>
        <th>Telpas nr.</th>
        <th>Paraksts</th>
    </tr>

</table>
</div>

<div id="test"></div>

<div id="root"></div>

<script src="js/getVisitors.js"></script>



<div class="form-popup" id="myForm">
    <form id="addOutTime" class="form-container">
        <h2>Atzīmet uz iziešanu</h2>

       <input type="text" name="orderNumber", required="true", placeholder="Nr.p.k.">
            <input type="password" name="password", required="true", placeholder="Parole">
            <br>
        <span><button type="button" class="btn cancel" onclick="addOutTime()" >Ok</button></span>

            <span><button type="button" class="btn cancel" onclick="closeForm()">Close</button></span>
    </form>
</div>
<script src="js/addOutTime.js"></script>
<script src="js/openForm.js"></script>



<script src="js/addVisitor.js"></script>
<script src="js/checkForm.js"></script>


<br>

<div class="form-popup" id="addVisitorForm">
    <form class="form-container">
        <h2>Reģistrēt viesi</h2>

       <input type="text" name="firstName" onkeypress="checkForm(firstName)" placeholder="Vārds"/>
       <input type="text" name="lastName" onkeypress="checkLastName(lastName)" placeholder="Uzvārds"/>

        <input type="text" name="cardNumber" onkeypress="checkForm(cardNumber)" placeholder="Caurlaides nr."/>

        <input type="text" name="company" onkeypress="checkForm(company)" placeholder="Firma">
       <input type="text" name="responsiblePerson" onkeypress="checkForm(responsiblePerson)" placeholder="Atbildīga persona"/>
       <input type="text" name="roomName" onkeypress="checkForm(roomName)" placeholder="Telpas nr."/>


        <button type="button" class="btn cancel" onclick="addVisitor(firstName, lastName, cardNumber, company, responsiblePerson, roomName )">Ok</button>
        <button type="button" class="btn cancel" onclick="closeAddVisitorForm()">Close</button>

    </form>
</div>
<script src="js/openAddVisitorForm.js"></script>
<br>


<div id="page2" class="page-padding"">
    <a id="about" class="smooth"></a>
<div style="padding-top: 70px">
    <form class="form-container">
        <h2>Meklēt pēc datuma</h2>

        <input type="date" name="selectedDate", required="true">

        <br>
        <button type="button" class="btn cancel" onclick="loadHistory(selectedDate)">Ok</button>

        <button type="button" class="btn cancel" onclick="clearHistory()">Dzest</button>
    </form>
</div>
<div id="history"></div>
</div>
<script src="js/clearHistory.js"></script>
<script src="js/loadHistory.js"></script>

</body>

</html>