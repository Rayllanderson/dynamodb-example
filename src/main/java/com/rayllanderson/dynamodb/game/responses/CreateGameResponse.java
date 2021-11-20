package com.rayllanderson.dynamodb.game.responses;

import com.rayllanderson.dynamodb.game.GameStatusDto;
import com.rayllanderson.dynamodb.game.models.Game;

public class CreateGameResponse {
    private final String id;
    private final String name;
    private final GameStatusDto gameStatus;

    public CreateGameResponse(String id, String name, GameStatusDto gameStatus) {
        this.id = id;
        this.name = name;
        this.gameStatus = gameStatus;
    }

    public static CreateGameResponse fromModel(Game game) {
        return new CreateGameResponse(game.getId(), game.getName(), GameStatusDto.fromString(game.getStatus().toString()));
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public GameStatusDto getGameStatus() {
        return gameStatus;
    }
}
