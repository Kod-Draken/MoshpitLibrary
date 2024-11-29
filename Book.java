import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private List<Rating> listRatings;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.listRatings = new ArrayList<>();
    }

    public void addRating(Rating r) {
        boolean unique = true;
        for (Rating rating : listRatings) {
            if (rating.getEmail().equals(r.getEmail())) {
                System.err.println("You cannot vote twice!");
                unique = false;
                break;
            }
        }
        if (unique) {
            listRatings.add(r);
            System.out.println("Rating submitted!");
        }
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public double averageRating() {
        int totalScore = 0;
        for (Rating rating : listRatings) {
            totalScore += rating.getRating();
        }
        return totalScore / (double) listRatings.size();
    }

    @Override
    public String toString() {
        return String.format("Title: %s Author: %s Isbn: %s Rating: %.1f",
                title, author, isbn, averageRating());
    }

    public void printRatings(){
        for (Rating rating : listRatings) {
            System.out.printf("Alias: %s Rating: %d%n%n"
                                ,rating.getAlias()
                                ,rating.getRating());
        }
    }

    

}
