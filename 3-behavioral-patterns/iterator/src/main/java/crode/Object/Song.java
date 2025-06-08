package crode.Object;

public class Song {

    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return title + " - " + artist;
    }

    // Getters
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
}
