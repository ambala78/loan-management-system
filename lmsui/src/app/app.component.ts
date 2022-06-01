import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

import { LoginService } from './services/login.service';
import { LmsUser } from './models/lmsUser';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Loan Management System';

  constructor(private loginService: LoginService, private http: HttpClient, private router: Router) { }

  isRoleUser(): boolean {
    return this.loginService.isRoleUser();
  }

  isAdminUser(): boolean {
    return this.loginService.isAdminUser();
  }


  isAuthenticated(): boolean {
    return this.loginService.isAuthenticated();
  }

  logout() {
    this.loginService.logout();
  }
}
