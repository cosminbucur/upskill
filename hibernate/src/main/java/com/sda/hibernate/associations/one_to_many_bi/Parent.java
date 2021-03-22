package com.sda.hibernate.associations.one_to_many_bi;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parent")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(
            mappedBy = "parent",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Child> children = new ArrayList<>();

    public Parent() {
    }

    public Parent(String name) {
        this.name = name;
    }

    // helper methods
    public void addChild(Child child) {
        // add child to parent
        children.add(child);
        // set parent to child
        child.setParent(this);
    }

    public void removeChild(Child child) {
        // remove child from parent
        children.remove(child);
        // remove parent from child
        child.setParent(null);
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

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
