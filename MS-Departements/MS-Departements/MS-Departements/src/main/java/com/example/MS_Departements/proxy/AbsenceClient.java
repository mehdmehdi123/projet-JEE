package com.example.MS_Departements.proxy;

import com.example.MS_Departements.dto.AbsenceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "MS-Absences", url = "http://localhost:9091")
public interface AbsenceClient {
    @GetMapping("/employee/{employeeId}")
    List<AbsenceDto> getAbsencesByEmployeeId(@PathVariable("employeeId") Long employeeId);
}
