package com.luiz.gameawards.domain.model;

import org.springframework.data.jpa.repository.JpaRepository;


public interface GameRepository extends JpaRepository<Game, Long> {
    
}
