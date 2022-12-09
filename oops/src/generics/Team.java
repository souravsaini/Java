package generics;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team <T>> {
	private String name;
	int played  = 0;
	int won = 0;
	int lost = 0;
	int tied = 0;
	
	private ArrayList<T> players = new ArrayList<>();

	public Team(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean addPlayer(T player) {
		if(players.contains(player)) {
			System.out.println(player.getName() + " is already in the team");
			return false;
		}
		players.add(player);
		System.out.println(player.getName() + " added to the team");
		return true;
	}
	
	public int numberOfPlayers() {
		return this.players.size();
	}
	
	public void matchResult(Team opponent, int ourScore, int theirScore) {
		if(ourScore > theirScore) won++;
		else if(ourScore == theirScore) lost++;
		else lost++;
		
		played++;
		if(opponent != null) {
			opponent.matchResult(null, theirScore, ourScore);
		}
	}
	
	public int ranking() {
		return (won * 2) + tied;
	}

	@Override
	public int compareTo(Team<T> team) {
		if(this.ranking() > team.ranking()) {
			return -1;
		} else if(this.ranking() < team.ranking()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	
}
