package com.overdaily.Repository;

import com.overdaily.entity.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MapRepository extends JpaRepository<Map, Integer> {
    Optional<Map> findById(Integer ID);
}
