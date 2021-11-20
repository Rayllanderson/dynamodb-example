package com.rayllanderson.dynamodb.game;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.rayllanderson.dynamodb.game.models.GameStatus;

import java.util.Arrays;

public enum GameStatusDto {
    ON_HOLD, PLAYING, COMPLETED;

    public GameStatus toModel() {
        return GameStatus.valueOf(this.name());
    }

    @JsonCreator
    public static GameStatusDto fromString(String value) {
        try {
            return GameStatusDto.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Game status inválido. Valores válidos: " + Arrays.toString(GameStatusDto.values()));
        }
    }
}
