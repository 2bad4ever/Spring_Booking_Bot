package com.example.spring_booking_bot.models;

import javax.persistence.*;

@Entity
@Table(name = "telegram_user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "telegram_id")
    private String tgId;

    @Column(name = "name")
    private String name;

    // Конструкторы
    public UserModel() {
    }

    public UserModel(String username, String tgId, String name) {
        this.username = username;
        this.tgId = tgId;
        this.name = name;
    }

    // Геттеры и сеттеры
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTgId() {
        return tgId;
    }

    public void setTgId(String tgId) {
        this.tgId = tgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
