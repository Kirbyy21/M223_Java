package ch.samt.customers.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq", allocationSize = 1)
    Long id;

    @NotBlank
    @Size(min = 3, max = 30, message = "Lenght beetwen 3 and 30 characters")
    String street;

    @NotBlank
    @Size(min = 1, max = 5, message = "Only numbers beetwen 1 to 5 digits")
    String num;

    @NotBlank
    @Size(min = 4, max = 7, message = "Lenght beetwen 4 and 7 characters")
    String zip;

    @NotBlank
    @Size(min = 3, max = 30, message = "Lenght beetwen 3 and 30 characters")
    String city;

    @NotBlank
    @Size(min = 3, max = 30, message = "Lenght beetwen 3 and 30 characters")
    String nation;
}
