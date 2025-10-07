package com.overdaily.Overdaily.Repository;

import com.overdaily.Overdaily.model.Habilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadeRepository extends JpaRepository <Habilidade, Short>{
}
