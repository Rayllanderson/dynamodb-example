package com.rayllanderson.dynamodb.game.requests;

import com.rayllanderson.dynamodb.game.GameStatusDto;
import com.rayllanderson.dynamodb.game.models.Game;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateGameRequest {
    @NotEmpty
    private final String name;

    @NotNull
    private final GameStatusDto status;

    public CreateGameRequest(String name, GameStatusDto gameStatus) {
        this.name = name;
        this.status = gameStatus;
    }

    public String getName() {
        return name;
    }

    public GameStatusDto getStatus() {
        return status;
    }

    public Game toModel() {
        return new Game(this.name, this.status.toModel().toString());
    }

    @Override
    public String toString() {
        return "CreateGameRequest{" + "name='" + name + '\'' + ", status=" + status + '}';
    }
}
