package com.rayllanderson.dynamodb.game.repository;

import com.rayllanderson.dynamodb.game.models.Game;
import com.rayllanderson.dynamodb.game.models.GameStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository {

    void save (Game game);
    Optional<Game> findByIdAndStatus(String id, GameStatus status);
    List<Game> findAllById(String gameId);
}
