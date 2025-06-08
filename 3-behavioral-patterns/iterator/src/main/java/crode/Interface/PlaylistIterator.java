package crode.Interface;

import crode.Object.Song;

public interface PlaylistIterator {
    boolean hasNext();
    Song next();
    void reset();
}
