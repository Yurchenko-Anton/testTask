package parse_and_MVP.mvp;

import players.interfaces.Player;

import java.util.Comparator;
import java.util.HashMap;

public class MVP {
    public static Player findMVP(HashMap<String, Player> players) {
        return players.entrySet().stream()
                .max(Comparator.comparing(stringPlayerEntry -> stringPlayerEntry.getValue().getScore()))
                .get().getValue();
    }
}
