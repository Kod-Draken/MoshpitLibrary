import java.util.*;

public class Main {
    private static List<Book> bookList = new ArrayList<>();

    public static void main(String[] args) {
        bookList.add(new Book("1984", "George Orwell", "123456789"));
        bookList.add(new Book("En bondes bekännelser", "Nisse Hult", "1121223121"));
        bookList.add(new Book("Konstig konst", "Lars Lerin", "13223434343"));

        try (Scanner input = new Scanner(System.in)) {
            int choice;
            while (true) {
                chooseToRateOrSeeRating(input);
                System.out.println("Avaliable books: ");
                printBooks(bookList);
                System.out.println("\nWhich book do you want to rate (type the number of the book): ");
                if (input.hasNextInt()) {
                    choice = input.nextInt();
                    input.nextLine();
                    if (choice > Main.bookList.size()
                            || choice < 1) {
                        System.out.println("Not a valid choice!\n");
                        continue;
                    }
                } else {
                    System.err.println("Enter a number!\n");
                    input.next();
                    continue;
                }
                rateBook(input, choice);
            }
        }
    }

    private static void printBooks(List<Book> bookList) {
        sortBookList();
        int i = 1;
        for (Book each : bookList) {
            System.out.print(i + ". ");
            System.out.println(each.toString());
            i += 1;
        }
    }

    private static void rateBook(Scanner input, int index) {
        String alias;
        String email;
        int rating;

        while (true) {
            System.out.println("What is your alias: ");
            alias = input.nextLine();
            if (alias.trim().length() == 0) {
                System.out.println("Alias cannot be empty");
            } else {
                break;
            }
        }
        while (true) {
            System.out.println("What is your email: ");
            email = input.nextLine();
            if (email.trim().length() == 0) {
                System.out.println("Email cannot be empty");
            } else {
                break;
            }
        }
        while (true) {
            System.out.println("What is your rating for the book: ");
            if (input.hasNextInt()) {
                rating = input.nextInt();
                input.nextLine();
                break;
            } else {
                System.err.println("Svara med en siffra!");
                input.next();
            }
        }
        Rating r = new Rating(alias, email, rating);
        Main.bookList.get(index - 1).addRating(r);
    }

    private static void sortBookList() {
        Comparator<Book> comp = Comparator.comparing(Book::averageRating, Comparator.reverseOrder());
        Collections.sort(bookList, comp);
    }

    private static void chooseToRateOrSeeRating(Scanner input) {
        loop: while (true) {
            System.out.println("What do you want to do:");
            System.out.println("\t1. Rate a book.");
            System.out.println("\t2. See the ratings.");
            System.out.println("\t3. Quit.\n");
            
            switch (input.nextInt()) {
                case 1:
                    break loop;
                case 2:
                    seeRatings(input);
                    break;
                case 3:
                    System.exit(-1);
                    break;
                default:
                    System.out.println("Not a valid choice!");
                    break;
            }
        }
    }

    private static void seeRatings(Scanner input) {
        System.out.println("Choose a book");
        printBooks(bookList);
        int choice;
        while (true) {
            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine();
                break;
            } 
            else {
                System.out.println("get fucked");
            }
        }
        bookList.get(choice - 1).printRatings();
    }
}
