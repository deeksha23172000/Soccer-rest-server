package com.group.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "League.findAll", query = "SELECT l FROM League l")
@NamedQuery(name = "League.getByLeagueName", query = "SELECT l from League l where l.leagueName = :leagueName")
@NamedQuery(name = "League.clearAll", query = "DELETE FROM League")
public class League implements Serializable {
    @Id
    private Long id;
    private String leagueName;

    @OneToMany
    private List<Team> teamList;

    @OneToMany(mappedBy = "league", fetch = FetchType.EAGER)
    private List<Request> requestList;

    public League(String leagueName) {
        this.leagueName = leagueName;
    }

    @Override
    public String toString() {
        return "League{" +
                "leagueName='" + leagueName + '\'' +
                '}';
    }
}
