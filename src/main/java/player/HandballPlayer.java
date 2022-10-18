package player;

import interfaces.Player;

import java.util.Objects;

public class HandballPlayer implements Player {
    String name;
    String nick;
    String teamName;
    Integer score;

    public HandballPlayer(String name, String nick, String teamName, Integer score) {
        this.name = name;
        this.nick = nick;
        this.teamName = teamName;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getNick() {
        return nick;
    }


    public String getTeamName() {
        return teamName;
    }


    public Integer getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HandballPlayer that = (HandballPlayer) o;
        return name.equals(that.name) && nick.equals(that.nick) && teamName.equals(that.teamName) && score.equals(that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nick, teamName, score);
    }

    @Override
    public String toString() {
        return "HandballPlayer{" +
                "name='" + name + '\'' +
                ", nick='" + nick + '\'' +
                ", teamName='" + teamName + '\'' +
                ", score=" + score +
                '}';
    }
}
