export class JwtToken {
    constructor(token)
    {
        this._token = token;
    }


    get token() {
        return this._token;
    }

}