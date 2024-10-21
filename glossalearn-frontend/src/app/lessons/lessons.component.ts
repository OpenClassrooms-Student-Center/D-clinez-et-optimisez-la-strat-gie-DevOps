import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { map, Observable } from 'rxjs';
import { environment } from '../../environments/environment';


interface StatsModel {
  count: number;
}

interface LessonModel {
  id: string;
  title: string;
  description: string;
  content: string;
  tags: Array<string>;
}


interface BackendResult<T> {
  data: T;
  error: any;
}

@Component({
  standalone: true,
  imports: [CommonModule, MatCardModule, MatButtonModule],
  selector: 'app-lessons',
  templateUrl: './lessons.component.html',
  styleUrl: './lessons.component.css'
  
})
export class LessonsComponent implements OnInit {
  public lessons$?: Observable<Array<LessonModel>>;
  public stats$?: Observable<StatsModel>;

  constructor(private readonly http: HttpClient) {    
  }
  ngOnInit(): void {
    this.lessons$ = this.http.get<BackendResult<Array<LessonModel>>>(`${environment.BACKEND_URL}lessons`).pipe(map(result => result.data));
    this.stats$ = this.http.get<StatsModel>(`${environment.ANALYTICS_URL}analyze`);
  }
}
