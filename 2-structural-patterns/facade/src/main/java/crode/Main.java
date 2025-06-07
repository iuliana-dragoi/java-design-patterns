package crode;

import crode.Facade.HomeTheaterFacade;
import crode.HomeThreaterSystem.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Facade Pattern Demo ===\n");

        // Create all the components of the subsystem
        DvdPlayer dvd = new DvdPlayer();
        Projector projector = new Projector();
        SurroundSoundSystem soundSystem = new SurroundSoundSystem();
        TheaterLights lights = new TheaterLights();
        PopcornMaker popcornMaker = new PopcornMaker();
        Screen screen = new Screen();
        Amplifier amplifier = new Amplifier();

        // Create facade
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
            dvd, projector, soundSystem, lights,
            popcornMaker, screen, amplifier
        );

        homeTheater.watchMovie("The Matrix");
        homeTheater.endMovie();

        homeTheater.listenToMusic();

        homeTheater.quickMovieMode("Inception");

        homeTheater.shutdown();
    }
}
