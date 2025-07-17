import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Entry } from '../models/entry';

@Injectable({ providedIn: 'root' })
export class EntryService {
  private baseUrl = 'http://localhost:8080/api/entries'; 
  constructor(private http: HttpClient) {}

  getEntries(): Observable<Entry[]> {
    return this.http.get<Entry[]>(this.baseUrl);
  }

  getEntry(id: number): Observable<Entry> {
    return this.http.get<Entry>(`${this.baseUrl}/${id}`);
  }

  createEntry(entry: Entry): Observable<Entry> {
    return this.http.post<Entry>(this.baseUrl, entry);
  }

  deleteEntry(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }
}
