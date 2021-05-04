public class Music extends Item {
    private final int numSongs;
    private final String artist;

    public Music(int id, String name, String artist, String genre, int numSongs, int copies) {
        super(id, copies, name, genre);
        this.numSongs = numSongs;
        this.artist = artist;
    }

    public int getNumSongs() {
        return this.numSongs;
    }

    public String getArtist() {
        return this.artist;
    }

}
