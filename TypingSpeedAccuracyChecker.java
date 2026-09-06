import java.util.Scanner;
class UnequalLengthException extends Exception {
    UnequalLengthException(String message) {
        super(message);
    }
}
public class TypingSpeedAccuracyChecker {
    static void checkTypingAccuracy(String original, String typed)
            throws UnequalLengthException {
        if (original.length() != typed.length()) {
            throw new UnequalLengthException(
                    "Original and typed text must be of equal length");
        }
        int totalCharacters = original.length();
        int matchedCharacters = 0;
        int firstMismatchPosition = -1;
        for (int index = 0; index < totalCharacters; index++) {
            char originalChar = original.charAt(index);
            char typedChar = typed.charAt(index);

            if (originalChar == typedChar) {
                matchedCharacters++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = index + 1;

                System.out.println(
                        "Mismatch ASCII values -> Original: "
                        + (int) originalChar + ", Typed: "
                        + (int) typedChar);
            }
        }
        double accuracyPercentage =
                ((double) matchedCharacters / totalCharacters) * 100;
        System.out.printf(
                "Matched: %d/%d | Accuracy: %.2f%%",
                matchedCharacters, totalCharacters, accuracyPercentage);

        if (firstMismatchPosition == -1) {
            System.out.println(" | No Mismatches");
        } else {
            System.out.println(
                    " | First Mismatch at position "
                    + firstMismatchPosition
                    + " ('"
                    + original.charAt(firstMismatchPosition - 1)
                    + "' vs '"
                    + typed.charAt(firstMismatchPosition - 1)
                    + "')");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String originalPassage = scanner.nextLine();

        System.out.print("Enter typed passage: ");
        String typedPassage = scanner.nextLine();

        try {
            checkTypingAccuracy(originalPassage, typedPassage);
        } catch (UnequalLengthException lengthMismatch) {
            System.out.println("Error: " + lengthMismatch.getMessage());
        } finally {
            scanner.close();
        }
    }
}