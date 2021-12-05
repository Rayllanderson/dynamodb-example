package com.rayllanderson.dynamodb.game.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.rayllanderson.dynamodb.game.models.Game;
import com.rayllanderson.dynamodb.game.models.GameStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class GameRepositoryImpl implements GameRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public GameRepositoryImpl(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    @Override
    public void save(Game game) {
        dynamoDBMapper.save(game);
    }

    @Override
    public Optional<Game> findByIdAndStatus(String id, GameStatus status) {
        return Optional.ofNullable(dynamoDBMapper.load(Game.class, id, status.toString()));
    }

    @Override
    public List<Game> findAllById(String gameId) {
        return dynamoDBMapper.query(Game.class, new DynamoDBQueryExpression<Game>().withHashKeyValues(Game.withId(gameId)));
    }
}
