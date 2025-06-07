package crode;

import crode.Builder.CoffeeBuilder;
import crode.ConcreteDecorators.MilkDecorator;
import crode.ConcreteDecorators.SugarDecorator;

public class CoffeeShop {

    public void printOrder(Coffee coffee) {
        System.out.println("Order: " + coffee.getDescription());
        System.out.println("Cost: $" + String.format("%.2f", coffee.getCost()));
        System.out.println("---");
    }

    public Coffee createCustomCoffee() {
        // Proof of flexibility
        return new CoffeeBuilder(new Espresso())
                .makeSize("Large")
                .addMilk()
                .addVanillaSyrup()
                .addWhipCream()
                .build();
    }

    public Coffee createSimpleOrder() {
        return new SugarDecorator(
                new MilkDecorator(
                        new SimpleCoffee()
                )
        );
    }

}
