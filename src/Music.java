public class Music extends Item{
    private int numSongs;
    private String artist;
    public Music(int id, int copies, String name, String genre, int numSongs, String artist){
        super(id,copies,name,genre);
        this.numSongs = numSongs;
        this.artist = artist;
    }

    public void setNumSongs(int numSongs) {
        this.numSongs = numSongs;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getNumSongs() {
        return this.numSongs;
    }

    public String getArtist() {
        return this.artist;
    }

}
