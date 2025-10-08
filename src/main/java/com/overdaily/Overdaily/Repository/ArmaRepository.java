package com.overdaily.Overdaily.Repository;

import com.overdaily.Overdaily.model.Arma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArmaRepository extends JpaRepository<Arma, Integer> {
    Optional<Arma> findById(Integer ID);
}
