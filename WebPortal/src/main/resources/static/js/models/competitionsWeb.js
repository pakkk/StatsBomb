export class CompetitionsWeb {

    constructor(competition_id, competition_name, season_name) {
        this._competition_id = competition_id;
        this._competition_name = competition_name;
        this._season_name = season_name;
    }


    get competition_id() {
        return this._competition_id;
    }

    set competition_id(value) {
        this._competition_id = value;
    }

    get competition_name() {
        return this._competition_name;
    }

    set competition_name(value) {
        this._competition_name = value;
    }

    get season_name() {
        return this._season_name;
    }

    set season_name(value) {
        this._season_name = value;
    }
}