package com.example.userregistration.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Base64;

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
    @JsonIgnore
    @JsonProperty(value="avatarBytes")
    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] avatar;
    private String avatarMime;

    public User() {}

    public User(String name, LocalDate birthdate, String avatar) {
        this.name = name;
        this.birthdate = birthdate;
        this.avatar = Base64.getDecoder().decode(avatar);
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

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    @JsonProperty(value="avatar")
    public String getAvatarBase64() {
        return Base64.getEncoder().encodeToString(avatar);
    }

    public String getAvatarMime() {
        return avatarMime;
    }

    public void setAvatarMime(String avatarMime) {
        this.avatarMime = avatarMime;
    }

    @Override
    public String toString() {
        return "User { id: " + id + ", name: " + name + ", birthdate: " + birthdate + " }";
    }
}
