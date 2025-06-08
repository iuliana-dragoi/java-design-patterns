package crode.Interface;

import crode.Object.Song;

public interface Playlist {
    PlaylistIterator createNormalIterator();
    PlaylistIterator createShuffleIterator();
    void addSong(Song song);
}
