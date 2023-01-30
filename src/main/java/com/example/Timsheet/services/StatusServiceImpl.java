package com.example.Timsheet.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Timsheet.DTO.RequestToPmDTO;
import com.example.Timsheet.DTO.StatusDTO;
import com.example.Timsheet.models.Employee;
import com.example.Timsheet.models.Status;
import com.example.Timsheet.models.Timesheet;
import com.example.Timsheet.repositories.StatusRepository;

@Service
public class StatusServiceImpl implements StatusService{
    
    @Autowired
    private StatusRepository statusRepository;

    @Override
    public List<Status> getAll() {
        return statusRepository.findAll();
    }

    @Override
    public Status getById(Integer id) {
        return statusRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Status tidak ditemukan"));
    }

    @Override
    public boolean save(StatusDTO dto) {
        Employee employee = new Employee();
        Timesheet timesheet = new Timesheet(); 
        Status status = new Status();
        employee.setId(dto.getEmployee_id());
        status.setEmployee(employee);
        timesheet.setId(dto.getTimesheet_id());
        status.setTimesheet(timesheet);
        status.setName(dto.getName());
        status.setDate(dto.getDate());

    

        statusRepository.save(status);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        statusRepository.deleteById(id);
        return !statusRepository.findById(id).isPresent();
    }

     
    @Override
    public boolean approval(int id) {
        // cari data by id
        Status status = statusRepository.findById(id).get();
        // ganti data yang dibutuhkan
        status.setName("Approve");
        // status.setDate(new Date());
        // di save
         statusRepository.save(status);
        return true;
    }

    
    @Override
    public boolean reject(int id) {
        // cari data by id
        Status status = statusRepository.findById(id).get();
        // ganti data yang dibutuhkan
        status.setName("Rejected");
        // status.setDate(new Date());
        // di save
        statusRepository.save(status);
        return true;
    }

    @Override
    public List<Status> getAllStatus() {
        return statusRepository.getAllStatus();
    }

    @Override
    public List<StatusDTO> getAllStatusDTO() {
        List<Status> status = statusRepository.getAllStatus();
        return status.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public StatusDTO convertToDto(Status status){
        return new StatusDTO(status.getId(),
             status.getName(),
              status.getDate(),
               status.getEmployee().getId(),
                status.getTimesheet().getId());
    }

    @Override
    public List<Status> getStatusByProjectManager() {
        return statusRepository.getStatusByProjectManager();
    }

    @Override
    public List<RequestToPmDTO> getStatusByProjectManagerDTO() {
        List<Status> status = statusRepository.getStatusByProjectManager();
        return status.stream().map(this::convertToDtoPm).collect(Collectors.toList());
    }

    public RequestToPmDTO convertToDtoPm(Status status){
        return new RequestToPmDTO(status.getId(),
         status.getTimesheet().getProjectName(),
          status.getName(),
           status.getEmployee().getName(),
            status.getTimesheet().getRemarks(),
             status.getDate());
    }
  
}
