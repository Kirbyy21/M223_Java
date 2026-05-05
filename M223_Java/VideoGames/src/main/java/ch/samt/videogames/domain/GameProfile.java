package ch.samt.videogames.domain;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
public class GameProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profile_seq")
    @SequenceGenerator(name = "profile_seq", allocationSize = 1)
    Long id;

    @NotBlank
    @Size(min = 2, max = 30, message = "Lenght beetwen 2 and 30 characters")
    String gameName;

    @NotNull
    @Min(1)
    @Max(999999999)
    int level;

    boolean deleted = false;

    @OneToOne(mappedBy = "profile")
    private Player player;


}