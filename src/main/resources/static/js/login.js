function login(username, password){
let token;
let a = username.value;
let b = password.value;

console.log(a);
console.log(b);

let obj = { username: a, password: b };




let loginRequest = new XMLHttpRequest();
    loginRequest.open('POST', 'http://192.168.40.100:8888/login',true);
    loginRequest.setRequestHeader("Content-Type", "application/json");
    loginRequest.setRequestHeader('Authorization', username.value);

    loginRequest.setRequestHeader('Authorization', password.value);
//let data = JSON.stringify(obj);

    loginRequest.send();

   loginRequest.onload = function () {
        try {
            let data = JSON.parse(this.response);

        let token = data.token ;
        let url = data.homeUrl;
        console.log(url+'?token='+token);
window.location = url+'?token='+token;


        }catch(err){
        }


    };



}