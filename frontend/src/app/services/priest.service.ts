import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Priest } from '../models/priest';

@Injectable({
  providedIn: 'root',
})
export class PriestService {
  constructor(private http: HttpClient) {}

  getPriestsByParish(parishId: string): Observable<Priest[]> {
    return this.http.get<Priest[]>(`/api/parishes/${parishId}/priests`);
  }

  getPriest(id: string): Observable<Priest> {
    return this.http.get<Priest>(`/api/priests/${id}`);
  }

  createPriest(parishId: string, priest: Partial<Priest>): Observable<Priest> {
    return this.http.post<Priest>(`/api/parishes/${parishId}/priests`, priest);
  }

  updatePriest(id: string, priest: Partial<Priest>): Observable<Priest> {
    return this.http.put<Priest>(`/api/priests/${id}`, priest);
  }

  deletePriest(id: string): Observable<void> {
    return this.http.delete<void>(`/api/priests/${id}`);
  }
}
