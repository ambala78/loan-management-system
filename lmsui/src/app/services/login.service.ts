import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpStatusCode } from '@angular/common/http';
import { finalize } from 'rxjs/operators';

import { LmsUser } from '../models/lmsUser';
import { LmsCredential } from '../models/lms-credential';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private userUrlPath = "/api/user";

  authenticated = false;
  lmsUser!: LmsUser;
  errorMessage = "";


  constructor(private http: HttpClient,
    private router: Router) {
  }

  authenticate(credentials: LmsCredential, callback: any) {

    const headers = new HttpHeaders(credentials ? {
      authorization: 'Basic ' + btoa(credentials.username + ':' + credentials.password)
    } : {});

    this.http.get<LmsUser>(this.userUrlPath, { headers: headers }).subscribe(response => {
      this.errorMessage = "";

      if (response) {
        this.lmsUser = response;
        this.authenticated = true;
      } else {
        this.authenticated = false;
      }
      return callback && callback();
    }, errorResponse => {
      if (errorResponse.status === HttpStatusCode.Unauthorized) {
        this.errorMessage = 'Invalid credential, please try again.';
      }
    });
  }

  logout() {
    this.http.get('/logout')
      .pipe(finalize(() => {
        this.authenticated = false;
        this.lmsUser = new LmsUser("", "");
        this.router.navigateByUrl('/login');
      }))
      .subscribe();
  }

  isRoleUser(): boolean {
    if (this.lmsUser.lmsUserrole === 'ROLE_USER') {
      return true;
    }
    return false;
  }

  isAdminUser(): boolean {
    if (this.lmsUser.lmsUserrole === 'ROLE_ADMIN') {
      return true;
    }
    return false;
  }


  isAuthenticated(): boolean {
    return this.authenticated;
  }

  getErrorMessage() {
    return this.errorMessage;
  }

}