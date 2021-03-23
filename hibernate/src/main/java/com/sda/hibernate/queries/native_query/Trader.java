package com.sda.hibernate.queries.native_query;

import javax.persistence.*;

@NamedNativeQuery(
        name = "Trader.findByName",
        query = "SELECT * FROM trader t where t.name = :name",
        resultClass = Trader.class)
@Entity(name = "Trader")
@Table(name = "trader")
public class Trader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Trader() {
    }

    public Trader(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
