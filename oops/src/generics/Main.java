package generics;

public class Main {
	public static void main(String[] args) {
		FootballPlayer p1 = new FootballPlayer("Ronaldo");
		FootballPlayer p2 = new FootballPlayer("Messi");
		FootballPlayer p3 = new FootballPlayer("Neymar");
		FootballPlayer p4 = new FootballPlayer("Mbappe");
		
		
		Team<FootballPlayer> team1 = new Team<>("Team One");
		team1.addPlayer(p1);
		team1.addPlayer(p2);
		System.out.println(team1.numberOfPlayers());
		
		Team<FootballPlayer> team2 = new Team<>("Team Two");
		team2.addPlayer(p3);
		team2.addPlayer(p4);
		
		team1.matchResult(team2, 2 , 0);
		System.out.println(team1.ranking());
		
		System.out.println(team1.compareTo(team2));
		
		
		League<Team<FootballPlayer>> footballLeague = new League<>("FIFA");
		footballLeague.add(team1);
		footballLeague.add(team2);
		footballLeague.showLeagueTable();
	}
}
