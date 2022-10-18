package point_to_winner;

import interfaces.Player;

import java.util.HashMap;
import java.util.Map;

public class PointToWinner {
    public static void getPointToWinner(HashMap<String, Integer> topPoint, HashMap<String, Player> players) {
        String team = topPoint.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        players.values().stream().filter(player -> player.getTeamName().equals(team))
                .forEach(player -> player.setScore(player.getScore() + 10));
    }
}
