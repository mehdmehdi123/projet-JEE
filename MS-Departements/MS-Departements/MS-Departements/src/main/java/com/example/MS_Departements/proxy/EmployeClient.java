package com.example.MS_Departements.proxy;

import com.example.MS_Departements.dto.EmployeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "MS-Employes", url = "http://localhost:9090")
public interface EmployeClient {
    @GetMapping("/employees")
    List<EmployeDto> getAllEmployes();

    @GetMapping("/employees/{id}")
    EmployeDto getEmployeById(@PathVariable("id") Long id);

    @GetMapping("/employees/department/{departmentId}")
    List<EmployeDto> getEmployeesByDepartmentId(@PathVariable Long departmentId);
}
