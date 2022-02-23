package com.hangman.game.model;

import javax.persistence.*;

@Entity
@Table(name = "words")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 16, unique = true)
    private String value;

    public Word() {
    }

    public Word(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public Word setId(Long id) {
        this.id = id;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Word setValue(String value) {
        this.value = value;
        return this;
    }
}
