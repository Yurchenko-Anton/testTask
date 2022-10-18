package checkCorrectFileFormat;

import exception.DirectoryIsEmpty;
import exception.WrongFormatException;
import parse_and_MVP.basketball.parse.BasketballParser;
import parse_and_MVP.handballParser.parse.HandballParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CheckCorrectFileFormat {
    public static void CheckFileFormat(String path) throws IOException, WrongFormatException, DirectoryIsEmpty {
        File folder = new File(path);
        File[] listFiles = folder.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.getName().substring(file.getName().lastIndexOf('.')).equals(".csv")) {
                    checkedFile(file);
                } else {
                    throw new WrongFormatException("Sorry wrong format file");
                }
            }
        } else throw new DirectoryIsEmpty(folder.getName());
    }

    private static void checkedFile(File file) throws IOException {
        BufferedReader readFirstLine = new BufferedReader(new FileReader(file));
        String firstLine = readFirstLine.readLine().toLowerCase();
        if (firstLine.equals("basketball")) {
            BasketballParser.basketBall(file);
        } else if (firstLine.equals("handball")) {
            HandballParser.handBall(file);
        } else System.out.println("Fake file");
    }
}
