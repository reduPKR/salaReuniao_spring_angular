package com.sala_reuniao.salaDeReuniao.model;

import javax.persistence.*;

@Entity
@Table(name="mettingroom")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String starHour;

    @Column(nullable = false)
    private String endHour;

    public Room(long id, String name, String date, String starHour, String endHour) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.starHour = starHour;
        this.endHour = endHour;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStarHour() {
        return starHour;
    }

    public void setStarHour(String starHour) {
        this.starHour = starHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", starHour='" + starHour + '\'' +
                ", endHour='" + endHour + '\'' +
                '}';
    }
}
