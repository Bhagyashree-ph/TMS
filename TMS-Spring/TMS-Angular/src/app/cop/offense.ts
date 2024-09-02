export class Offense {
    
    offenseId: string;
    offenseName: string;
    vehicleType: string;
    penalty: number;

    constructor(value: Object = {}) {
        Object.assign(this, value);
    }
}