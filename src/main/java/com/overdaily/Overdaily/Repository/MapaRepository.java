package com.overdaily.Overdaily.Repository;

import com.overdaily.Overdaily.model.Mapa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapaRepository extends JpaRepository<Mapa, Short> {
}
