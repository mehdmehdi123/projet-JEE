import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  private apiUrl = 'http://localhost:9090/employees';  // URL de l'API backend

  constructor(private http: HttpClient) {}

  // ✅ Méthode pour récupérer tous les employés
  getAllEmployees(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  getEmployeeById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }

  createEmployee(employee: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, employee);
  }

  updateEmployee(id: number, employee: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${id}`, employee);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/${id}`);
  }

  uploadDocument(employeeId: number, file: File): Observable<any> {
    const formData = new FormData();
    formData.append('file', file);

    return this.http.post<any>(`${this.apiUrl}/${employeeId}/documents`, formData);
  }
}
