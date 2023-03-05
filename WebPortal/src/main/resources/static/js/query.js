import {URL_MATCH, URL_WEB_PORTAL, URL_COMPETITION} from './utils/constants.js'

const getToken = async () => {
    const respone = await fetch(`${URL_WEB_PORTAL}token`)
    return respone.json()
}


const getAllCompetitions = async () => {
    let token = await getToken();
    const respone = await fetch(`${URL_COMPETITION}web`,{
        method: 'GET',
        headers: {
            "Content-Type": "application/json",
            "Authorization": token.token
        },
    })
    return respone.json()
}

const getAllMatchesOfCompetition = async (competitionId, seasonId) => {
    let token = await getToken();
    const respone = await fetch(`${URL_MATCH}matches?competitionId=${competitionId}&seasonId=${seasonId}`,{
        method: 'GET',
        headers: {
            "Content-Type": "application/json",
            "Authorization": token.token
        },
    })
    return respone.json()
}

const getAllEndPoint = async () => {
    const respone = await fetch(`${URL_WEB_PORTAL}lista_endpoint`)
    return respone.json()
}

const getEndPoint = async (urlComplete) => {
    let token = await getToken();
    const respone = await fetch(urlComplete,{
        method: 'GET',
        headers: {
            "Content-Type": "application/json",
            "Authorization": token.token
        },
    })
    return respone.json()
}

export { getAllEndPoint, getAllCompetitions, getAllMatchesOfCompetition, getEndPoint, getToken }