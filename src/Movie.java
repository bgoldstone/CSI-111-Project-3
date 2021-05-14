/*
    Name: Ben Goldstone
    Date: 5/14/2021
    Instructor: Professor Joseph Helsing
 */
/**
 * Movie object of type {@link Item}.
 */
public class Movie extends Item {
    private final int lengthMinutes;

    public Movie(int id, String name, String genre, int lengthMinutes, int copies) {
        super(id, copies, name, genre);
        this.lengthMinutes = lengthMinutes;
    }

    public int getLengthMinutes() {
        return this.lengthMinutes;
    }

}
