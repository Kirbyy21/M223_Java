package ch.samt.videogames.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_seq")
    @SequenceGenerator(name = "player_seq", allocationSize = 1)
    private Long id;

    @NotBlank
    @Size(min = 2, message = "Beetwen 2 to 10 characters")
    private String nickname;

    private boolean deleted = false;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @Valid
    private Team team;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    @Valid
    private GameProfile profile;

}