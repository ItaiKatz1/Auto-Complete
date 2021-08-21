package io.javabrains.springbootquickstart.models;

import javax.persistence.*;


@Entity
@Table
public class people {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int aid;
    @Column
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAid() {
        return aid;
    }
}
