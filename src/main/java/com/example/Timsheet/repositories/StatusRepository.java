package com.example.Timsheet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Timsheet.models.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer>{
    
}
