package com.player.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.player.Entity.Player;

public interface PlayerRepo extends JpaRepository<Player,Long >{
	
}
