package crode.HomeThreaterSystem;

public class TheaterLights {

    public void on() {
        System.out.println("Theater Lights: Turning ON");
    }

    public void off() {
        System.out.println("Theater Lights: Turning OFF");
    }

    public void dim(int level) {
        System.out.println("Theater Lights: Dimming to " + level + "%");
    }
}
