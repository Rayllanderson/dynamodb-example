package com.rayllanderson.dynamodb.game.controllers;

import com.rayllanderson.dynamodb.game.GameStatusDto;
import com.rayllanderson.dynamodb.game.repository.GameRepository;
import com.rayllanderson.dynamodb.game.responses.FindGameResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/games")
public class FindGameController {
    private final GameRepository gameRepository;
    private final Logger log = LoggerFactory.getLogger(FindGameController.class);

    public FindGameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }


    @GetMapping("/{id}")
    public ResponseEntity<List<FindGameResponse>> findAllById(@PathVariable String id) {
        log.info("Searching game id= {}", id);

        var games = gameRepository.findAllById(id);

        log.info("{} games with id = {}", games.size(), id);

        return ResponseEntity.ok(FindGameResponse.fromModelList(games));
    }

    @GetMapping("/{id}/{status}")
    public ResponseEntity<FindGameResponse> findByIdAndStatus(@PathVariable String id, @PathVariable String status) {
        log.info("Searching game id= {} and status = {} ", id, status);

        var game = gameRepository.findByIdAndStatus(id, GameStatusDto.valueOf(status.toUpperCase()).toModel())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        log.info("game found = {}", game);

        return ResponseEntity.ok(FindGameResponse.fromModel(game));
    }
}
