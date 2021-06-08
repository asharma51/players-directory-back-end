package com.sb.players_app.service;

import java.util.List;

import com.sb.players_app.beans.Player;

public interface PlayerService {
	List<Player> getAllPlayers();

	Player findById(long id);

	void deleteById(long id);

	void createPlayer(Player player);

	void updatePlayer(Player player);
}
