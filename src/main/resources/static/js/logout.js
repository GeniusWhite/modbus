function logout(){

    var logoutRequest = new XMLHttpRequest();
    logoutRequest.open('GET', 'http://192.168.40.100:8888', true);



    logoutRequest.send();
}