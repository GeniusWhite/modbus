
let div = document.createElement('div');
div.className = "alert";
if ('<#if response??>${response}</#if>'!= 0) {

div.innerHTML = '<#if response??>${response}</#if>';

document.body.appendChild(div);
setTimeout(() => div.remove(), 2000);
}

