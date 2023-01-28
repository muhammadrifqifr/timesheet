package com.example.Timsheet.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        employee.setId(dto.getEmployee());
        status.setEmployee(employee);
        timesheet.setId(dto.getTimesheet());
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
}
