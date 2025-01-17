import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmployeeService } from '../services/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css'],
})
export class EmployeeListComponent implements OnInit {
  employees: any[] = [];
  selectedEmployee: any;  // Employé sélectionné

  constructor(private employeeService: EmployeeService, private router: Router) {}

  ngOnInit(): void {
    this.employeeService.getAllEmployees().subscribe(
      (data) => {
        this.employees = data;
      },
      (error) => {
        console.error('Erreur lors de la récupération des employés :', error);
      }
    );
  }

  viewDetails(employee: any) {
    this.router.navigate(['/employee-details', employee.id]);
  }

  editEmployee(employee: any) {
    this.router.navigate(['/employee-edit', employee.id]);
  }
}
