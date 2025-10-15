import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("\n=== Contador punhetinha 123 ===");
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Create Account");
            System.out.println("2. View Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.println(">> Creating account...");
                    // your code here
                    break;
                case 2:
                    System.out.println(">> Viewing account...");
                    // your code here
                    break;
                case 3:
                    System.out.println(">> Depositing...");
                    // your code here
                    break;
                case 4:
                    System.out.println(">> Withdrawing...");
                    // your code here
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}