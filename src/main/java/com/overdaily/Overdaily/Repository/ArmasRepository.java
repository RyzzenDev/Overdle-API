package com.overdaily.Overdaily.Repository;

import com.overdaily.Overdaily.model.Armas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmasRepository extends JpaRepository<Armas, Short> {

}
