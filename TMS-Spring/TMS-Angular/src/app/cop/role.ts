export class Role {

    roleName: string;
    roleDesc: string;

    constructor(value: Object = {}) {
        Object.assign(this, value);
    }
}