import {Inject, Injectable} from "@angular/core";
import {BehaviorSubject, Observable} from "rxjs";
import {APP_CONFIG} from "./config.constant";
import {merge} from "lodash-es";

@Injectable({
  providedIn: 'root',
})
export class ConfigService {

  private _config: BehaviorSubject<any>;

  constructor(@Inject(APP_CONFIG) config: any) {
    this._config = new BehaviorSubject<any>(config);
  }

  set config(value: any) {
    const config = merge({}, this._config.value, value);
    this._config.next(config);
  }

  get config$(): Observable<any> {
    return this._config.asObservable();
  }

  reset(): void {
    this._config.next(this.config);
  }
}
