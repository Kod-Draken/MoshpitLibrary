public class Rating {
    private String alias;
    private String email;
    private int rating;

    public Rating(String alias, String email, int rating) {
        this.alias = alias;
        this.email = email;
        this.rating = rating;
    }

    public String getAlias() {
        return alias;
    }

    public String getEmail() {
        return email;
    }

    public int getRating() {
        return rating;
    }

    public String toString() {
        return String.format("Alias: %s%nEmail: %s%nRating: %d%n", alias, email, rating);
    }

}
