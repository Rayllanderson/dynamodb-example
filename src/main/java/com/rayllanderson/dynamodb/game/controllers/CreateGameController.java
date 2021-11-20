package com.rayllanderson.dynamodb.game.controllers;

import com.rayllanderson.dynamodb.game.requests.CreateGameRequest;
import com.rayllanderson.dynamodb.game.models.Game;
import com.rayllanderson.dynamodb.game.repository.GameRepository;
import com.rayllanderson.dynamodb.game.responses.CreateGameResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/games")
public class CreateGameController {
    private final GameRepository gameRepository;
    private final Logger log = LoggerFactory.getLogger(CreateGameController.class);

    public CreateGameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @PostMapping
    public ResponseEntity<CreateGameResponse> createGame(@Valid @RequestBody CreateGameRequest request, UriComponentsBuilder uriBuilder) {
        log.info("Creating new game= {}", request);

        var game = request.toModel();
        gameRepository.save(game);

        log.info("game saved successfully= {}", game);

        var uri = createUri(uriBuilder, game);
        return ResponseEntity.created(uri).body(CreateGameResponse.fromModel(game));
    }

    private URI createUri(UriComponentsBuilder uriBuilder, Game game) {
        return uriBuilder.path("/api/v1/games/{id}").build(game.getId());
    }
}
