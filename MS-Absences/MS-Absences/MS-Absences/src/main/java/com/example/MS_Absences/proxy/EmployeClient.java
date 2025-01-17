package com.example.MS_Absences.proxy;

import com.example.MS_Absences.dto.EmployeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MS-Employes", url = "http://localhost:9090")
public interface EmployeClient {
    @GetMapping("/employees/{id}")
    EmployeDto getEmployeeById(@PathVariable("id") Long id);
}
