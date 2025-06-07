package crode.HomeThreaterSystem;

public class DvdPlayer {

    public void on() {
        System.out.println("DVD Player: Turning ON");
    }

    public void off() {
        System.out.println("DVD Player: Turning OFF");
    }

    public void play(String movie) {
        System.out.println("DVD Player: Playing '" + movie + "'");
    }

    public void stop() {
        System.out.println("DVD Player: Stopping playback");
    }

    public void eject() {
        System.out.println("DVD Player: Ejecting disc");
    }
}
