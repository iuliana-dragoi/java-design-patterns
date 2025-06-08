package crode.Iterator;

import crode.Object.Song;
import crode.Interface.PlaylistIterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleIterator implements PlaylistIterator {

    private List<Song> shuffledSongs;
    private int position = 0;

    public ShuffleIterator(List<Song> songs) {
        this.shuffledSongs = new ArrayList<>(songs);
        Collections.shuffle(this.shuffledSongs);
    }

    @Override
    public boolean hasNext() {
        return position < shuffledSongs.size();
    }

    @Override
    public Song next() {
        if (hasNext()) {
            return shuffledSongs.get(position++);
        }
        return null;
    }

    @Override
    public void reset() {
        position = 0;
        Collections.shuffle(shuffledSongs);
    }
}
