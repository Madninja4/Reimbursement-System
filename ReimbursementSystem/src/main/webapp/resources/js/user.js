window.onload = function() {
	
	//I don't want to add an event listener because the page load IS THE EVENT
	//in your project 1, you'll be going to the server here to get the session data...because THAT is who
	// is currently logged in
	getUser()

}

const urlUser ="http://18.191.253.228:8090/ReimbursementSystem/api/ajax/currentUser";
const urlReimbs = "http://18.191.253.228:8090/ReimbursementSystem/api/ajax/currentUserGetReimbs";


let myUserInformation ={};

function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

function getUser() {
    fetch(urlUser)
         .then((res) => {  
                if (!res.ok) {
                    return res.json().then(e => Promise.reject(e))
                } else {
                      return res.json()
                }    
            }
          )
          .then(userJson => {
              //this is where we get the user object in json format.
              
              let usernameField = document.getElementById("username");
              usernameField.innerText = userJson.username;
              let emailField = document.getElementById("email");
              emailField.innerText = userJson.email;
              let firstnameField = document.getElementById("firstname");
              firstnameField.innerText = userJson.firstName;
              let lastnameField = document.getElementById("lastname");
              lastnameField.innerText = userJson.lastName;
              
			  getUserReimbs()
          })
}

function getUserReimbs() {
    fetch(urlReimbs)
         .then((res) => {  
                if (!res.ok) {
                    return res.json().then(e => Promise.reject(e))
                } else {
                      return res.json()
                }    
            }
          )
          .then(userJson => {
              //this is where we get the user object in json format.
              
              ourDOMManipulation(userJson);
          })
}
///submitting reimb
const btn = document.querySelector("#reimbSubmitButton");
btn.addEventListener("click",()=>{
    
    let radios = document.getElementsByName('typeid')
    for (var i = 0, length = radios.length; i < length; i++) {
        if (radios[i].checked) {
          // do whatever you want with the checked radio
          var typeId = radios[i].id;
      
          // only one radio can be logically checked, don't check the rest
          break;
        }
      }
    let description = document.getElementById("description").value;
    let amount = document.getElementById("amount").value;
    
    if (description == "" || amount == ""){
        alert("You need to input values for the reimbursement request to properly submit.")
    }
    else{
    fetch(`http://18.191.253.228:9123/ReimbursementSystem/api/ajax/submitReimb/send?amount=${amount}&description=${description}&typeId=${typeId}`).then((res)=>{getUserReimbs()})
    }
})


function ourDOMManipulation(ourJSON) {
	// document.getElementById("pokeName").innerText = ourJSON.name;
	// document.getElementById("pokedexNumber").innerText = ourJSON.id;
	// document.getElementById("pokeImage").setAttribute("src",
	// ourJSON.sprites.front_default);

    let newSelectionTwo = document.querySelector("#reimbTableBody");
    newSelectionTwo.innerHTML = "";
    for (let i = 0; i < ourJSON.length; i++) {
        
        let newTR = document.createElement("tr");
		let newTH = document.createElement("th");
		
		let newTD1 = document.createElement("td");
		let newTD2 = document.createElement("td");
		let newTD3 = document.createElement("td");
		let newTD4 = document.createElement("td");
		let newTD5 = document.createElement("td");
        let newTD6 = document.createElement("td");
        let newTD7 = document.createElement("td");
        let newTD8 = document.createElement("td");
        let newTD9 = document.createElement("td");
        let newTD10 = document.createElement("td");
		
		// population creations
		newTH.setAttribute("scope", "row")
		let myText1 = document.createTextNode(ourJSON[i].reimbId);
        let myText2 = document.createTextNode("$"+numberWithCommas(ourJSON[i].amount));
		let myText3 = document.createTextNode(ourJSON[i].submitted ? new Date(ourJSON[i].submitted).toLocaleString() : "empty");
		let myText4 = document.createTextNode(ourJSON[i].resolved ? new Date(ourJSON[i].resolved).toLocaleString() : "empty");
		let myText5 = document.createTextNode(ourJSON[i].description);
		let myText6 = document.createTextNode(ourJSON[i].receipt ? ourJSON[i].receipt : "empty");
		let myText7 = document.createTextNode(ourJSON[i].authorUsername);
        let myText8 = document.createTextNode(ourJSON[i].resolverUsername ? ourJSON[i].resolverUsername : "empty");
        let myText9 = document.createTextNode(ourJSON[i].status);
        let myText10 = document.createTextNode(ourJSON[i].type);
		
		
		///all appendings
		newTH.appendChild(myText1);
		newTD1.appendChild(myText2);
		newTD2.appendChild(myText3);
		newTD3.appendChild(myText4);
		newTD4.appendChild(myText5);
		newTD5.appendChild(myText6);
        newTD6.appendChild(myText7);
        newTD7.appendChild(myText8);
        newTD8.appendChild(myText9);
        newTD9.appendChild(myText10);
		
		newTR.appendChild(newTH);
		newTR.appendChild(newTD1);
		newTR.appendChild(newTD2);
		newTR.appendChild(newTD3);
		newTR.appendChild(newTD4);
		newTR.appendChild(newTD5);
        newTR.appendChild(newTD6);
        newTR.appendChild(newTD7);
        newTR.appendChild(newTD8);
        newTR.appendChild(newTD9);
		newSelectionTwo.appendChild(newTR);
    }

}
