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
            default -> (null);
        };
    }

    public static MoveDirection[] parse(String[] args) {
        List<MoveDirection> movesList = new ArrayList<>();
        for (int i = 0; i <args.length; i++){
            MoveDirection move = parse(args[i]);
            if (move != null) {
                movesList.add(move);
            }
        }
        return(movesList.toArray(new MoveDirection[0]));
    }
}