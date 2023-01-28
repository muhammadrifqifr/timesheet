package com.example.Timsheet.DTO;

public class EmployeeDTO {
    public EmployeeDTO(Integer id, String name, String email, String nik, Integer designation_id,
            String designation_name, Integer department_id, String department_name, Integer division_id,
            String division_name) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.nik = nik;
        this.designation_id = designation_id;
        this.designation_name = designation_name;
        this.department_id = department_id;
        this.department_name = department_name;
        this.division_id = division_id;
        this.division_name = division_name;
    }
    
    private Integer id;
    private String name;
    private String email;
    private String nik;
    private Integer designation_id;
    private String designation_name;
    private Integer department_id;
    private String department_name;
    private Integer division_id;
    private String division_name;

    public EmployeeDTO(){}

    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNik() {
        return nik;
    }
    public void setNik(String nik) {
        this.nik = nik;
    }
    public Integer getDesignation_id() {
        return designation_id;
    }
    public void setDesignation_id(Integer designation_id) {
        this.designation_id = designation_id;
    }
    public String getDesignation_name() {
        return designation_name;
    }
    public void setDesignation_name(String designation_name) {
        this.designation_name = designation_name;
    }
    public Integer getDepartment_id() {
        return department_id;
    }
    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }
    public String getDepartment_name() {
        return department_name;
    }
    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
    public Integer getDivision_id() {
        return division_id;
    }
    public void setDivision_id(Integer division_id) {
        this.division_id = division_id;
    }
    public String getDivision_name() {
        return division_name;
    }
    public void setDivision_name(String division_name) {
        this.division_name = division_name;
    }  
}
