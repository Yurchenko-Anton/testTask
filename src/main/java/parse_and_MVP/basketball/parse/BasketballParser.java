package parse_and_MVP.basketball.parse;

import players.interfaces.Player;
import players.BasketballPlayer;
import point_to_winner.PointToWinner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;

public class BasketballParser {
    static public final HashMap<String, Player> basketballPlayers = new HashMap<>();

    public static void basketBall(File file) throws IOException {
        HashMap<String, Integer> topPoint = new HashMap<>();
        List<String> lines = Files.readAllLines(file.toPath());
        for (String line : lines) {
            String[] fragments = line.split(";");
            if (fragments.length != 7) {
                continue;
            }
            int score = getScore(Integer.parseInt(fragments[4]), Integer.parseInt(fragments[5]), Integer.parseInt(fragments[6]));
            if (basketballPlayers.get(fragments[1]) == null) {
                basketballPlayers.put(fragments[1], new BasketballPlayer(fragments[0], fragments[1],
                        fragments[3], score));
            } else {
                BasketballPlayer basketballPlayer = (BasketballPlayer) basketballPlayers.get(fragments[1]);
                basketballPlayer.setTeamName(fragments[3]);
                basketballPlayer.setScore(basketballPlayer.getScore() + score);
                basketballPlayers.put(fragments[1], basketballPlayer);
            }
            topPoint.merge(fragments[3], Integer.parseInt(fragments[4]), Integer::sum);
        }
        PointToWinner.getPointToWinner(topPoint, basketballPlayers);

    }

    private static int getScore(int point, int rebounds, int assists) {
        return (point * 2) + rebounds + assists;
    }


}
