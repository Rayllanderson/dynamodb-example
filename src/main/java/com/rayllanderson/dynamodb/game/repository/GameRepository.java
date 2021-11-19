package com.rayllanderson.dynamodb.game.repository;

import com.rayllanderson.dynamodb.game.models.Game;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface GameRepository extends CrudRepository<Game, String> {

}
