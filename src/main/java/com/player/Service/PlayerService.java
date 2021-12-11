package com.player.Service;

import java.util.List;

import com.player.Entity.Player;

public interface PlayerService {
	List<Player> getAllPlayer();
	public Player deletePlayer(long id);
	void savePlayer(Player player);
	public Player findById(long id);
}
