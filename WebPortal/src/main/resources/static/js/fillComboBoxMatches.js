import {getAllMatchesOfCompetition} from "./query.js";

const selectCompetitions = document.getElementById("selectCompetitions");

selectCompetitions.addEventListener("change", fillComboBoxMatches)

async function fillComboBoxMatches() {


    let selectMatches = document.getElementById("selectMatches");

    if (selectCompetitions.value === "0") {
        removeOptions(selectMatches);
        let option = document.createElement("option");
        option.value = "0";
        option.innerHTML = "Choose an option"
        selectMatches.appendChild(option);

        selectMatches.appendChild(document.createElement("option"));
        selectMatches.disabled = true;
    }
    else {
        selectMatches.disabled = false;
        const idCompeticion = selectCompetitions.value.split("/")[0];
        const idSeason = selectCompetitions.value.split("/")[1];

        let matchesDisponibles = await getAllMatchesOfCompetition(idCompeticion, idSeason);

        removeOptions(selectMatches);

        let option = document.createElement("option");
        option.value = "0";
        option.innerHTML = "Choose an option"
        selectMatches.appendChild(option);

        matchesDisponibles.forEach(partido => {
            let option = document.createElement("option");
            option.value = partido.match_id;
            option.innerHTML = partido.home_team + " - " + partido.away_team;
            selectMatches.appendChild(option);
        })
    }

}


function removeOptions(selectElement) {
    var i, L = selectElement.options.length - 1;
    for(i = L; i >= 0; i--) {
        selectElement.remove(i);
    }
}



