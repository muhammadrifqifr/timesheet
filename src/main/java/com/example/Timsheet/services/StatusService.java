package com.example.Timsheet.services;

import java.util.List;

import com.example.Timsheet.DTO.RequestToPmDTO;
import com.example.Timsheet.DTO.StatusDTO;
import com.example.Timsheet.models.Status;

public interface StatusService {
    public List<Status> getAll();
    
    public List<Status> getAllStatus();
    public List<StatusDTO> getAllStatusDTO();

    public List<Status> getStatusByProjectManager();
    public List<RequestToPmDTO> getStatusByProjectManagerDTO();

    public Status getById(Integer id);
    public boolean save(StatusDTO dto);
    public boolean delete(Integer id);
    public boolean approval(int id);
    public boolean reject(int id);
}
