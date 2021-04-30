package com.group.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Data
@NoArgsConstructor
@Entity
@NamedQuery(name = "Request.findAll", query = "SELECT r FROM Request r")
public class Request implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Lob
    @Column(length = 500)
    private String requestText;


    @ManyToOne
    @JoinColumn(name = "id_player")
    @JsonIgnore
    private Player player;

    @ManyToOne
    @JoinColumn(name = "id_team")
    @JsonIgnore
    private Team team;



    public Request(String requestText) {
        this.requestText = requestText;
    }
}
