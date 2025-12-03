package adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SecretEntrance {
    static void main() throws FileNotFoundException {
        Scanner rotationSequenceData = new Scanner(new File("src/adventofcode/rotationSequence"));
        List<String> rotationSequenceList = new LinkedList<>();
        int dialBeginPosition = 50;
        int currentDialPosition = dialBeginPosition;
        int zeroCount = 0;

        fillListWithSequences(rotationSequenceData, rotationSequenceList);


        for (String sequence : rotationSequenceList) {
            switch (sequence.charAt(0)) {
                case 'L', 'R' -> {
                    currentDialPosition = doMove(currentDialPosition, sequence, 100);
                    if (currentDialPosition == 0) {
                        zeroCount++;
                    }
                }

            }
        }

        System.out.println("Final position: " + currentDialPosition);
        System.out.println("Zero count: " + zeroCount);
    }

    private static int doMove(int currentDialPosition, String sequence, int max) {
        char moveDirection = sequence.charAt(0);
        int rotationQuantity = Integer.parseInt(sequence.substring(1));

        if (moveDirection == 'L') {
            currentDialPosition = (currentDialPosition - rotationQuantity) % max;
        } else {
            currentDialPosition = (currentDialPosition + rotationQuantity) % max;
        }

        if (currentDialPosition < 0) currentDialPosition += max;
        return currentDialPosition;
    }

    private static void fillListWithSequences(Scanner s, List<String> rotationSequence) {
        while (s.hasNextLine()) {
            rotationSequence.add(s.nextLine());
        }
        s.close();
    }
}

