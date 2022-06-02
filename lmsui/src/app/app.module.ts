import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { SearchLoanComponent } from './search-loan/search-loan.component';
import { LoanComponent } from './loan/loan.component';
import { LoanEditComponent } from './loan/loan-edit/loan-edit.component';
import { LoginComponent } from './login/login.component';
import { XhrInterceptor } from './interceptors/xhr-interceptor';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SearchLoanComponent,
    LoanComponent,
    LoanEditComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true }],
  bootstrap: [AppComponent]
})
export class AppModule { }
