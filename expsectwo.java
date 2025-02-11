import java.util.Scanner;

class Book {
    protected String title, author;
    protected double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}

class Fiction extends Book {
    public Fiction(String title, String author, double price) {
        super(title, author, price);
    }

    public void displayDetails() {
        System.out.println("\nFiction Book Details:");
        super.displayDetails();
    }
}

class NonFiction extends Book {
    public NonFiction(String title, String author, double price) {
        super(title, author, price);
    }

    public void displayDetails() {
        System.out.println("\nNon-Fiction Book Details:");
        super.displayDetails();
    }
}

public class expsectwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for Fiction book
        System.out.println("Enter Fiction Book Details:");
        System.out.print("Title: ");
        String fictionTitle = sc.nextLine();
        System.out.print("Author: ");
        String fictionAuthor = sc.nextLine();
        System.out.print("Price: ");
        double fictionPrice = sc.nextDouble();
        sc.nextLine(); // Consume newline

        Fiction fictionBook = new Fiction(fictionTitle, fictionAuthor, fictionPrice);

        // Taking input for Non-Fiction book
        System.out.println("\nEnter Non-Fiction Book Details:");
        System.out.print("Title: ");
        String nonFictionTitle = sc.nextLine();
        System.out.print("Author: ");
        String nonFictionAuthor = sc.nextLine();
        System.out.print("Price: ");
        double nonFictionPrice = sc.nextDouble();

        NonFiction nonFictionBook = new NonFiction(nonFictionTitle, nonFictionAuthor, nonFictionPrice);

        // Display book details
        fictionBook.displayDetails();
        nonFictionBook.displayDetails();

        sc.close();
    }
}
