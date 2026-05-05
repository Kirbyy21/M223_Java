package ch.samt.videogames.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "team_seq")
    @SequenceGenerator(name = "team_seq", allocationSize = 1)
    Long id;

    @NotBlank
    @Size(min = 2, message = "Beetwen 2 to 10 characters")
    String name;

    boolean deleted = false;

    @ToString.Exclude
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    @Valid
    List<Player> players;
}