package com.example.MS_Absences.dto;

import com.example.MS_Absences.model.AbsenceType;

import java.time.LocalDate;

public class AbsenceRequest {
    private Long employeeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private AbsenceType type;

    public AbsenceRequest() {
    }

    public AbsenceRequest(Long employeeId, LocalDate startDate, LocalDate endDate, AbsenceType type) {
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public AbsenceType getType() {
        return type;
    }

    public void setType(AbsenceType type) {
        this.type = type;
    }
}
