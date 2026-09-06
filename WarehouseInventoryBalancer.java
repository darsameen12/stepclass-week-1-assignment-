import java.util.Scanner;

class ArrayLengthMismatchException extends Exception {
    ArrayLengthMismatchException(String message) {
        super(message);
    }
}

public class WarehouseInventoryBalancer {

    static void analyzeInventory(int[] sectionA, int[] sectionB)
            throws ArrayLengthMismatchException {

        if (sectionA.length != sectionB.length) {
            throw new ArrayLengthMismatchException(
                    "Section A and Section B must have the same number of items");
        }

        int totalSectionA = 0;
        int totalSectionB = 0;

        int highestQuantity = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 0;

        for (int index = 0; index < sectionA.length; index++) {
            totalSectionA += sectionA[index];
            totalSectionB += sectionB[index];

            if (sectionA[index] > highestQuantity) {
                highestQuantity = sectionA[index];
                highestSection = "Section A";
                highestIndex = index;
            }

            if (sectionB[index] > highestQuantity) {
                highestQuantity = sectionB[index];
                highestSection = "Section B";
                highestIndex = index;
            }
        }

        String balanceStatus =
                (totalSectionA == totalSectionB)
                ? "Balanced"
                : "Not Balanced";

        System.out.println(
                "Section A Total: " + totalSectionA
                + " | Section B Total: " + totalSectionB
                + " | Status: " + balanceStatus
                + " | Highest Quantity: " + highestQuantity
                + " (" + highestSection
                + ", Item " + (highestIndex + 1) + ")");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print(
                    "Enter number of items in each section: ");

            int itemCount =
                    Integer.parseInt(scanner.nextLine().trim());

            int[] sectionA = new int[itemCount];
            int[] sectionB = new int[itemCount];

            for (int index = 0; index < itemCount; index++) {
                System.out.print(
                        "Enter Section A quantity for item "
                        + (index + 1) + ": ");

                sectionA[index] =
                        Integer.parseInt(scanner.nextLine().trim());
            }

            for (int index = 0; index < itemCount; index++) {
                System.out.print(
                        "Enter Section B quantity for item "
                        + (index + 1) + ": ");

                sectionB[index] =
                        Integer.parseInt(scanner.nextLine().trim());
            }

            analyzeInventory(sectionA, sectionB);

        } catch (NumberFormatException invalidInput) {
            System.out.println(
                    "Invalid input. Please enter valid integers only.");

        } catch (ArrayLengthMismatchException lengthMismatch) {
            System.out.println(
                    "Error: " + lengthMismatch.getMessage());

        } finally {
            scanner.close();
        }
    }
} 