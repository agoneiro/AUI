package com.example.demo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "parishes")
public class Parish implements Serializable, Comparable<Parish>{
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private String city;

    // constructors and builder
    protected Parish() {

    }
    private Parish(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.city = builder.city;
    }

    public static class Builder {
        private UUID id;
        private String name;
        private String city;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Parish build() {
            return new Parish(this);
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
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    // general methods
    @Override
    public String toString() {
        return "Parish{id = " + id + ", name=" + name + ", city=" + city + "}";
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parish p)) return false;
        if (id == null || p.id == null) {
            return Objects.equals(name, p.name) && Objects.equals(city, p.city);
        }
        return id.equals(p.id);
    }
    @Override
    public int compareTo(Parish o) {
        if (o == null) return 1;
        return name.compareTo(o.name);
    }
}
