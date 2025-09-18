import java.util.Scanner;  
  
public class Calculator {  
    public static void main(String[] args)
    {  
        // Step 1: Create two double variables for first and second, and a String variable for the operator  
        double first, second;  
        String op;  
  
        // Step 2: Get input values for all variables  
        Scanner scanner = new Scanner(System.in);  
          
        System.out.print("Enter the first number: ");         
          first = scanner.nextDouble();  
          
        System.out.print("Enter the operator (+, -, *, /): ");         
        op = scanner.next();  
          
        System.out.print("Enter the second number: ");         
         second = scanner.nextDouble();  
  
        // Step 3: Run a switch...case based on the operator input  
        switch (op) {             
                case "+":  
                // Perform addition  
                System.out.println("Result: " + (first + second));  
                break;             
                case "-":  
                // Perform subtraction  
                System.out.println("Result: " + (first - second));  
                break;             
                case "*":                  
                System.out.println("Result: " + (first * second));  
                break;             
                case "/":  
                // Perform division                 
               if (second != 0) {  
                    System.out.println("Result: " + (first / second));  
                } else {  
                    System.out.println("Error: Division by zero is not allowed.");  
                }  
                break;             
             default:  
                // Handle invalid operator  
                System.out.println("Invalid Operator");  
                break;  
        }  
  
    }  
}  