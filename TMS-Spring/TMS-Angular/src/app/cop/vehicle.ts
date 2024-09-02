export class Vehicle {

    vehicleID: number;
    engineNumber: string;
    chassisNumber: string;
    vehicleType: string;
    vehicleColor: string;
    fuelUsed: string;
    manufacturDate;
    manufacturerName: string;
    model: string;
    variant: string

    constructor(value: Object = {}) {
        Object.assign(this, value);
    }
}