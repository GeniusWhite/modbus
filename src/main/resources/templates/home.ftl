<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Access App</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link href="css/style2.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/popupStyle.css" rel="stylesheet">


</head>

<body onload="startTime()">

<div class="icon-bar">
    <a class="active" href="#"><i class="fa fa-home"></i></a>

   <#-- <a href="#" onclick="openAddVisitorForm()"><i class="fa fa-user-plus"></i></a>
    <a href="#" onclick="openWindow()"><i class="fa fa-user-times"></i></a>-->
    <a href="#users"><i class="fa fa-users"></i></a>
    <a href="#page3"><i class="fa fa-search"></i></a>
    <a href="#config"><i class="fa fa-wrench"></i></a>

    <a href="/"><i class="fa fa-sign-out"></i></a>
</div>

<div class="test">
    <span class="a" id="date"></span>

    <span class="a" id="time"></span>
</div>
<script src="js/getDeviceStatus.js"></script>
<script src="js/time.js"></script>


<div id="page1"  class="page-padding">


</div>





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


<script src="js/openAddVisitorForm.js"></script>

<div id="page2" class="page-padding">
    <a id="users" class="smooth"></a>
  <#--  <button onclick="openAddVisitorForm()"><i class="fa fa-user-plus fa-4x"></i></button>-->
    <p onclick="openAddVisitorForm()">Jauns lietotajs...</p>
    <table id="myTable">
        <tr>
            <th>Nr.p.k.</th>
            <th>Vārds</th>
            <th>Uzvārds</th>
            <th>Caurlaides nr.</th>
            <th>no</th>
            <th>lidz</th>
            <th>darbibas</th>

        </tr>

       <#-- <tr>
            <td>1.</td>
            <td>Janus</td>
            <td>Rudzik</td>
            <td>4567</td>
            <td>---</td>
            <td>---</td>
            <td> <span onclick="openAddVisitorForm()" style="cursor: pointer">edit</span>
               <span onclick="openAddVisitorForm()" style="cursor: pointer">delete</span>
            </td>



        </tr>-->
    </table>









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
</div>

<div id="page3" class="page-padding">



    <form class="form-container">
        <h2>Notikumi</h2>

        <input type="date" name="selectedDate", required="true">
        <input type="date" name="selectedDateEnd", required="true">
        <br>
        <button type="button" class="btn cancel" onclick="loadEventHistory(selectedDate, selectedDateEnd)">Ok</button>

        <button type="button" class="btn cancel" onclick="clearHistory()">Dzest</button>
    </form>

        <div id="history">

</div>
</div>

<script src="js/clearHistory.js"></script>
<script src="js/loadEventHistory.js"></script>
<script src="js/collapse.js"></script>




<div id="page4" class="page-padding">
    <a id="config" class="smooth"></a>
</div>

</body>

</html>