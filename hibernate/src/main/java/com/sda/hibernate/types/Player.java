package com.sda.hibernate.types;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "player")
public class Player {

    // need id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    // string
    private String username;

    // temporal
    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    // primitive
    private int age;

    // enum
    @Enumerated(EnumType.STRING)
    private Status status;

    // embedded
    @Embedded
    private Address address;

    // need default constructor
    public Player() {
    }

    public Long getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
