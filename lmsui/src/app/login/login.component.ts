import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { LoginService } from '../services/login.service';
import { LmsCredential } from '../models/lms-credential';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  credentials!: LmsCredential;

  constructor(public loginService: LoginService, private http: HttpClient, private router: Router) {
  }

  ngOnInit(): void {
    this.credentials = new LmsCredential();
  }

  login() {
    this.loginService.authenticate(this.credentials, () => {
      this.router.navigateByUrl('/');
    });
    return false;
  }

}