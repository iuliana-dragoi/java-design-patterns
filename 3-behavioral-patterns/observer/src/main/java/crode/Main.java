package crode;

import crode.ConcreteObserver.OnlineNewsChannel;
import crode.ConcreteObserver.RadioNewsChannel;
import crode.ConcreteObserver.TVNewsChannel;
import crode.ConcreteSubject.RealNewsAgency;
import crode.Observer.NewsChannel;

public class Main {

    public static void main(String[] args) {
        // Create News Agency
        RealNewsAgency agency = new RealNewsAgency();

        // Create Channels
        NewsChannel proTV = new TVNewsChannel("Pro TV");
        NewsChannel digi24 = new OnlineNewsChannel("Digi24.ro");
        NewsChannel radioZU = new RadioNewsChannel("Radio ZU");
        NewsChannel antena1 = new TVNewsChannel("Antena 1");

        // Subscribe to channels
        System.out.println("=== Subscriptions ===");
        agency.subscribe(proTV);
        agency.subscribe(digi24);
        agency.subscribe(radioZU);

        // Publish first New
        System.out.println("\n=== First new ===");
        agency.publishNews("The weather will be beautiful tomorrow.");

        // Add new channel
        System.out.println("\n=== New Subscription ===");
        agency.subscribe(antena1);

        // Publish second new
        System.out.println("\n=== A second new ===");
        agency.publishNews("A new planet was discovered!");

        // One channel unsubscribe
        System.out.println("\n=== Unsubscribe ===");
        agency.unsubscribe(radioZU);

        // Publish third new
        System.out.println("\n=== A third new ===");
        agency.publishNews("Economy grows with 5% this year!");
    }
}
