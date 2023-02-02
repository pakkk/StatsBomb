import { URL_WEB_PORTAL } from './utils/constants.js'
import { URL_COMPETITION } from './utils/constants.js'

const getAllCompetitions = async () => {
    const respone = await fetch(`${URL_COMPETITION}web`)
    return respone.json()
}

const getAllEndPoint = async () => {
    const respone = await fetch(`${URL_WEB_PORTAL}lista_endpoint`)
    return respone.json()
}

export { getAllEndPoint, getAllCompetitions }