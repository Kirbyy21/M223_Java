package ch.samt.videogames.data;

import ch.samt.videogames.domain.GameProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameProfileRepository extends JpaRepository<GameProfile, Long> {
}
