import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Data, Router } from '@angular/router';

import * as _ from 'lodash';
import { Loan } from 'src/app/models/loan';
import { LoansService } from 'src/app/services/loans.service';

@Component({
  selector: 'app-loan-edit',
  templateUrl: './loan-edit.component.html',
  styleUrls: ['./loan-edit.component.css']
})
export class LoanEditComponent implements OnInit {
  editMode: boolean = true;
  currentLoan!: Loan;

  constructor(private route: ActivatedRoute,
    private loanService: LoansService,
    private router: Router) { }

  ngOnInit(): void {

    this.route.data.subscribe((data: Data) => {
      this.editMode = data['editMode'];
    });
    if (this.editMode) {
      this.currentLoan = _.cloneDeep(this.loanService.currentLoan);
    } else {
      this.currentLoan = new Loan();
    }

  }

  onSubmit(form: NgForm) {
    this.loanService.saveLoan(this.currentLoan)
      .subscribe(loan => {
        this.currentLoan = loan;
        this.editMode = true;
      });
  }

  onReset() {
    if (this.editMode) {
      this.currentLoan = _.cloneDeep(this.loanService.currentLoan);
    } else {
      this.currentLoan = new Loan();
    }
  }

  onDelete() {
    if (this.editMode) {
      this.loanService.deleteLoan(this.currentLoan.loanId)
        .subscribe(
          result => {
            this.router.navigate(['/search']);
          }
        );
    }
  }
}
