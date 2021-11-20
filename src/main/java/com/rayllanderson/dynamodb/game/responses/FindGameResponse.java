package com.rayllanderson.dynamodb.game.responses;

import com.rayllanderson.dynamodb.game.models.Game;

public class FindGameResponse {
    private final String id;
    private final String name;
    private final String status;

    public FindGameResponse(String id, String name, String status) {
        this.id = id;
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

    public static FindGameResponse fromModel(Game game) {
        return new FindGameResponse(game.getId(), game.getName(), game.getStatus());
    }

    @Override
    public String toString() {
        return "FindGameResponse{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", status='" + status + '\'' + '}';
    }
}
