package com.overdaily.Overdaily.Repository;

import com.overdaily.Overdaily.model.Habilidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadesRepository extends JpaRepository <Habilidades, Short>{
}
