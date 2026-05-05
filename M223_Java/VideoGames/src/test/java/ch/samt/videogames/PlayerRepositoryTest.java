package ch.samt.videogames;

import ch.samt.videogames.domain.*;
import ch.samt.videogames.data.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private GameProfileRepository profileRepository;

    @Test
    void testCreatePlayerWithRelations() {

        Team team = new Team();
        team.setName("TestTeam");
        team.setDeleted(false);
        team = teamRepository.save(team);

        GameProfile profile = new GameProfile();
        profile.setGameName("TestGame");
        profile.setLevel(10);

        Player player = new Player();
        player.setNickname("TestPlayer");
        player.setDeleted(false);
        player.setTeam(team);
        player.setProfile(profile);

        Player saved = playerRepository.save(player);

        assertNotNull(saved.getId());
        assertEquals("TestTeam", saved.getTeam().getName());
    }

    @Test
    void testSoftDeletePlayer() {

        Player player = new Player();
        player.setNickname("DeleteMe");
        player.setDeleted(false);

        player = playerRepository.save(player);

        player.setDeleted(true);
        playerRepository.save(player);

        Player found = playerRepository.findById(player.getId()).orElseThrow();

        assertTrue(found.isDeleted());
    }

    @Test
    void testTeamWithPlayers() {

        Team team = new Team();
        team.setName("TeamX");
        team.setDeleted(false);

        Player p1 = new Player();
        p1.setNickname("P1");
        p1.setDeleted(false);
        p1.setTeam(team);

        Player p2 = new Player();
        p2.setNickname("P2");
        p2.setDeleted(false);
        p2.setTeam(team);

        team.setPlayers(java.util.List.of(p1, p2));

        Team saved = teamRepository.save(team);

        assertEquals(2, saved.getPlayers().size());
    }

    @Test
    void testOneToOneProfile() {

        GameProfile profile = new GameProfile();
        profile.setGameName("LoL");
        profile.setLevel(20);
        profile.setDeleted(false);

        Player player = new Player();
        player.setNickname("SoloPlayer");
        player.setDeleted(false);
        player.setProfile(profile);

        Player saved = playerRepository.save(player);

        assertNotNull(saved.getProfile());
        assertEquals("LoL", saved.getProfile().getGameName());
    }
}