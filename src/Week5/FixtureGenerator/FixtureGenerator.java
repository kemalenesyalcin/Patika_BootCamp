package Week5.FixtureGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FixtureGenerator {
    private List<String> teams;
    private List<String> fixtures;

    public FixtureGenerator(List<String> teams) {
        this.teams = teams;
        this.fixtures = new ArrayList<>();
    }

    public void generateFixtures() {
        if (teams.size() % 2 != 0) {
            teams.add("Bay");
        }

        int totalRounds = teams.size() - 1;
        int matchesPerRound = teams.size() / 2;

        List<String> homeTeams = new ArrayList<>(teams.subList(0, matchesPerRound));
        List<String> awayTeams = new ArrayList<>(teams.subList(matchesPerRound, teams.size()));
        Collections.reverse(awayTeams);

        for (int round = 1; round <= totalRounds; round++) {
            System.out.println("Round " + round);
            for (int match = 0; match < matchesPerRound; match++) {
                String homeTeam = homeTeams.get(match);
                String awayTeam = awayTeams.get(match);
                String matchStr = homeTeam + " vs " + awayTeam;
                fixtures.add(matchStr);
                System.out.println(matchStr);
            }

            String lastHomeTeam = homeTeams.remove(homeTeams.size() - 1);
            awayTeams.add(1, lastHomeTeam);
            homeTeams.add(1, awayTeams.remove(awayTeams.size() - 1));
        }
    }

    public static void main(String[] args) {
        List<String> teams = new ArrayList<>();
        teams.add("Galatasaray");
        teams.add("Bursaspor");
        teams.add("Fenerbahçe");
        teams.add("Beşiktaş");
        teams.add("Başakşehir");
        teams.add("Trabzonspor");

        FixtureGenerator generator = new FixtureGenerator(teams);
        generator.generateFixtures();
    }
}
