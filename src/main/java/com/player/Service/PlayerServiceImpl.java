package com.player.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.player.Entity.Player;
import com.player.Repository.PlayerRepo;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

public class PlayerServiceImpl implements PlayerService{

	
	PlayerRepo plrpo;
	
	@Autowired
	public PlayerServiceImpl(PlayerRepo plrpo) {
		this.plrpo=plrpo;
		
		
	}
	
	@Override
	public List<Player> getAllPlayer() {
		return plrpo.findAll();
	}

	

	@Override
	public Player deletePlayer(long id) {
		plrpo.deleteById(id);
		return null;
		
	}

	@Override
	public void savePlayer(Player player) {
		plrpo.save(player);
		
	}

	@Override
	public Player findById(long playerid) {
		Player p=null;
		java.util.Optional<Player> plr=plrpo.findById(playerid);
		if(plr.isPresent()) {
			p=plr.get();
		}
		return p;
		
	}

	
}
