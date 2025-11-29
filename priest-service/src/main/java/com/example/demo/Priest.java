package com.example.demo;

import com.example.demo.parish.*;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "priests")
public class Priest implements Serializable, Comparable<Priest> {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parish_id", nullable = false)
    private SimplifiedParish parish;

    // constructors and builder
    protected Priest() {

    }
    private Priest(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
    }

    public static class Builder {
        private UUID id;
        private String name;
        private int age;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Priest build() {
            return new Priest(this);
        }
    }

    // getters and setters
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public SimplifiedParish getParish() {
        return parish;
    }
    public void setParish(SimplifiedParish parish) {
        this.parish = parish;
    }

    // general methods
    @Override
    public String toString() {
        return "Priest{id=" + id + ", name='" + name + "', age=" + age + ", parish='" + (parish != null ? parish.getName() : "none") + "'}";
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Priest p)) return false;
        if (id == null || p.id == null) {
            return age == p.age && Objects.equals(name, p.name);
        }
        return id.equals(p.id);
    }
    @Override
    public int compareTo(Priest o) {
        return this.name.compareTo(o.name);
    }
}
