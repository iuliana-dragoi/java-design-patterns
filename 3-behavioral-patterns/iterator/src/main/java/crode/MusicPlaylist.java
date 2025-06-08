package crode;

import crode.Interface.Playlist;
import crode.Interface.PlaylistIterator;
import crode.Iterator.NormalIterator;
import crode.Iterator.ShuffleIterator;
import crode.Object.Song;
import java.util.ArrayList;
import java.util.List;

public class MusicPlaylist implements Playlist {

    private List<Song> songs = new ArrayList<>();

    @Override
    public PlaylistIterator createNormalIterator() {
        return new NormalIterator(songs);
    }

    @Override
    public PlaylistIterator createShuffleIterator() {
        return new ShuffleIterator(songs);
    }

    @Override
    public void addSong(Song song) {
        songs.add(song);
    }
}
