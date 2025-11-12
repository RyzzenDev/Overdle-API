package com.overdaily.Overdaily.Repository;

import com.overdaily.Overdaily.entity.Gun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GunRepository extends JpaRepository<Gun, Integer> {
    Optional<Gun> findById(Integer ID);
}
