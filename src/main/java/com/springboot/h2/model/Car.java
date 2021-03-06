package com.springboot.h2.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @NonNull
    public Employee employee;

    @EqualsAndHashCode.Exclude
    @NotEmpty
    private String name;

    @EqualsAndHashCode.Exclude
    @NotEmpty
    private String model;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude

    private LocalDate registrationDate;
}

