package com.natwest.game.rockpaperscissor.business.dao;

import com.natwest.game.rockpaperscissor.business.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameDAO extends JpaRepository<Game, Long> {

}
