package crode.HomeThreaterSystem;

public class Amplifier {

    public void on() {
        System.out.println("Amplifier: Turning ON");
    }

    public void off() {
        System.out.println("Amplifier: Turning OFF");
    }

    public void setDvd() {
        System.out.println("Amplifier: Setting DVD input");
    }

    public void setStereoSound() {
        System.out.println("Amplifier: Setting stereo sound");
    }

    public void setVolume(int level) {
        System.out.println("Amplifier: Setting volume to " + level);
    }
}
