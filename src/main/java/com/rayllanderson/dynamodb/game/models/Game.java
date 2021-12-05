package com.rayllanderson.dynamodb.game.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@DynamoDBTable(tableName = "Games")
public class Game {

    @Id
    @DynamoDBHashKey(attributeName = "id")
    private String id;

    @DynamoDBRangeKey(attributeName = "status")
    private String status;

    @DynamoDBAttribute(attributeName = "name")
    private String name;

    @Deprecated(since = "0.0.1")
    public Game() { }

    public Game(String name, String status) {
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

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static Game withId(String id) {
        var game = new Game();
        game.setId(id);
        return game;
    }

    @Override
    public String toString() {
        return "Game{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", status='" + status + '\'' + '}';
    }
}
