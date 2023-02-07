import {getEndPoint} from "./query.js";

const selectCompetitions = document.getElementById("selectCompetitions");
const selectMatches = document.getElementById("selectMatches");
const selectEndPoint = document.getElementById("endpoints");
const button = document.getElementById("submit");
const textArea = document.getElementById("text");

button.addEventListener("click", submitStats)

async function submitStats() {

    if (selectEndPoint.value.includes("competitionId={}") && selectEndPoint.value.includes("seasonId={}") && (selectEndPoint.value.match(/{}/g) || []).length === 2 && selectMatches.value !== "0")
    {
        const idCompeticion = selectCompetitions.value.split("/")[0];
        const idSeason = selectCompetitions.value.split("/")[1];

        let url = selectEndPoint.value.replace("competitionId={}", "competitionId="+idCompeticion);
        url = url.replace("seasonId={}", "seasonId="+idSeason);
        console.log(url);
        textArea.innerHTML = JSON.stringify(await getEndPoint(url), null, 2);
    }
    else if ((selectEndPoint.value.match(/{}/g) || []).length >= 3)
    {
        console.log("Tiene mas de 3 {}")
        let url = selectEndPoint.value;

        let urlArray = url.split("&");
        urlArray.forEach((element, index) => {
            console.log(index)
            console.log(element)
            if (index > 1)
            {
                console.log(element.toString())
                url = url.replace(element, element.replace("{}","")+document.getElementById(element.toString()).value);
            }
        })
        const idCompeticion = selectCompetitions.value.split("/")[0];
        const idSeason = selectCompetitions.value.split("/")[1];

        url = url.replace("competitionId={}", "competitionId="+idCompeticion);
        url = url.replace("seasonId={}", "seasonId="+idSeason);
        console.log(url)

        textArea.innerHTML = JSON.stringify(await getEndPoint(url), null, 2);

    }
    else
    {
        textArea.innerHTML = JSON.stringify(await getEndPoint(selectEndPoint.value), null, 2);
    }


}