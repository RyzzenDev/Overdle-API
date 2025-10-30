package com.overdaily.Overdaily.Repository;

import com.overdaily.Overdaily.model.Voiceline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoicelineRepository extends JpaRepository<Voiceline, Integer> {
    Optional<Voiceline> findById(Integer ID);
}
