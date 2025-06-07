package crode.HomeThreaterSystem;

public class Projector {

    public void on() {
        System.out.println("Projector: Turning ON");
    }

    public void off() {
        System.out.println("Projector: Turning OFF");
    }

    public void wideScreenMode() {
        System.out.println("Projector: Setting to widescreen mode (16:9)");
    }

    public void setInput(String input) {
        System.out.println("Projector: Setting input to " + input);
    }
}
