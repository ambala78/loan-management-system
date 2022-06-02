import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

  constructor(private loginService: LoginService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    let roles: string[] = route.data['rolesAuthorized'];

    if (this.loginService && this.loginService.lmsUser) {
      return this.loginService.isAuthenticated() && roles.indexOf(this.loginService.lmsUser.lmsUserrole) > -1;
    }

    return false;
  }
}
