package crode.ConcreteSubject;

import crode.Observer.NewsChannel;
import crode.Subject.NewsAgency;

import java.util.ArrayList;
import java.util.List;

public class RealNewsAgency implements NewsAgency {

    private List<NewsChannel> channels = new ArrayList<>();
    private String latestNews;

    @Override
    public void subscribe(NewsChannel channel) {
        channels.add(channel);
        System.out.println(channel.getChannelName() + " subscribed to news");
    }

    @Override
    public void unsubscribe(NewsChannel channel) {
        channels.remove(channel);
        System.out.println(channel.getChannelName() + " unsubscribed from news");
    }

    @Override
    public void notifyChannels() {
        System.out.println("\nNotification to all channels...");
        for (NewsChannel channel : channels) {
            channel.update(latestNews);
        }
    }

    public void publishNews(String news) {
        System.out.println("Public Agency: " + news);
        this.latestNews = news;
        notifyChannels();
    }
}
