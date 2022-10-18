package players.interfaces;

public interface Player {
    String getName();

    String getNick();

    String getTeamName();

    Integer getScore();

    void setName(String name);

    void setNick(String nick);

    void setTeamName(String teamName);

    void setScore(Integer score);
}
