package com.group.service;

import com.group.entity.Player;
import com.group.entity.Request;
import com.group.entity.Team;
import com.group.entity.TeamUpdateDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class TeamServiceImpl implements TeamService {

    @PersistenceContext
    private EntityManager em;
    @Override
    public void clearList() {
        Query deleteFromPlayer = em.createNamedQuery("Team.clearAll");
        deleteFromPlayer.executeUpdate();
    }
    public List<Player> getAllByBuilder() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Player> query = builder.createQuery(Player.class);
        Root<Player> from  = query.from(Player.class);
        TypedQuery<Player> q = em.createQuery(query.select(from));
        return q.getResultList();
    }

    @Override
    public void addToList(Team team) {
        em.persist(team);
    }

    @Override
    public Team getById(Long id) {
        return em.find(Team.class, id);
    }

    @Override
    public Team updateTeam(TeamUpdateDto dto, Team teamToUpdate) {
        if (dto.getTeamName() != null) {
            teamToUpdate.setTeamName(dto.getTeamName());
        }

        if (dto.getLeague() != null) {
            teamToUpdate.setLeague(dto.getLeague());
        }

        em.merge(teamToUpdate);
        return teamToUpdate;
    }

    @Override
    public List<Request> getAllRequests() {
        return em.createNamedQuery("Request.findAll", Request.class)
                .getResultList();
    }
}
