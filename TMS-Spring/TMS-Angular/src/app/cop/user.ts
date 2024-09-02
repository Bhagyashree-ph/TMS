import { Role } from "./role";

export class User {
    
    userId: string;
    userName: string;
    password: string;
    email: string;
    role: Role;

    constructor(value: Object = {}) {
        Object.assign(this, value);
    }
}