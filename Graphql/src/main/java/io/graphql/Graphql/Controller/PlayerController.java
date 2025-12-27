package io.graphql.Graphql.Controller;

import io.graphql.Graphql.model.Player;
import io.graphql.Graphql.model.Team;
import io.graphql.Graphql.service.PlayerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @QueryMapping
    public List<Player> findAll(){
       return playerService.findAll();
    }
    @MutationMapping
    public Player createPlayer(@Argument String name, @Argument Team team){
        return playerService.createPlayer(name,team);
    }
    @MutationMapping
    public Player updatePlayer(@Argument Integer id, @Argument String name, @Argument Team team){
        return playerService.update(id, name,team);
    }
}