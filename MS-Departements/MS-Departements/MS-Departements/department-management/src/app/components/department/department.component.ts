// src/app/components/department/department.component.ts
import { Component, OnInit } from '@angular/core';
import { DepartmentService } from '../../services/department.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-department',
  templateUrl: './department.component.html',
  styleUrls: ['./department.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule],
})
export class DepartmentComponent implements OnInit {
  departments: any[] = [];
  newDepartment: any = {};
  parentId: number = 0;
  managerId: number = 0;

  constructor(private departmentService: DepartmentService) {}

  ngOnInit(): void {
    // Charger la hiérarchie initiale
    this.getDepartmentHierarchy(1); // Remplace 1 par l'ID de ton département racine
  }

  // Créer un nouveau département
  createDepartment() {
    this.departmentService.createDepartment(this.newDepartment).subscribe(() => {
      alert('Département créé avec succès');
      this.newDepartment = {};
    });
  }

  // Ajouter un sous-département
  addSubDepartment() {
    const subDepartment = { name: this.newDepartment.name };
    this.departmentService.addSubDepartment(this.parentId, subDepartment).subscribe(() => {
      alert('Sous-département ajouté avec succès');
    });
  }

  // Récupérer la hiérarchie des départements
  getDepartmentHierarchy(departmentId: number) {
    this.departmentService.getDepartmentHierarchy(departmentId).subscribe((data) => {
      this.departments = data;
    });
  }

  // Attribuer un responsable à un département
  assignManager() {
    this.departmentService.assignManager(this.parentId, this.managerId).subscribe(() => {
      alert('Responsable attribué avec succès');
    });
  }
}
