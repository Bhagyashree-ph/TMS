import { Owner } from "./owner";
import { Vehicle } from "./vehicle";

export class Registration {
    
    registrationID: string;
    vehicle: Vehicle;
    owner: Owner;
    registrationDate;

    constructor(value: Object = {}) {
        Object.assign(this, value);
    }
}