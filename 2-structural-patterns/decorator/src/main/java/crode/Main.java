package crode;

import crode.Builder.CoffeeBuilder;
import crode.ConcreteDecorators.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Decorator Pattern Demo ===\n");

        CoffeeShop shop = new CoffeeShop();

        // Simple Order
        System.out.println("Simple Orders:");
        Coffee simpleCoffee = new SimpleCoffee();
        shop.printOrder(simpleCoffee);

        Coffee coffeeWithMilk = new MilkDecorator(new SimpleCoffee());
        shop.printOrder(coffeeWithMilk);

        // Complex order - stacking decorators
        System.out.println("Complex Stacked Order:");
        Coffee complexCoffee = new WhipCreamDecorator(
                new VanillaSyrupDecorator(
                        new MilkDecorator(
                                new SugarDecorator(
                                        new ExtraShotDecorator(
                                                new Espresso()
                                        )
                                )
                        )
                )
        );
        shop.printOrder(complexCoffee);

        // Using Builder
        System.out.println("🔸 Using Coffee Builder:");
        Coffee builderCoffee = new CoffeeBuilder(new SimpleCoffee())
                .makeSize("Large")
                .addMilk()
                .addSugar()
                .addVanillaSyrup()
                .build();
        shop.printOrder(builderCoffee);

        // Comparison between sizes
        System.out.println("Size Comparison:");
        Coffee baseCoffee = new MilkDecorator(new Espresso());

        Coffee smallCoffee = new SizeDecorator(baseCoffee, "Small");
        Coffee mediumCoffee = new SizeDecorator(baseCoffee, "Medium");
        Coffee largeCoffee = new SizeDecorator(baseCoffee, "Large");

        shop.printOrder(smallCoffee);
        shop.printOrder(mediumCoffee);
        shop.printOrder(largeCoffee);

        // Predefined orders
        System.out.println("Predefined Orders:");
        Coffee customOrder = shop.createCustomCoffee();
        shop.printOrder(customOrder);

        Coffee simpleOrder = shop.createSimpleOrder();
        shop.printOrder(simpleOrder);

        // Proof that the decorators are independent
        System.out.println("Multiple Instances:");
        Coffee coffee1 = new MilkDecorator(new SimpleCoffee());
        Coffee coffee2 = new SugarDecorator(new SimpleCoffee());
        Coffee coffee3 = new SugarDecorator(new MilkDecorator(new SimpleCoffee()));

        System.out.println("Coffee 1: " + coffee1.getDescription() + " - $" + coffee1.getCost());
        System.out.println("Coffee 2: " + coffee2.getDescription() + " - $" + coffee2.getCost());
        System.out.println("Coffee 3: " + coffee3.getDescription() + " - $" + coffee3.getCost());
    }
}
