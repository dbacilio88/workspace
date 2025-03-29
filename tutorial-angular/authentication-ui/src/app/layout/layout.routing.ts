import {Routes} from "@angular/router";
import {LayoutComponent} from "./layout.component";


export const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      {
        path: 'dashboard',
        loadComponent: () => import('../modules/admin/components/dashboard/dashboard.component').then(m => m.DashboardComponent)
      }
    ]
  }
];


