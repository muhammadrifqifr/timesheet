package com.example.Timsheet.DTO;

import java.util.Date;

public class RequestToPmDTO {
    
    private Integer id;
    private String project_name;
    private String status_name;
    private String employee_name;
    private String remarks;
    private Date date;
    
    public RequestToPmDTO(Integer id, String project_name, String status_name, String employee_name, String remarks,
            Date date) {
        this.id = id;
        this.project_name = project_name;
        this.status_name = status_name;
        this.employee_name = employee_name;
        this.remarks = remarks;
        this.date = date;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getProject_name() {
        return project_name;
    }
    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }
    public String getStatus_name() {
        return status_name;
    }
    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }
    public String getEmployee_name() {
        return employee_name;
    }
    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

}
