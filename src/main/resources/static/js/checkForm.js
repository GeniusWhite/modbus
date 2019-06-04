function checkForm(firstName){

    let name = firstName;

    console.log(name.value);

    console.log(name.value.length);

    if ( name.value.length < 2){

        console.log("neder");
    }
}

function checkLastName(lastName){

    let name = lastName;

    console.log(name.value);

    console.log(name.value.length);

    if ( name.value.length < 4){

        console.log("neder lastName");
    }
}