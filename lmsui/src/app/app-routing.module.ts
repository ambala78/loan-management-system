import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoanEditComponent } from './loan/loan-edit/loan-edit.component';
import { LoanComponent } from './loan/loan.component';
import { LoginComponent } from './login/login.component';
import { SearchLoanComponent } from './search-loan/search-loan.component';
import { AuthGuardService } from './services/auth-guard.service';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  {
    path: 'search', component: SearchLoanComponent, canActivate: [AuthGuardService],
    data: { rolesAuthorized: ['ROLE_ADMIN', 'ROLE_USER'] }
  },
  {
    path: 'loan/new', component: LoanEditComponent, canActivate: [AuthGuardService],
    data: { editMode: false, rolesAuthorized: ['ROLE_ADMIN'] }
  },
  {
    path: 'loan/:loanId', component: LoanComponent,
    data: { rolesAuthorized: ['ROLE_ADMIN', 'ROLE_USER'] }
  },
  {
    path: 'loan/:loanId/edit', component: LoanEditComponent, canActivate: [AuthGuardService],
    data: { editMode: true, rolesAuthorized: ['ROLE_ADMIN'] }
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
