import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Loan } from '../models/loan';
import { LoansService } from '../services/loans.service';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-loan',
  templateUrl: './loan.component.html',
  styleUrls: ['./loan.component.css']
})
export class LoanComponent implements OnInit {

  loandid!: string;
  loan?: Loan;

  constructor(private route: ActivatedRoute,
    private loanService: LoansService,
    public loginService: LoginService,
    private router: Router,
    private location: Location) { }

  ngOnInit(): void {
    console.log(this.route.snapshot.paramMap);
    this.loandid = this.route.snapshot.params['loanId'];
    this.loanService.getLoan(this.loandid)
      .subscribe(loan => {
        this.loan = loan;
      });
  }

  onSubmit(form: NgForm) {
    this.router.navigate(['/loan', this.loandid, 'edit']);
  }

  onBack() {
    this.location.back()
  }
}
