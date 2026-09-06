import java.util.Scanner;

public class MovieReviewWordLengthProfiler {

    static void classifyWordLengths(String review) {
        String[] words = review.trim().split("\\s+");

        int shortWordCount = 0;
        int mediumWordCount = 0;
        int longWordCount = 0;

        for (String word : words) {
            String cleanedWord =
                    word.replaceAll("[^a-zA-Z]", "");

            int wordLength = cleanedWord.length();

            if (wordLength == 0) {
                continue;
            }

            if (wordLength <= 4) {
                shortWordCount++;
            } else if (wordLength <= 8) {
                mediumWordCount++;
            } else {
                longWordCount++;
            }
        }

        System.out.println(
                "Short: " + shortWordCount
                + " | Medium: " + mediumWordCount
                + " | Long: " + longWordCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter movie review: ");
        String review = scanner.nextLine();

        try {
            if (review.trim().isEmpty()) {
                throw new IllegalArgumentException(
                        "Review cannot be empty");
            }

            classifyWordLengths(review);

        } catch (IllegalArgumentException emptyReview) {
            System.out.println(
                    "Error: " + emptyReview.getMessage());

        } finally {
            scanner.close();
        }
    }
}