package com.overdaily.Repository;

import com.overdaily.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HeroRepository extends JpaRepository <Hero, Integer>{
    //REPOSITORIO DO REDIS
    @Query("SELECT p FROM Hero p " +
            "LEFT JOIN FETCH p.heroGun " +
            "LEFT JOIN FETCH p.heroVoiceline " +
            "LEFT JOIN FETCH p.heroAbility")
    List<Hero> findAllWithDetails();
    //REPOSITORIO DO REDIS

    Optional<Hero> findById(Integer Id);
    List<Hero> findAll();
}
