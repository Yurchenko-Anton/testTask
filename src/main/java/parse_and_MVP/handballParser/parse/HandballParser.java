package parse_and_MVP.handballParser.parse;

import players.interfaces.Player;
import players.HandballPlayer;
import point_to_winner.PointToWinner;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;

public class HandballParser {
    static public final HashMap<String, Player> handballPlayers = new HashMap<>();

    public static void handBall(File file) throws IOException {
        HashMap<String, Integer> topPoint = new HashMap<>();
        List<String> lines = Files.readAllLines(file.toPath());
        for (String line : lines) {
            String[] fragments = line.split(";");
            if (fragments.length != 6) {
                continue;
            }
            int score = getScore(Integer.parseInt(fragments[4]), Integer.parseInt(fragments[5]));
            if (handballPlayers.get(fragments[1]) == null) {
                handballPlayers.put(fragments[1], new HandballPlayer(fragments[0], fragments[1],
                        fragments[3], score));
            } else {
                HandballPlayer handballPlayer = (HandballPlayer) handballPlayers.get(fragments[1]);
                handballPlayer.setTeamName(fragments[3]);
                handballPlayer.setScore(handballPlayer.getScore() + score);
                handballPlayers.put(fragments[1], handballPlayer);
            }
            if (topPoint.get(fragments[3]) == null) {
                topPoint.put(fragments[3], Integer.parseInt(fragments[4]));
            }
        }
        PointToWinner.getPointToWinner(topPoint, handballPlayers);
    }

    private static int getScore(int goals, int received) {
        int score = goals * 2 - received;
        if (score > 0) return score;
        else return 0;
    }
}
