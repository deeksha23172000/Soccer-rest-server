package com.group.service;

import com.group.entity.League;
import com.group.entity.Request;
import com.group.entity.Team;
import com.group.entity.TeamUpdateDto;

import java.util.List;

public interface LeagueService {
    void clearList();

    void addToList(League league);
    League getById(Long id);
    List<Request> getAllRequests();
}
