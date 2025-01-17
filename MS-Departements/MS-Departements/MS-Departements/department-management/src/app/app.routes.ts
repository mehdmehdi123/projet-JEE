import { Routes } from '@angular/router';
import { DepartmentComponent } from './components/department/department.component';

export const routes: Routes = [
  { path: '', component: DepartmentComponent },
  { path: 'departments', component: DepartmentComponent }
];
