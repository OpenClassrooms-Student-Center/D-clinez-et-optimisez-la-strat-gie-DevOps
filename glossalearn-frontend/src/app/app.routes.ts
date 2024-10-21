import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LessonsComponent } from './lessons/lessons.component';

export const routes: Routes = [
    { path: 'home', component: HomeComponent },
    { path: 'lessons', component: LessonsComponent },
    { path: '', redirectTo: '/home', pathMatch: 'full' }
  ];