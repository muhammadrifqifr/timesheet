package com.example.Timsheet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Timsheet.DTO.StatusDTO;
import com.example.Timsheet.models.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer>{
    @Query(value = "SELECT * FROM tbl_tr_status", nativeQuery = true)
    public List<Status> getAllStatus();

    @Query(value = "SELECT * FROM tbl_tr_status", nativeQuery = true)
    public List<StatusDTO> getAllStatusDTO();
}
