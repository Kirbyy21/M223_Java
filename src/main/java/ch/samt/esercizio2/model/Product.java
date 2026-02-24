package ch.samt.esercizio2.model;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class Product {

    @NotNull(message = "ID required")
    @Positive(message = "ID must be greater than 0")
    private Integer id;

    @NotBlank(message = "Name required")
    @Size(min = 2, max = 100, message = "Name lenght must be beetwen 2 and 100 letters")
    private String name;

    @NotBlank(message = "Description required")
    private String description;

    @NotNull(message = "Price required")
    @Positive(message = "Price must be greater or equal to 0")
    private Double price;

    @NotNull(message = "Date required")
    @FutureOrPresent(message = "Date must be in the past or future")
    private LocalDate expirationDate;

    public Product() {}

    public Product(Integer id, String name, String description, Double price, LocalDate expirationDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.expirationDate = expirationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}