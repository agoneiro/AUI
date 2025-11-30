import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Parish } from '../models/parish';

@Injectable({
  providedIn: 'root',
})
export class ParishService {
  private apiUrl = '/api/parishes';

  constructor(private http: HttpClient) {}

  getParishes(): Observable<Parish[]> {
    return this.http.get<Parish[]>(this.apiUrl);
  }

  getParish(id: string): Observable<Parish> {
    return this.http.get<Parish>(`${this.apiUrl}/${id}`);
  }

  createParish(parish: Partial<Parish>): Observable<Parish> {
    return this.http.post<Parish>(this.apiUrl, parish);
  }

  updateParish(id: string, parish: Partial<Parish>): Observable<Parish> {
    return this.http.put<Parish>(`${this.apiUrl}/${id}`, parish);
  }

  deleteParish(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
