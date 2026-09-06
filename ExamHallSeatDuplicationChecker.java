import java.util.Scanner;
 public class ExamHallSeatDuplicationChecker { 
    static void checkDuplicateSeats(int[] seatNumbers) { 
        boolean duplicateFound = false;
         StringBuilder duplicateSeats = new StringBuilder();
         for (int i = 0; i < seatNumbers.length; i++) {
             for (int j = i + 1; j < seatNumbers.length; j++) {
                 if (seatNumbers[i] == seatNumbers[j]) {
                     if (duplicateSeats.indexOf(String.valueOf(seatNumbers[i])) == -1) {
                         duplicateSeats.append(seatNumbers[i]).append(" ");
                          duplicateFound = true; 
                        }
                     } 
                    }
                 }
                  if (duplicateFound) {
                     System.out.println("Duplicate Seat Number Found: "
                      + duplicateSeats.toString().trim());
                     } else { System.out.println("No Duplicate Seats Found");

                      } 
                    } 
                    public static void main(String[] args) { 
                        Scanner scanner = new Scanner(System.in);
                         try { 
                            System.out.print("Enter number of seats: "); 
                            int totalSeats = Integer.parseInt(scanner.nextLine().trim()); 
                            int[] seatNumbers = new int[totalSeats]; 
                            for (int i = 0; i < totalSeats; i++) { 
                                System.out.print("Enter seat number " + (i + 1) + ": ");
                                 seatNumbers[i] = 
                                              Integer.parseInt(scanner.nextLine().trim());
                                             }
                                              checkDuplicateSeats(seatNumbers); 
                                            } catch (NumberFormatException invalidInput) { 
                                                System.out.println( 
                                                    "Invalid input. Please enter valid integers only.");
                                                 } catch (ArrayIndexOutOfBoundsException indexError) { 
                                                    System.out.println(
                                                         "Seat index error occurred: " +
                                                          indexError.getMessage());
                                                         } finally {
                                                             scanner.close();
                                                             } 
                                                            }
                                                         }