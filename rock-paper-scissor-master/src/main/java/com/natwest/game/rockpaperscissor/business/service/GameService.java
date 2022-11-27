package com.natwest.game.rockpaperscissor.business.service;

import com.natwest.game.rockpaperscissor.business.exception.GameNotFoundException;
import com.natwest.game.rockpaperscissor.business.exception.GameOverException;
import com.natwest.game.rockpaperscissor.business.enums.Choice;
import com.natwest.game.rockpaperscissor.business.model.Game;

public interface GameService {

    Game start(String playerOneName, String playerTwoName);

    Game getStatus(Long id) throws GameNotFoundException;

    Game play(Long id, Choice playerOneChoice, Choice playerTwoChoice) throws GameNotFoundException, GameOverException;
}
