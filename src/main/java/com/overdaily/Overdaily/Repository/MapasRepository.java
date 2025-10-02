package com.overdaily.Overdaily.Repository;

import com.overdaily.Overdaily.model.Mapas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapasRepository extends JpaRepository<Mapas, Short> {
}
