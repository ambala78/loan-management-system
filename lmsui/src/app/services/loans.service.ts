import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { tap } from 'rxjs';
import { Loan } from '../models/loan';

@Injectable({
  providedIn: 'root'
})
export class LoansService {
  private searchLoanUrlPath = "/api/searchLoan";
  private getLoanUrlPath = "/api/getLoan";
  private saveLoanUrlPath = "/api/saveLoan";
  private baseLoanUrlPath = "/api/loans";

  currentLoan!: Loan;

  constructor(private http: HttpClient) { }

  searchLoan(firstName?: string, lastName?: string, loanNumber?: string) {
    let params = new HttpParams();
    if (firstName) {
      params = params.append("firstName", firstName)
    };
    if (lastName) {
      params = params.append("lastName", lastName)
    };
    if (loanNumber) {
      params = params.append("loanNumber", loanNumber)
    };
    return this.http.get<Loan>(this.searchLoanUrlPath, {
      params: params
    });

  }

  getLoan(loanId: string) {
    let params = new HttpParams();
    params = params.append("loanId", loanId);
    return this.http.get<Loan>(this.getLoanUrlPath, {
      params: params
    }).pipe(tap(loan => {
      this.currentLoan = loan;
    }));
  }

  saveLoan(loan: Loan) {
    return this.http.post<Loan>(this.saveLoanUrlPath, loan).pipe(tap(loan => {
      this.currentLoan = loan;
    }));
  }

  deleteLoan(loanId: number) {
    let deleteUrl = `${this.baseLoanUrlPath}/${loanId}`;
    return this.http.delete<any>(deleteUrl);
  }
}
