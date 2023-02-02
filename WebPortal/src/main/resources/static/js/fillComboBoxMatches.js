import {getAllMatchesOfCompetition} from "./query.js";

const selectCompetitions = document.getElementById("selectCompetitions");

selectCompetitions.addEventListener("change", fillComboBoxMatches)

async function fillComboBoxMatches() {

    console.log("fillComboBoxMatches")

    console.log(selectCompetitions.value.split("/")[0])

    const idCompeticion = selectCompetitions.value.split("/")[0];
    const idSeason = selectCompetitions.value.split("/")[1];

    let matchesDisponibles = await getAllMatchesOfCompetition(idCompeticion, idSeason);

    let selectMatches = document.getElementById("selectMatches");

    console.log(matchesDisponibles);

    matchesDisponibles.forEach(partido => {
        let option = document.createElement("option");
        option.value = partido.match_id;
        option.innerHTML = partido.home_team + " - " + partido.away_team;
        selectMatches.appendChild(option);
    })
}


