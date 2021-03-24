package com.sda.spring.data.jpa.associations;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "father")
public class Father {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "father_id")
    private List<Son> sons = new ArrayList<>();

    public Father() {
    }

    public Father(String name) {
        this.name = name;
    }

    public void addSon(Son son) {
        sons.add(son);
    }

    public void deleteSon(Son son) {
        sons.remove(son);
    }

    @Override
    public String toString() {
        return "Father{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
