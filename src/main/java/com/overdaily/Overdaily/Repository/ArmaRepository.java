package com.overdaily.Overdaily.Repository;

import com.overdaily.Overdaily.model.Arma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArmaRepository extends JpaRepository<Arma, Short> {

}
