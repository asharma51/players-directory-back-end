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
	
	@GetMapping("/reset")
	@Transactional
	public List<Player> resetData() {
		//clear data first
		ps.deleteAllPlayers();
		
		//create new players
		Player roger = new Player (1,"Roger Federer", "Switzerland", "https://specials-images.forbesimg.com/imageserve/5ee0b74d0378300006626097/960x0.jpg?fit=scale");
		Player serena = new Player (2, "Serena Williams", "United States","https://images.teamusa.org/-/media/TeamUSA/Tennis/Williams_Serena/Williams_Serena_09032020_1440x810.jpg?h=810&la=en&w=1440&hash=2C8BB4CEFAD78AE22CA67B031A7B95DF31043313" );
		Player novak = new Player(3, "Novak Djokovic", "Serbia", "https://upload.wikimedia.org/wikipedia/commons/7/7a/Novak_Djokovic_Queen%27s_Club_2018.jpg");
		Player rafael = new Player (4, "Rafael Nadal", "Spain", "https://www.lovetennis.com/wp-content/uploads/2020/10/rafa-nadal-scaled.jpg");
		Player naomi = new Player( 5, "Naomi Osaka", "Japan", "https://cdn-media.theathletic.com/cdn-cgi/image/fit=cover,width=700,height=466/uBNZH0RUbRIg_25zJnDKh08wM_1440x.960.jpg");
		ps.createPlayer(roger);
		ps.createPlayer(serena);
		ps.createPlayer(novak);
		ps.createPlayer(rafael);
		ps.createPlayer(naomi);
		
		System.out.println("Database is Reset");
		return findAllPlayers();
	}

	@PatchMapping(path = "/players/{plrId}", consumes = "application/json", produces = "application/json")
	@Transactional
	public void updatePlayer(@RequestBody Player player) {
		ps.updatePlayer(player);
	}
}
