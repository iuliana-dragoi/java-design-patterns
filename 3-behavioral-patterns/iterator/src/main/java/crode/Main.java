package crode;

import crode.Interface.PlaylistIterator;
import crode.Object.Song;

public class Main {

    public static void main(String[] args) {
        // Create playlist
        MusicPlaylist playlist = new MusicPlaylist();
        playlist.addSong(new Song("Bohemian Rhapsody", "Queen"));
        playlist.addSong(new Song("Hotel California", "Eagles"));
        playlist.addSong(new Song("Stairway to Heaven", "Led Zeppelin"));
        playlist.addSong(new Song("Sweet Child O' Mine", "Guns N' Roses"));
        playlist.addSong(new Song("Imagine", "John Lennon"));

        System.out.println("=== Normal playback ===");
        PlaylistIterator normalIterator = playlist.createNormalIterator();
        while (normalIterator.hasNext()) {
            System.out.println(normalIterator.next());
        }

        System.out.println("\n=== Random play ===");
        PlaylistIterator shuffleIterator = playlist.createShuffleIterator();
        while (shuffleIterator.hasNext()) {
            System.out.println(shuffleIterator.next());
        }

        System.out.println("\n=== Reset and shuffle again ===");
        shuffleIterator.reset();
        int count = 0;
        while (shuffleIterator.hasNext() && count < 3) {
            System.out.println(shuffleIterator.next());
            count++;
        }
    }
}
