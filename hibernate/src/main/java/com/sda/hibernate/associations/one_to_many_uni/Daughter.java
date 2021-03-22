package com.sda.hibernate.associations.one_to_many_uni;

import javax.persistence.*;

@Entity
@Table(name = "daughter")
public class Daughter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Daughter() {
    }

    public Daughter(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
