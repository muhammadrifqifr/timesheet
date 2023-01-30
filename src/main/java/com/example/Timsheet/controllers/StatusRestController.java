package com.example.Timsheet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Timsheet.DTO.RequestToPmDTO;
import com.example.Timsheet.DTO.StatusDTO;
import com.example.Timsheet.models.Status;
import com.example.Timsheet.services.StatusService;

@RestController
@RequestMapping("/api/status")
public class StatusRestController {
    private StatusService statusService;

    @Autowired
    public StatusRestController(StatusService statusService){
        this.statusService = statusService;
    }

    @GetMapping()
    public List<Status> getAll(){
        return statusService.getAll();
    }


    @GetMapping("/RequestPM")
    public List<RequestToPmDTO> getStatusByProjectManager(){
        return statusService.getStatusByProjectManagerDTO();
    }

    @GetMapping("/statusDTO")
    public List<StatusDTO> getAllDTO(){
        return statusService.getAllStatusDTO();
    }

    @PostMapping("/insert")
    public Boolean submitStatus(@RequestBody StatusDTO dto){
        Boolean result;
            result = statusService.save(dto);
        return result;
    }

    //   @PutMapping("/update/{id}")
    // public Boolean update(@PathVariable(required = true) Integer id, @RequestBody Employee employee) {
    //     employee.setId(id);
    //     Boolean result = employeeService.save(employee);
    //     return result;
    // }
    
    @PutMapping("/approve/{id}")
    public Boolean approveMaster(@PathVariable(required = true) Integer id){
        Boolean result;
        result =  statusService.approval(id);
        return result;
    }

    @PutMapping("/reject/{id}")
    public Boolean rejectMaster(@PathVariable(required = true) Integer id){
        Boolean result;
     result =   statusService.reject(id);
        return result;
    }

}
