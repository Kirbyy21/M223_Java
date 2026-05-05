package ch.samt.customers.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
    private Long id;

    @NotBlank
    @Size(min = 2, message = "Beetwen 2 to 10 letters")
    private String name;

    @NotBlank
    @Size(min = 2, max = 30, message = "Beetwen 2 to 30 letters")
    private String surname;

    @NotNull
    @Min(18)
    @Max(99)
    private Integer age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    @Valid
    private Address address;

    @ToString.Exclude
    @OneToMany (mappedBy = "customer", cascade = CascadeType.ALL)
    @Valid
    private List<Reservation> reservations;

    @ManyToMany
    @JoinTable(name = "customer_mealgroup",
                joinColumns = @JoinColumn(name = "customer_id"),
                inverseJoinColumns = @JoinColumn(name = "mealgroup_id"))
    @ToString.Exclude
    private List<MealGroup> mealGroups;
}
