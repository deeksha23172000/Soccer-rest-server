package com.group.service;

import com.group.entity.League;
import com.group.entity.Player;
import com.group.entity.Request;
import com.group.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class LeagueServiceImpl implements LeagueService {

    @PersistenceContext
    private EntityManager em;
    @Override
    public void clearList() {
        Query deleteFromPlayer = em.createNamedQuery("League.clearAll");
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
    public void addToList(League league) {
        em.persist(league);
    }

    @Override
    public League getById(Long id) {
        return em.find(League.class, id);
    }

    @Override
    public List<Request> getAllRequests() {
        return em.createNamedQuery("Request.findAll", Request.class)
                .getResultList();
    }
}
