import java.util.Scanner;
class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
 
public class expthree2{
    private static final int actpin = 1234; 
    private static double balance = 5000.00; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter PIN: ");
            int ent=scanner.nextInt();
             if (ent!= actpin) {
                throw new InvalidPinException("Invalid PIN");
            }
            System.out.print("Enter amount: ");
            double withdraw= scanner.nextDouble();
            if (withdraw>balance) {
                throw new InsufficientBalanceException("Insufficient balance.");
            }
            balance -= withdraw;
            System.out.println("Amount withdrawn: " + withdraw);

        } 
        catch (InvalidPinException e) {
            System.out.println(e.getMessage());
        } 
        catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        } 
        finally {
            System.out.println("Remaining balance: " + balance);
            scanner.close(); 
        }
        }
    }

