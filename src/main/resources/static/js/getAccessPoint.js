
console.log('start script');

let token = document.getElementById("token").value;



var accessPointRequest = new XMLHttpRequest();
accessPointRequest.open('GET', 'http://192.168.40.100:8888/getAccessPoint', true);
accessPointRequest.setRequestHeader('Authorization', token);
accessPointRequest.onload = function () {
try{
console.log('try block');
  // Begin accessing JSON data here
  var data = JSON.parse(this.response);
  console.log('after parsing');
  console.log(data);
  }catch(err){

  }
  if (data==null){

console.log('nava');
        }

  else if (accessPointRequest.status >= 200 && accessPointRequest.status < 400) {

     console.log(data.accessPoint);
     document.getElementById("accessPoint").innerHTML = data.accessPoint;

}
};
accessPointRequest.send();
