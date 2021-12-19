package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    private static MoveDirection parse(String args) {
        return switch (args) {
            case "f", "forward" -> (MoveDirection.FORWARD);
            case "b", "backward" -> (MoveDirection.BACKWARD);
            case "r", "right" -> (MoveDirection.RIGHT);
            case "l", "left" -> (MoveDirection.LEFT);
            default -> throw new IllegalArgumentException(args + " is not legal move specification");
        };
    }

    public static MoveDirection[] parse(String[] args) {
        List<MoveDirection> movesList = new ArrayList<>();
        for (String arg : args) {
            MoveDirection move = parse(arg);
            movesList.add(move);
        }
        return(movesList.toArray(new MoveDirection[0]));
    }
}