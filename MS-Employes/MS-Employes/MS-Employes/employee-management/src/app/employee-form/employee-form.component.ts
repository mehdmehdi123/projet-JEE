import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-employee-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.css']
})
export class EmployeeFormComponent {
  employee = {
    name: '',
    position: '',
    department: ''
  };

  onSubmit() {
    alert('Employee saved: ' + JSON.stringify(this.employee));
    this.employee = { name: '', position: '', department: '' };
  }
}
