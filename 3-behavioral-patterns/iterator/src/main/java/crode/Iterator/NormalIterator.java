package crode.Iterator;

import crode.Object.Song;
import crode.Interface.PlaylistIterator;

import java.util.List;

// Concrete Iterator for normal order
public class NormalIterator implements PlaylistIterator {

    private List<Song> songs;
    private int position = 0;

    public NormalIterator(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public boolean hasNext() {
        return position < songs.size();
    }

    @Override
    public Song next() {
        if (hasNext()) {
            return songs.get(position++);
        }
        return null;
    }

    @Override
    public void reset() {
        position = 0;
    }
}
