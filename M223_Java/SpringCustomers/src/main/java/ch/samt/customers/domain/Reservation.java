package ch.samt.customers.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_seq")
    @SequenceGenerator(name = "reservation_seq", allocationSize = 1)
    Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    Customer customer;

    @NotBlank
    @Size(min = 1, max = 3, message = "Room numbers beetwen 1 and 999")
    String room;

    @NotBlank
    @Size(min = 8, max = 16, message = "Checkin date from 8 to 16 characters")
    String checkin;

    @NotBlank
    @Size(min = 8, max = 16, message = "Checkout date from 8 to 16 characters")
    String checkout;
}
