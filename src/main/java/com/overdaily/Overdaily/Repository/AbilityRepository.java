package com.overdaily.Overdaily.Repository;

import com.overdaily.Overdaily.model.Ability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AbilityRepository extends JpaRepository <Ability, Integer>{
    Optional<Ability> findById(Integer ID);
}
