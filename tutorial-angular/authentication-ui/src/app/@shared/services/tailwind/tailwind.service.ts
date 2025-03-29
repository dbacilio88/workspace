import {Injectable} from "@angular/core";
import {Observable, ReplaySubject} from "rxjs";

@Injectable()
export class TailwindService {
  private _tailwindConfig: ReplaySubject<any> = new ReplaySubject<any>(1);

  constructor() {
    const config: any = {};
    const regexpForClass = /\.fuse-tailwind-extracted-config\s\{([\s\S]*)\}/g;
    const style = regexpForClass.exec(config);
  }

  get tailwindConfig$(): Observable<any> {
    return this._tailwindConfig.asObservable();
  }
}
