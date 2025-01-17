package com.example.MS_Employes.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MS-Departements", url = "http://localhost:9092")
public interface DepartementClient {
    @GetMapping("/departements/{id}")
    Departement getDepartmentById(@PathVariable("id") Long id);
}
