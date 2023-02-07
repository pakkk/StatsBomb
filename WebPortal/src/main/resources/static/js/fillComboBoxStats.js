import {getAllEndPoint, getEndPoint} from "./query.js";

const selectCompetitions = document.getElementById("selectCompetitions");
const selectMatches = document.getElementById("selectMatches");
const selectEndPoint = document.getElementById("endpoints");
const button = document.getElementById("submit");

selectCompetitions.addEventListener("change", fillComboBoxStats)
selectMatches.addEventListener("change", fillComboBoxStats)

async function fillComboBoxStats() {


    if (selectMatches.value !== "0" || selectCompetitions.value !== "0") {

        if (selectMatches.value === "0" && selectCompetitions.value !== "0") { // Si todos están deseleccionados y competitions seleccionado
            button.disabled = false;
            removeOptions(selectEndPoint)
            let endpoints = await getAllEndPoint();
            let baseUrl = endpoints.competitions.base_url;
            endpoints.competitions.endpoints.forEach(endpoint => {
                let option = document.createElement("option");
                option.value = baseUrl+endpoint.entrypoint;
                option.innerHTML = endpoint.name;
                selectEndPoint.appendChild(option);
            })
        }
        else if (selectMatches.value !== "0" && selectCompetitions.value !== "0") // Si Competitions y Matches están seleccionados
        {
            button.disabled = false;
            removeOptions(selectEndPoint)
            let endpoints = await getAllEndPoint();
            let baseUrl = endpoints.matches.base_url;
            endpoints.matches.endpoints.forEach(endpoint => {
                let option = document.createElement("option");
                option.value = baseUrl+endpoint.entrypoint;
                option.innerHTML = endpoint.name;
                selectEndPoint.appendChild(option);
            })
        }
    }
    else
    {
        removeOptions(selectEndPoint)
        button.disabled = true;
    }
}


function removeOptions(selectElement) {
    if (selectElement !== null) {
        if (selectElement.options.length >= 1) {
            var i, L = selectElement.options.length - 1;
            for(i = L; i >= 0; i--) {
                selectElement.remove(i);
            }
        }
    }
}



