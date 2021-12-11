package com.player.player;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.player.Entity.Player;
import com.player.Service.PlayerService;

@RestController
@RequestMapping("/infy")
public class PlayerController {

	PlayerService ps;
	@Autowired
	public PlayerController(PlayerService ps) {
		this.ps=ps;
		
	}
	
	@GetMapping("/players")
	List<Player> getAll(){
		return ps.getAllPlayer();
	}
	
	@GetMapping("/players/{Playerid}")
	public Player getPlayer(@PathVariable long Playerid) {
		Player player=ps.findById(Playerid);
		if(player==null) {
			throw new RuntimeException("Player not found with this id: "+Playerid);
		}
		return player;
	}
	@PostMapping("/player/{Playerid}")
	@Transactional
	public Player addPlayer(@RequestBody Player player) {
		ps.savePlayer(player);
		return player;
	}
	@DeleteMapping("Player/{PlayerId}")
	@Transactional
	public String deletePlayer(@PathVariable long PlayerId) {
		Player player=ps.deletePlayer(PlayerId);
		if(player==null) {
			throw new RuntimeException("Player with "+PlayerId+" not found deletion is not possible ");
		}
		ps.deletePlayer(PlayerId);
		return "Deletion is DONE sucessfully with "+PlayerId+" id";
	}
	
}
