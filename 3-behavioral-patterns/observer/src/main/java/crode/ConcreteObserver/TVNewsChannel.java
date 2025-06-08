package crode.ConcreteObserver;

import crode.Observer.NewsChannel;

public class TVNewsChannel implements NewsChannel {

    private String channelName;

    public TVNewsChannel(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void update(String news) {
        System.out.println(channelName + " transmit: " + news);
    }

    @Override
    public String getChannelName() {
        return channelName;
    }
}
