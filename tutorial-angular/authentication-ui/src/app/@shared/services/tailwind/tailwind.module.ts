import {NgModule} from "@angular/core";
import {TailwindService} from "./tailwind.service";

@NgModule({
  imports: [],
  providers: [
    TailwindService
  ],
  declarations: [],
})
export class TailwindModule {

  constructor(private _tailwindService: TailwindService) {
  }
}
