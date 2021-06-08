package com.sb.players_app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.players_app.beans.Player;
import com.sb.players_app.repository.PlayerRepo;

@Service
public class PlayerServiceImpl implements PlayerService {

	PlayerRepo playerRepo;

	@Autowired
	public PlayerServiceImpl(PlayerRepo playerRepo) {
		this.playerRepo = playerRepo;
	}

	@Override
	public List<Player> getAllPlayers() {
		return playerRepo.getAllPlayers();
	}

	@Override
	public Player findById(long id) {
		return playerRepo.findById(id);
	}

	@Override
	public void deleteById(long id) {
		playerRepo.deleteById(id);
	}

	@Override
	public void createPlayer(Player player) {
		playerRepo.createPlayer(player);

	}

	@Override
	public void updatePlayer(Player player) {
		playerRepo.updatePlayer(player);

	}
}
