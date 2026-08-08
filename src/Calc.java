import java.util.*;

public class Calc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter the number for operator");
            System.out.println("1.Addition" +" "+ "2.Subtraction"+ " " + " Division " + " Multiplication " + "5.Exit");
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("The addition is :" + (num1 + num2));
                    break;
                case 2:
                    System.out.println("The Subtraction is :"+ (num1 - num2));
                    break;
                case 3:
                    if(num2 == 0 ){
                        break;
                    }
                    System.out.println("The Division is :"+ ( num1 / num2));
                    break;
                case 4:
                    System.out.println("The Multiplication is :");
                    break;
                default:
                    System.out.println("The number is wrong ");
                    break;
            }
            if (choice == 5 ){
                System.out.println("Thank you for using the calculator");
                break;
            }
        }

    }
/*hello
*/

    }

