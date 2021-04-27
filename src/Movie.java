public class Movie extends Item {
    private int lengthMinutes;

    public Movie(int id, int copies, String name, String genre, int lengthMinutes) {
        super(id, copies, name, genre);
        this.lengthMinutes = lengthMinutes;
    }

    public void setLengthMinutes(int lengthMinutes) {
        this.lengthMinutes = lengthMinutes;
    }

    public int getLengthMinutes(){
        return this.lengthMinutes;
    }

}
