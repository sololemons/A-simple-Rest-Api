package com.Jurson.Dunkos.ENTITY;


import jakarta.persistence.*;

@Entity
@Table(name = "PERSON")
public class Person {
    @Id

    @Column(name = "ID")
    private int id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name="LAST_NAME")
    private String last_name;
    @Column(name="State")
    private String state;
    @Column(name = "AGE")
    private int Age;

    public Person(int id, String first_name, String last_name, String state, int age) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.state = state;
        Age = age;
    }

    public Person() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", state='" + state + '\'' +
                ", Age=" + Age +
                '}';
    }
}
