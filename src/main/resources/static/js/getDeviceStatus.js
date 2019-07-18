
let deviceStatusRequest = new XMLHttpRequest();
deviceStatusRequest.open('GET', 'http://192.168.40.100:8888/getDeviceStatus', true);

deviceStatusRequest.onload = function () {

    let data;
    try{

        data = JSON.parse(this.response);

    }catch(err){

    }
    if (data==null){


    }

    else if (deviceStatusRequest.status >= 200 && deviceStatusRequest.status < 400) {


        //document.getElementById("accessPoint").innerHTML = data.accessPoint;

    }
};
deviceStatusRequest.send();