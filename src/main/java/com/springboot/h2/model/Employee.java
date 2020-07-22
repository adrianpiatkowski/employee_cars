package com.springboot.h2.model;

import lombok.*;
import org.hibernate.annotations.Target;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @EqualsAndHashCode.Exclude
    @NotEmpty
    private String firstName;

    @EqualsAndHashCode.Exclude
    @NotEmpty
    private String lastName;

    @EqualsAndHashCode.Exclude
    @NotEmpty
    private String address;

    @EqualsAndHashCode.Exclude
    @NotEmpty
    private String city;

    @EqualsAndHashCode.Exclude
    @Min(value = 18)
    @Max(value = 80)
    private double age;

    @EqualsAndHashCode.Exclude
    @NotNull
    @Min(value = 1800)
    private double salary;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @EqualsAndHashCode.Exclude
    @NotNull
    private LocalDate startJobDate = LocalDate.now();

    @EqualsAndHashCode.Exclude
    @Min(0)
    @Max(5)
    private int benefit;

    @EqualsAndHashCode.Exclude
    @Email
    @NotEmpty
    private String email;
    
    @OneToMany(mappedBy = "employee", cascade=CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Car> cars;
}

