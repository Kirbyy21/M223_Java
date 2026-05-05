package ch.samt.videogames.Service;

import ch.samt.videogames.data.PlayerRepository;
import ch.samt.videogames.domain.Player;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository repo;

    public PlayerService(PlayerRepository repo) {
        this.repo = repo;
    }


    public List<Player> findAll() {
        return repo.findAll();
    }

    /*
    public Player update(Player p) {
        return repo.save(p);
    }

    public Player create(Player p) {
        return repo.save(p);
    }
    public void softDelete(Long id) {
        Player p = repo.findById(id).orElseThrow();
        p.setDeleted(true);
        repo.save(p);
    }*/
}
