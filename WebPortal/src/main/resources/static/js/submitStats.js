import {getEndPoint} from "./query.js";

const selectMatches = document.getElementById("selectMatches");
const selectEndPoint = document.getElementById("endpoints");
const button = document.getElementById("submit");
const textArea = document.getElementById("text");

button.addEventListener("click", submitStats)

async function submitStats() {

    textArea.innerHTML = "";

    if (selectEndPoint.value.includes("{}")) {
        let matchId = selectMatches.value;

        let url = selectEndPoint.value.replace("{}", matchId);
        textArea.innerHTML = JSON.stringify(await getEndPoint(url));
    }
    else
    {
        textArea.innerHTML = JSON.stringify(await getEndPoint(selectEndPoint.value));
    }

}