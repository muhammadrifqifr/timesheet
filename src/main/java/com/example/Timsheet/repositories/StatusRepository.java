package com.example.Timsheet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Timsheet.DTO.RequestToHrDTO;
import com.example.Timsheet.DTO.RequestToPmDTO;
import com.example.Timsheet.DTO.RequestToPmoDTO;
import com.example.Timsheet.DTO.StatusDTO;
import com.example.Timsheet.models.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer>{
    @Query(value = "SELECT * FROM tbl_tr_status", nativeQuery = true)
    public List<Status> getAllStatus();

    @Query(value = "SELECT * FROM tbl_tr_status", nativeQuery = true)
    public List<StatusDTO> getAllStatusDTO();

    @Query(value = "SELECT s.*, ts.*, e.* FROM tbl_tr_status s JOIN tbl_m_employee e ON s.employee_id = e.id JOIN tbl_m_timesheet ts ON s.timesheet_id = s.id WHERE s.name  = 'request'", nativeQuery = true)
    public List<Status> getStatusByProjectManager();

    @Query(value = "SELECT s.*, ts.*, e.* FROM tbl_tr_status s JOIN tbl_m_employee e ON s.employee_id = e.id JOIN tbl_m_timesheet ts ON s.timesheet_id = s.id WHERE s.name  = 'request'", nativeQuery = true)
    public List<RequestToPmDTO> getStatusByProjectManagerDTO();

    // @Query(value = "SELECT s.*, ts.*, e.* FROM tbl_tr_status s JOIN tbl_m_employee e ON s.employee_id = e.id JOIN tbl_m_timesheet ts ON s.timesheet_id = s.id WHERE s.name  = request", nativeQuery = true)
    // public List<Status> getStatusByProjectManagerOfficer();

    // @Query(value = "SELECT s.*, ts.*, e.* FROM tbl_tr_status s JOIN tbl_m_employee e ON s.employee_id = e.id JOIN tbl_m_timesheet ts ON s.timesheet_id = s.id WHERE s.name  = request", nativeQuery = true)
    // public List<RequestToPmoDTO> getStatusByProjectManagerOfficerDTO();

    // @Query(value = "SELECT s.*, ts.*, e.* FROM tbl_tr_status s JOIN tbl_m_employee e ON s.employee_id = e.id JOIN tbl_m_timesheet ts ON s.timesheet_id = s.id WHERE s.name  = request", nativeQuery = true)
    // public List<Status> getStatusByHumanResource();

    // @Query(value = "SELECT s.*, ts.*, e.* FROM tbl_tr_status s JOIN tbl_m_employee e ON s.employee_id = e.id JOIN tbl_m_timesheet ts ON s.timesheet_id = s.id WHERE s.name  = request", nativeQuery = true)
    // public List<RequestToHrDTO> getStatusByHumanResourceDTO();
}
