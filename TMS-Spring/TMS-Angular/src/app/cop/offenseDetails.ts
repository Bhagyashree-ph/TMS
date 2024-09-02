import { User } from "../user";
import { Offense } from "./offense";
import { Registration } from "./registration";

export class OffenseDetails {

    offenseDetailId: string;
    dateTime;
    place: string;
    img: any;
    registration: Registration;
    offense: Offense;
    user: User;
    penaltyStatus: string;

    constructor(value: Object = {}) {
        Object.assign(this, value);
    }
}