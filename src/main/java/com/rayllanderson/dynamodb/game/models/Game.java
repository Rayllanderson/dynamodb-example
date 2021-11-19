package com.rayllanderson.dynamodb.game.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@DynamoDBTable(tableName = "games")
public class Game {

    @Id
    @DynamoDBHashKey(attributeName = "id")
    private String id;

    @DynamoDBAttribute(attributeName = "name")
    private String name;

    @DynamoDBAttribute(attributeName = "status")
    private GameStatus status;

    @Deprecated(since = "0.0.1")
    public Game() { }

    public Game(String name, GameStatus status) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public GameStatus getStatus() {
        return status;
    }
}
