import { Borrower } from "./borrower";
import { Property } from "./property";

export class Loan {
    public loanId!: number;
    public number!: string;
    public amount!: string;
    public term!: string;
    public status!: string;
    public fee!: string;
    public property!: Property;
    public borrower!: Borrower;
    constructor() {
        this.property = new Property();
        this.borrower = new Borrower();
    }
}