package com.natwest.game.rockpaperscissor.business.dao;

import com.natwest.game.rockpaperscissor.business.model.Round;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoundDAO extends JpaRepository<Round, Long> {

}
