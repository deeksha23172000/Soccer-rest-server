package com.group.service;

import com.group.entity.Player;
import com.group.entity.PlayerUpdateDto;
import com.group.entity.Request;

import java.util.List;

public interface PlayerService {
    void clearList();

    List<Player> getPlayerList();

    List<Player> getWaitList();

    void addToList(Player player);
    void removeFromList(Player player);
    Player getById(Long id);
    Player updatePlayer(PlayerUpdateDto dto, Player playerToUpdate);
    void addPlayerRequest(String userName, Request request);
    List<Request> getAllRequests();
}
