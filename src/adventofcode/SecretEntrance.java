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
        int allZeroCount = 0;

        fillListWithSequences(rotationSequenceData, rotationSequenceList);


        for (String sequence : rotationSequenceList) {
            switch (sequence.charAt(0)) {
                case 'L', 'R' -> {
                    allZeroCount += countZeroHits(currentDialPosition, sequence, 100);
                    currentDialPosition = doMove(currentDialPosition, sequence, 100);
                    if (currentDialPosition == 0) {
                        zeroCount++;
                    }
                }

            }
        }

        System.out.println("Final position: " + currentDialPosition);
        System.out.println("Zero count: " + zeroCount);
        System.out.println("All zero count: " + allZeroCount);
    }

    private static int countZeroHits(int startPos, String sequence, int max) {
        char moveDirection = sequence.charAt(0);
        int rotationQuantity = Integer.parseInt(sequence.substring(1));
        int hits = 0;


        for (int i = 1; i <= rotationQuantity; i++) {
            int pos = moveDirection == 'L' ? (startPos - i) % max : (startPos + i) % max;
            if (pos < 0) pos += max;
            if (pos == 0) hits++;
        }
        return hits;
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

