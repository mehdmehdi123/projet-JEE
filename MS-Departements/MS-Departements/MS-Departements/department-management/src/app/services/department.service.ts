// src/app/services/department.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class DepartmentService {
  private baseUrl = 'http://localhost:8080/departments';

  constructor(private http: HttpClient) {}

  // Créer un département
  createDepartment(department: any): Observable<any> {
    return this.http.post(`${this.baseUrl}`, department);
  }

  // Ajouter un sous-département
  addSubDepartment(parentId: number, subDepartment: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/${parentId}/sub-department`, subDepartment);
  }

  // Récupérer la hiérarchie des départements
  getDepartmentHierarchy(departmentId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${departmentId}/hierarchy`);
  }

  // Attribuer un responsable à un département
  assignManager(departmentId: number, managerId: number): Observable<any> {
    return this.http.put(`${this.baseUrl}/${departmentId}/manager/${managerId}`, null);
  }
}
