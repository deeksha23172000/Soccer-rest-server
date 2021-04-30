package com.group.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t")
@NamedQuery(name = "Team.getByTeamName", query = "SELECT t from Team t where t.teamName = :teamName")
@NamedQuery(name = "Team.clearAll", query = "DELETE FROM Team")
public class Team implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String teamName;
    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    private List<Player> playerList;

    private Time nextGameTime;
    private String league;

    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    private List<Request> requestList;

    public Team(String teamName, Time nextGameTime, String league) {
        this.teamName = teamName;
        this.nextGameTime = nextGameTime;
        this.league = league;
    }
    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", nextGameTime='" + nextGameTime + '\'' +
                ", league='" +league + '\''+
                '}';
    }
}
