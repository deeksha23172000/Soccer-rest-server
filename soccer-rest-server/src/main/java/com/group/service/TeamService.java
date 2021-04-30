package com.group.service;

import com.group.entity.Team;
import com.group.entity.TeamUpdateDto;
import com.group.entity.Request;
import java.util.List;

public interface TeamService {

    void clearList();

    void addToList(Team team);
    Team getById(Long id);
    Team updateTeam(TeamUpdateDto dto, Team teamToUpdate);
    List<Request> getAllRequests();
}
