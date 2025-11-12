package com.overdaily.Overdaily.Repository;

import com.overdaily.Overdaily.entity.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MapRepository extends JpaRepository<Map, Integer> {
    Optional<Map> findById(Integer ID);
}
