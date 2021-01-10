
console.log("I did it! It linked correctly.")
window.onload = function() {
	
	//I don't want to add an event listener because the page load IS THE EVENT
	//in your project 1, you'll be going to the server here to get the session data...because THAT is who
	// is currently logged in
	getAllUsers();
}

let myUserInformation ={};

function getAllUsers() {
	fetch(
			'http://18.191.253.228:8090/ReimbursementSystem/api/ajax/allUsers')
			.then(function(daResponse) {
				const convertedResponse = daResponse.json();
				return convertedResponse;
			}).then(function(daSecondResponse) {
				console.log(daSecondResponse);
				myUserInformation=daSecondResponse;
				ourDOMManipulation(myUserInformation);
			})
}

function ourDOMManipulation(ourJSON) {
	// document.getElementById("pokeName").innerText = ourJSON.name;
	// document.getElementById("pokedexNumber").innerText = ourJSON.id;
	// document.getElementById("pokeImage").setAttribute("src",
	// ourJSON.sprites.front_default);

	for (let i = 0; i < ourJSON.length; i++) {

		// ///////////CREATE ELEMENTS DYNAMICALLY//////////////
		// step1: creating our new element
		let newDiv = document.createElement("li");

		// step3: create a text node, then append to our new div element
		let divText = document.createTextNode("UserName: "+ourJSON[i].username+", "+ourJSON[i].email);
		newDiv.appendChild(divText);

		// step4: appending our new div element onto an existing element that is
		// currently being displayed
		let newSelection = document.querySelector("#myUserList");
		newSelection.appendChild(newDiv);

		console.log(newDiv);
		///////////////table time
	    
	 // ///////////CREATE ELEMENTS DYNAMICALLY//////////////
		// all creations
		let newTR = document.createElement("tr");
		let newTH = document.createElement("th");
		
		let newTD1 = document.createElement("td");
		let newTD2 = document.createElement("td");
		let newTD3 = document.createElement("td");
		let newTD4 = document.createElement("td");
		let newTD5 = document.createElement("td");
		let newTD6 = document.createElement("td");
		
		// population creations
		newTH.setAttribute("scope", "row")
		let myText1 = document.createTextNode(ourJSON[i].userId);
		let myText2 = document.createTextNode(ourJSON[i].username);
		let myText3 = document.createTextNode(ourJSON[i].password);
		let myText4 = document.createTextNode(ourJSON[i].firstName);
		let myText5 = document.createTextNode(ourJSON[i].lastName);
		let myText6 = document.createTextNode(ourJSON[i].email);
		let myText7 = document.createTextNode(ourJSON[i].userRoleId);
		newDiv.appendChild(divText);
		
		
		///all appendings
		newTH.appendChild(myText1);
		newTD1.appendChild(myText2);
		newTD2.appendChild(myText3);
		newTD3.appendChild(myText4);
		newTD4.appendChild(myText5);
		newTD5.appendChild(myText6);
		newTD6.appendChild(myText7);
		
		newTR.appendChild(newTH);
		newTR.appendChild(newTD1);
		newTR.appendChild(newTD2);
		newTR.appendChild(newTD3);
		newTR.appendChild(newTD4);
		newTR.appendChild(newTD5);
		newTR.appendChild(newTD6);
		let newSelectionTwo = document.querySelector("#userTableBody");
		newSelectionTwo.appendChild(newTR);

		//additional note: consider pagination
		// my endpoint:
		//			website.net?startpagination=21&endpagination=40
		//			OR
		//			website.net?pagination=3
	}
}