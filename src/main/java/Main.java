import checkCorrectFileFormat.CheckCorrectFileFormat;
import exception.DirectoryIsEmpty;
import exception.WrongFormatException;
import parse_and_MVP.basketball.parse.BasketballParser;
import parse_and_MVP.handballParser.parse.HandballParser;
import parse_and_MVP.mvp.MVP;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, WrongFormatException, DirectoryIsEmpty {
        CheckCorrectFileFormat.CheckFileFormat("data");
        System.out.println(MVP.findMVP(BasketballParser.basketballPlayers));
        System.out.println(MVP.findMVP(HandballParser.handballPlayers));
    }
}
