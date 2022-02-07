package com.example.GreetingApp.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "GREETING")
public class Greeting {

    @Id
    @Column(name = "id", nullable = false)

    private final long id;
    private String message;

    public Greeting(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Greeting() {
        id = 0;
        message = "";
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
