package crode.Observer;

// Observer interface
public interface NewsChannel {
    void update(String news);
    String getChannelName();
}
