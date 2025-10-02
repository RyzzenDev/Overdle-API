package com.overdaily.Overdaily.Repository;

import com.overdaily.Overdaily.model.Falas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FalasRepository extends JpaRepository<Falas, Short> {
}
