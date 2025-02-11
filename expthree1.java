import java.util.Scanner;

public class expthree1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter: ");
            String input = scanner.nextLine(); 
            double num = Double.parseDouble(input);
            if (num<0) {
                throw new Exception("Error:negative");
            }
            double squareRoot = Math.sqrt(num);
            System.out.println("Square root of" + num + " is: " + squareRoot);
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        } finally {
            scanner.close(); 
        }
    }
}
