import {Component, Input, OnChanges, OnDestroy, OnInit, SimpleChanges} from '@angular/core';
import {NgIf} from "@angular/common";
import {MatProgressBar} from "@angular/material/progress-bar";
import {Subject, takeUntil} from "rxjs";
import {LoadingBarService} from "./service/loading-bar.service";
import {Router} from "@angular/router";
import {coerceBooleanProperty} from "@angular/cdk/coercion";
import {HTTP_INTERCEPTORS} from "@angular/common/http";
import {LoadingBarInterceptor} from "./interceptor/loading-bar.interceptor";

@Component({
  selector: 'app-loading-bar',
  standalone: true,
  imports: [
    NgIf,
    MatProgressBar
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: LoadingBarInterceptor,
    multi: true
  }],
  templateUrl: './loading-bar.component.html',
  styleUrl: './loading-bar.component.scss'
})
export class LoadingBarComponent implements OnChanges, OnInit, OnDestroy {

  @Input() auto: boolean = true;

  show: boolean = true;
  mode!: 'determinate' | 'indeterminate';
  progress: number | null = 0;

  private _unsubscribeAll: Subject<any> = new Subject<any>();

  constructor(private router: Router, private _service: LoadingBarService) {

  }

  ngOnChanges(changes: SimpleChanges): void {
    if ('auto' in changes) {
      console.log(changes);
      this._service.setModeAuto(coerceBooleanProperty(changes['auto'].currentValue));
    }
  }

  ngOnDestroy(): void {
    this._unsubscribeAll.next(null);
    this._unsubscribeAll.complete();
  }

  ngOnInit(): void {
    this._service.mode$.pipe(takeUntil(this._unsubscribeAll))
      .subscribe((value) => {
        this.mode = value;
      });
    this._service.progress$.pipe(takeUntil(this._unsubscribeAll))
      .subscribe((value) => {
        this.progress = value;
      });

    this._service.show$.pipe(takeUntil(this._unsubscribeAll))
      .subscribe((value) => {
        this.show = value;
      });
  }

}
