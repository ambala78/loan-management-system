import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { LmsError } from '../models/lms-error';
import { Loan } from '../models/loan';
import { LoansService } from '../services/loans.service';

@Component({
  selector: 'app-search-loan',
  templateUrl: './search-loan.component.html',
  styleUrls: ['./search-loan.component.css']
})
export class SearchLoanComponent implements OnInit {
  errorMessage = "";

  constructor(private loansService: LoansService, private router: Router) { }
  ;
  ngOnInit(): void {
  }

  onSubmit(form: NgForm) {
    console.log(form);
    this.loansService.searchLoan(form.value.firstName, form.value.lastName, form.value.loanNumber)
      .subscribe((data) => {
        debugger;
        if ((data as LmsError).statusCode !== undefined) {
          switch ((data as LmsError).statusCode) {
            case 'ERRBNS100':
              this.errorMessage = 'Found more than one loan for the search criteria.';
              break;
            case 'INFBNS101':
              this.errorMessage = 'Loan Not Found for the search criteria.';
              break;
            default:
              this.errorMessage = 'Unknow error, please try after sometime';
          }
        } else {
          this.errorMessage = "";
          this.router.navigate(["loan", (data as Loan).loanId]);
        }
      });


  }

  onClear(form: NgForm) {
    form.reset();
  }

}
