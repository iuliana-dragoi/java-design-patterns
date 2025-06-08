package crode.ConcreteObserver;

import crode.Observer.NewsChannel;

public class OnlineNewsChannel implements NewsChannel {

    private String websiteName;

    public OnlineNewsChannel(String websiteName) {
        this.websiteName = websiteName;
    }

    @Override
    public void update(String news) {
        System.out.println(websiteName + " publish online: " + news);
    }

    @Override
    public String getChannelName() {
        return websiteName;
    }
}
