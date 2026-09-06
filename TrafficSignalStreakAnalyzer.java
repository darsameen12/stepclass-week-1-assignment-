import java.util.Scanner;

class InvalidSignalException extends Exception {
    InvalidSignalException(String message) {
        super(message);
    }
}

public class TrafficSignalStreakAnalyzer {
    static void validateSignalLog(String signalLog)
            throws InvalidSignalException {
        for (int index = 0; index < signalLog.length(); index++) {
            char signalChar = signalLog.charAt(index);
            if (signalChar != 'R'
                    && signalChar != 'Y'
                    && signalChar != 'G') {
                throw new InvalidSignalException(
                        "Invalid signal character '"
                        + signalChar
                        + "' found at position "
                        + (index + 1));
            }
        }
    }

    static void findLongestStreak(String signalLog)
            throws InvalidSignalException {
        validateSignalLog(signalLog);
        char longestStreakColor = signalLog.charAt(0);
        int longestStreakLength = 1;
        char currentColor = signalLog.charAt(0);
        int currentStreakLength = 1;
        for (int index = 1; index < signalLog.length(); index++) {
            char currentChar = signalLog.charAt(index);
            if (currentChar == currentColor) {
                currentStreakLength++;
            } else {
                currentColor = currentChar;
                currentStreakLength = 1;
            }
            if (currentStreakLength > longestStreakLength) {
                longestStreakLength = currentStreakLength;
                longestStreakColor = currentColor;
            }
        }
        System.out.println("Longest streak: " + longestStreakLength + " ('" + longestStreakColor + "')");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter signal log: ");
        String log = scanner.nextLine();

        try {
            findLongestStreak(log);
        } catch (InvalidSignalException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}