import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {finalize, Observable} from "rxjs";
import {LoadingBarService} from "../service/loading-bar.service";

@Injectable()
export class LoadingBarInterceptor implements HttpInterceptor {

  automatic: boolean = false;

  constructor(private _service: LoadingBarService) {
    this._service.auto$
      .subscribe((value) => {
        this.automatic = value;
      })
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    if (!this.automatic) {
      return next.handle(req);
    }
    this._service._setLoadingStatus(true, req.url)
    return next.handle(req)
      .pipe(finalize(() => {
        this._service._setLoadingStatus(false, req.url)
      }));
  }
}
