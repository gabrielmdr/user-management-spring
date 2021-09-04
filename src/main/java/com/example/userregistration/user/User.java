package com.example.userregistration.user;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "basic_user")
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String name;
    private LocalDate birthdate;
    private String photo;

    public User() {}

    public User(String name, LocalDate birthdate, String photo) {
        this.name = name;
        this.birthdate = birthdate;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User { id: " + id + ", name: " + name + ", birthdate: " + birthdate + ", photo: " + photo + " }";
    }
}
