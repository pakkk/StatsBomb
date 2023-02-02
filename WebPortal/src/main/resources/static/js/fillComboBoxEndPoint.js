import {getAllEndPoint, getAllCompetitions} from "./query.js";

let competicionesDisponibles = await getAllCompetitions();

let selectCompeticion = document.getElementById("selectCompetitions");

console.log(competicionesDisponibles)

competicionesDisponibles.forEach(competicion => {
    let option = document.createElement("option");
    option.value = competicion["competition_id"].competition_id + "" + competicion["competition_id"].season_id
    option.innerHTML = competicion.competition_name + " " + competicion.season_name;
    selectCompeticion.appendChild(option);
})

