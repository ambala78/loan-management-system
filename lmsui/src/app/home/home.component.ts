import { Component, OnInit } from '@angular/core';
import { LoansService } from '../services/loans.service';
import { LoginService } from '../services/login.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private loansService: LoansService, public loginService: LoginService) { }

  ngOnInit(): void {

  }

}
