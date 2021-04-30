package com.group.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p")
@NamedQuery(name = "Player.getByFirstName", query = "SELECT p from Player p where p.firstName = :firstName")
@NamedQuery(name = "Player.clearAll", query = "DELETE FROM Player")
public class Player implements Comparable<Player>, Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    @Column(unique = true)
    private String lastName;
    private Date dateOfBirth;
    private Date signedUpDate;

    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
    private List<Request> requestList;


    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @PrePersist
    void createdAt() {
        this.signedUpDate = new Date();
        this.dateOfBirth = new Date();
    }

    @PreUpdate
    void updatedAt() {
        this.signedUpDate = new Date();
        this.dateOfBirth = new Date();
    }
    @Override
    public String toString() {
        return "Player{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Player o) {
        return signedUpDate.compareTo(o.signedUpDate);
    }
}
