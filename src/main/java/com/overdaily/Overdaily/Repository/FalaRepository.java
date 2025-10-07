package com.overdaily.Overdaily.Repository;

import com.overdaily.Overdaily.model.Fala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FalaRepository extends JpaRepository<Fala, Short> {
}
