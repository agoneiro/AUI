import { Routes } from '@angular/router';
import { ParishListComponent } from './components/parish-list/parish-list.component';
import { ParishFormComponent } from './components/parish-form/parish-form.component';

export const routes: Routes = [
    {path: 'parishes', component: ParishListComponent},
    {path: 'parishes/new', component: ParishFormComponent}
];
