package com.sb.players_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.players_app.beans.Player;
import com.sb.players_app.service.PlayerService;

@CrossOrigin("*")
@RestController
@RequestMapping("plr_directory")
public class PlayerController {

	PlayerService ps;

	@Autowired
	public PlayerController(PlayerService ps) {
		this.ps = ps;
	}

	@GetMapping("/players")
	public List<Player> findAllPlayers() {
		return ps.getAllPlayers();
	}

	@GetMapping("/players/{plrId}")
	public Player getPlayerById(@PathVariable long plrId) {
		Player plr = ps.findById(plrId);
		if (plr == null) {
			throw new RuntimeException("Player not found with ID = " + plrId);
		}
		return plr;
	}

	@DeleteMapping("/players/{plrId}")
	@Transactional
	public void deletePlayerById(@PathVariable long plrId) {
		ps.deleteById(plrId);
		System.out.println("Deleted the player" + plrId);
	}

	@PostMapping(path = "/players", consumes = "application/json", produces = "application/json")
	@Transactional
	public void createPlayer(@RequestBody Player player) {
		ps.createPlayer(player);
		System.out.println("Created the player" + player.getName());
	}

	@PatchMapping(path = "/players/{plrId}", consumes = "application/json", produces = "application/json")
	@Transactional
	public void updatePlayer(@RequestBody Player player) {
		ps.updatePlayer(player);
	}
}
