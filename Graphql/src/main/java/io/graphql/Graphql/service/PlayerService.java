package io.graphql.Graphql.service;

import io.graphql.Graphql.model.Player;
import io.graphql.Graphql.model.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    private List<Player> players=new ArrayList<>();
    AtomicInteger id=new AtomicInteger(0);

    public List<Player> findAll(){
        return players;
    }

    public Optional<Player> findOne(Integer id){
        return players.stream().filter(i->i.id().equals(id)).
                findFirst();
    }
    public Player createPlayer(String name, Team team){
        Player player=new Player(id.incrementAndGet(),name,team);
        players.add(player);
        return player;
    }
    public Player deletePlayer(Integer id){
        Player player=players.stream().filter(i->i.id().equals(id)).findFirst().orElseThrow(()->new IllegalArgumentException("Player not found"));
        players.remove(player);
        return player;
    }
    public Player update(Integer id, String name, Team team){
        Player updatedPlayer=new Player(id,name,team);
       Optional<Player> player= players.stream().filter(i->i.id().equals(id)).findFirst();
       if(player.isPresent()){
           int index=players.indexOf(player.get());
           players.set(index,updatedPlayer);
       }
       else{
           throw new IllegalArgumentException("Player not found");
       }
       return updatedPlayer;
    }
}
