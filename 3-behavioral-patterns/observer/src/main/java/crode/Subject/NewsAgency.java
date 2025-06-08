package crode.Subject;

import crode.Observer.NewsChannel;

// Subject interface

public interface NewsAgency {
    void subscribe(NewsChannel channel);
    void unsubscribe(NewsChannel channel);
    void notifyChannels();
}
