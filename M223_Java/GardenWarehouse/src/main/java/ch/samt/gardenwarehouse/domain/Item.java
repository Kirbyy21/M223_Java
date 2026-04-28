package ch.samt.gardenwarehouse.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "garden_seq")
    @SequenceGenerator(name = "garden_seq", sequenceName = "garden_seq", allocationSize = 1)
    private Long id;

    @Pattern(regexp = "[a-z]{3}-\\d{2}", message = "Format: abc-12")
    private String code;

    @NotBlank
    @Size(min = 2, max = 50, message = "Beetwen 2 to 50 letters")
    private String type;

    @NotBlank
    @Size(min = 2, max = 50, message = "Beetwen 2 to 50 letters")
    private String name;

    @NotNull
    private Double price;

    @NotNull
    private Integer itemCount;
}
