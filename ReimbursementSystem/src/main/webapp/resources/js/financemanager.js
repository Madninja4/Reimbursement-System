window.onload = function() {
	
	//I don't want to add an event listener because the page load IS THE EVENT
	//in your project 1, you'll be going to the server here to get the session data...because THAT is who
	// is currently logged in
	let allReimbursements ={};
	getUser()
}

const urlUser ="http://18.191.253.228:8090/ReimbursementSystem/api/ajax/currentUser";
const urlReimbs = "http://18.191.253.228:8090/ReimbursementSystem/api/ajax/allFinder";



function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}



function addName(){
	fetch(
	'http://18.191.253.228:8090/ReimbursementSystem/api/ajax/currentUser')
	.then(function(daResponse) {
		const convertedResponse = daResponse.json();
		return convertedResponse;
	}).then(function(daSecondResponse) {
		console.log(daSecondResponse);
		myUserInformation=daSecondResponse;
		ourDOMManipulation(myUserInformation);
	})

}
let filteredReimbursements = [];
function filterReimbs(filterType){
	
    switch(filterType) {
        case "None":
            return allReimbursements;
        case "Lodging":
            filteredReimbursements = allReimbursements.filter(Reimbursement =>{
                if(Reimbursement.type == "Lodging" || Reimbursement.status == "Lodging"){
                    return Reimbursement;
                }
            });
            return filteredReimbursements;
        case "Travel":
            filteredReimbursements = allReimbursements.filter(Reimbursement =>{
                if(Reimbursement.type == "Travel" || Reimbursement.status == "Travel"){
                    return Reimbursement;
                }
            });
            return filteredReimbursements;
        case "Food":
            filteredReimbursements = allReimbursements.filter(Reimbursement =>{
                if(Reimbursement.type == "Food"|| Reimbursement.status == "Food"){
                    return Reimbursement;
                }
            });
            return filteredReimbursements;
        case "Other":
            filteredReimbursements = allReimbursements.filter(Reimbursement =>{
                if(Reimbursement.type == "Other"|| Reimbursement.status == "Other"){
                    return Reimbursement;
                }
            });
            return filteredReimbursements;
        case "Pending":
            filteredReimbursements = allReimbursements.filter(Reimbursement =>{
                if(Reimbursement.type == "Pending" || Reimbursement.status == "Pending"){
                    return Reimbursement;
                }
            });
            return filteredReimbursements;
        case "Approved":
            filteredReimbursements = allReimbursements.filter(Reimbursement =>{
                if(Reimbursement.type == "Approved" || Reimbursement.status == "Approved"){
                    return Reimbursement;
                }
            });
            return filteredReimbursements;
        case "Denied":
            filteredReimbursements = allReimbursements.filter(Reimbursement =>{
                if(Reimbursement.type == "Denied" || Reimbursement.status == "Denied"){
                    return Reimbursement;
                }
            });
            return filteredReimbursements;
        default:
            return allReimbursements;


    }
}

const fbtn = document.querySelector("#filterButton");
fbtn.addEventListener("click",()=>{
    
    let e = document.getElementById("options");
    let filterType = e.value;
    
    let filtered = filterReimbs(filterType);
    
    ourDOMManipulation(filtered);
    allReimbs = document.getElementsByClassName("reimb");
    makeReimbsClickable();
    
})

const abtn = document.querySelector("#approveButton");
abtn.addEventListener("click",()=>{
  
    fetch(`http://18.191.253.228:9123/ReimbursementSystem/api/ajax/updateReimb/send?reimbId=${selectedReimb}&statusId=${2}`).then((res)=>{modal.style.display = "none"; getAllReimbs()})
})

const dbtn = document.querySelector("#denyButton");
dbtn.addEventListener("click",()=>{
    
    fetch(`http://18.191.253.228:9123/ReimbursementSystem/api/ajax/updateReimb/send?reimbId=${selectedReimb}&statusId=${3}`).then((res)=>{modal.style.display = "none"; getAllReimbs()})
})

let allReimbs = document.getElementsByClassName("reimb");
let selectedReimb = null;

function makeReimbsClickable(){
    allReimbs = document.getElementsByClassName("reimb");
    for (let reimb of allReimbs){
        reimb.addEventListener("click",()=>{
            selectedReimb = reimb.getElementsByTagName("th")[0].innerHTML;
            
            ourModuleManipulation(reimb);
            document.getElementById('selectionScreen').style.display='block';
        })
    }
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
              getAllReimbs();
          })
}
function getAllReimbs() {
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
              
              allReimbursements = userJson;
              ourDOMManipulation(userJson);
              allReimbs = document.getElementsByClassName("reimb");
              makeReimbsClickable();

          })
}



var modal = document.getElementById('selectionScreen');

//When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
 if (event.target == modal) {
     modal.style.display = "none";
 }
}

function ourModuleManipulation(ourJSON){
    let newSelectionThree = document.querySelector("#myReimbTableBody");
    newSelectionThree.innerHTML = "";
    let copyJSON = ourJSON.cloneNode(true);
    newSelectionThree.appendChild(copyJSON);
    // let newSelectionTwo = document.querySelector("#reimbTableBody");
    // let copyJSON = ourJSON.cloneNode(true);
    // newSelectionTwo.appendChild(copyJSON);

}

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
       
        newTR.setAttribute("id","entry"+i)
        let newTD1 = document.createElement("td");
		let newTD2 = document.createElement("td");
		let newTD3 = document.createElement("td");
		let newTD4 = document.createElement("td");
		let newTD5 = document.createElement("td");
        let newTD6 = document.createElement("td");
        let newTD7 = document.createElement("td");
        let newTD8 = document.createElement("td");
        let newTD9 = document.createElement("td");
		
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
		if (ourJSON[i].statusId == 1){
            newTR.setAttribute("class","reimb");
        }
		
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
