import { Routes } from '@angular/router';
import { ParishListComponent } from './components/parish-list/parish-list.component';
import { ParishFormComponent } from './components/parish-form/parish-form.component';
import { ParishDetailsComponent } from './components/parish-details/parish-details.component';
import { PriestFormComponent } from './components/priest-form/priest-form.component';

export const routes: Routes = [
    {path: 'parishes', component: ParishListComponent},
    {path: 'parishes/new', component: ParishFormComponent},
    {path: 'parishes/:id/edit', component: ParishFormComponent},
    {path: 'parishes/:id', component: ParishDetailsComponent},
    {path: 'parishes/:parishId/priests/new', component: PriestFormComponent},
    {path: 'priests/:id/edit', component: PriestFormComponent}
];
