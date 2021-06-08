package com.sb.players_app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sb.players_app.beans.Player;

@Repository
public class PlayerRepoImpl implements PlayerRepo {

	EntityManager em;

	@Autowired
	public PlayerRepoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Player> getAllPlayers() {
		return em.createQuery("from Player").getResultList();
	}

	@Override
	public Player findById(long id) {
		return em.find(Player.class, id);
	}

	@Override
	public void deleteById(long id) {
		em.remove(findById(id));
	}

	@Override
	public void createPlayer(Player player) {
		em.persist(player);
	}

	@Override
	public void updatePlayer(Player player) {
		em.merge(player);
	}

}
