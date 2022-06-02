import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { LoansService } from '../services/loans.service';

@Component({
  selector: 'app-search-loan',
  templateUrl: './search-loan.component.html',
  styleUrls: ['./search-loan.component.css']
})
export class SearchLoanComponent implements OnInit {

  constructor(private loansService: LoansService, private router: Router) { }
  ;
  ngOnInit(): void {
  }

  onSubmit(form: NgForm) {
    console.log(form);
    this.loansService.searchLoan(form.value.firstName, form.value.lastName, form.value.loanNumber)
      .subscribe(data => {
        this.router.navigate(["loan", data.loanId]);
      });


  }

  onClear(form: NgForm) {
    form.reset();
  }

}
