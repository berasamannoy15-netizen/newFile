import java.util.*;

class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n--- Select an Operation ---");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Division");
            System.out.println("4. Multiplication");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();


            if (choice == 5) {
                System.out.println("Thank you for using the calculator.");
                break;
            }


            if (choice < 1 || choice > 5) {
                System.out.println("The Entered Number is Wrong. Try again.");
                continue; // Skips the rest of the loop and prompts again
            }


            System.out.print("Enter the first number: ");
            int num1 = sc.nextInt();
            System.out.print("Enter the second number: ");
            int num2 = sc.nextInt();

            // 5. Evaluate choice
            switch (choice) {
                case 1:
                    System.out.println("The Addition is: " + (num1 + num2));
                    break;
                case 2:
                    System.out.println("The Subtraction is: " + (num1 - num2)); // Fixed logic
                    break;
                case 3:
                    if (num2 == 0) {
                        System.out.println("Error: Cannot divide by zero.");
                    } else {
                        System.out.println("The Division is: " + (num1 / num2));
                    }
                    break;
                case 4:
                    System.out.println("The Multiplication is: " + (num1 * num2));
                    break;
            }
        }
        sc.close(); // Clean up resource
    }
}
