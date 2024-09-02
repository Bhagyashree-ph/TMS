export class Owner {

    ownerId: string;
    idType: string;
    firstName: string;
    lastName: string;
    dateOfBirth;
    gender: string;
    phoneNumber: string;
    address: string;
    pincode: number;
    occupation: string;

    constructor(value: Object = {}) {
        Object.assign(this, value);
    }
}