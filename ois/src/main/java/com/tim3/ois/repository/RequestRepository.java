package com.tim3.ois.repository;

import com.tim3.ois.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("requestRepository")
public interface RequestRepository extends JpaRepository<Request, Integer> {
    Request findById(int id);
}
