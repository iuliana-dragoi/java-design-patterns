package crode.ConcreteObserver;

import crode.Observer.NewsChannel;

public class RadioNewsChannel implements NewsChannel {
    private String stationName;

    public RadioNewsChannel(String stationName) {
        this.stationName = stationName;
    }

    @Override
    public void update(String news) {
        System.out.println(stationName + " announce on the radio: " + news);
    }

    @Override
    public String getChannelName() {
        return stationName;
    }
}