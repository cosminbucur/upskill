package com.sda.spring.data.jpa.associations;

import javax.persistence.*;

@Entity
@Table(name = "son")
public class Son {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Son() {
    }

    public Son(String name) {
        this.name = name;
    }
}
