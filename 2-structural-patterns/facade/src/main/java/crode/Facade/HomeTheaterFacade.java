package crode.Facade;

import crode.HomeThreaterSystem.*;

public class HomeTheaterFacade {

    private DvdPlayer dvdPlayer;
    private Projector projector;
    private SurroundSoundSystem soundSystem;
    private TheaterLights lights;
    private PopcornMaker popcornMaker;
    private Screen screen;
    private Amplifier amplifier;

    public HomeTheaterFacade(DvdPlayer dvdPlayer, Projector projector, SurroundSoundSystem soundSystem, TheaterLights lights, PopcornMaker popcornMaker, Screen screen, Amplifier amplifier) {
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.soundSystem = soundSystem;
        this.lights = lights;
        this.popcornMaker = popcornMaker;
        this.screen = screen;
        this.amplifier = amplifier;
    }

    // Simplified method to start everything
    public void watchMovie(String movie) {
        System.out.println("Starting movie experience: '" + movie + "'");

        // The complex sequence simplified in one method
        popcornMaker.on();
        popcornMaker.makePopcorn();

        lights.dim(10);
        screen.down();

        projector.on();
        projector.wideScreenMode();
        projector.setInput("DVD");

        amplifier.on();
        amplifier.setDvd();
        amplifier.setStereoSound();
        amplifier.setVolume(15);

        soundSystem.on();
        soundSystem.setSurroundSound();
        soundSystem.setVolume(20);

        dvdPlayer.on();
        dvdPlayer.play(movie);

        System.out.println("Enjoy your movie!\n");
    }

    // Simplified method to stop everything
    public void endMovie() {
        System.out.println("Ending movie experience...");

        dvdPlayer.stop();
        dvdPlayer.eject();
        dvdPlayer.off();

        soundSystem.off();
        amplifier.off();
        projector.off();

        screen.up();
        lights.on();
        popcornMaker.off();

        System.out.println("Theater system shutdown complete!\n");
    }

    // Alternative ways to use it
    public void listenToMusic() {
        System.out.println("Setting up music mode...");

        lights.dim(30);
        amplifier.on();
        amplifier.setStereoSound();
        amplifier.setVolume(12);
        soundSystem.on();
        soundSystem.setVolume(15);

        System.out.println("Music system ready!\n");
    }

    public void quickMovieMode(String movie) {
        System.out.println("Quick movie setup for: '" + movie + "'");

        lights.dim(20);
        projector.on();
        projector.setInput("DVD");
        soundSystem.on();
        soundSystem.setVolume(15);
        dvdPlayer.on();
        dvdPlayer.play(movie);

        System.out.println("Quick setup complete!\n");
    }

    // Complete cleanup
    public void shutdown() {
        System.out.println("Complete system shutdown...");

        dvdPlayer.off();
        projector.off();
        soundSystem.off();
        amplifier.off();
        lights.on();
        screen.up();
        popcornMaker.off();

        System.out.println("All systems OFF!\n");
    }
}
