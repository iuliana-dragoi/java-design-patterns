package crode;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Builder Pattern Demo ===\n");

        // Step by Step construction
        Pizza customPizza = new Pizza.Builder("Large", "Thin")
                .sauce("White Sauce")
                .addTopping("Chicken")
                .addTopping("Mushrooms")
                .addTopping("Spinach")
                .extraCheese()
                .build();
        System.out.println("Custom Pizza: " + customPizza);

        // Simple Pizza
        Pizza simplePizza = new Pizza.Builder("Small", "Thick").build();
        System.out.println("Simple Pizza: " + simplePizza);

        // Using Director for pizza preferences
        System.out.println("\n--- Predefined Pizzas ---");
        Pizza margherita = PizzaDirector.margherita();
        Pizza pepperoni = PizzaDirector.pepperoni();
        Pizza supreme = PizzaDirector.supreme();

        System.out.println("Margherita: " + margherita);
        System.out.println("Pepperoni: " + pepperoni);
        System.out.println("Supreme: " + supreme);

        // Flexibility proof
        System.out.println("\n--- Chain Building ---");
        Pizza veggie = new Pizza.Builder("Medium", "Whole Wheat")
            .sauce("Pesto")
            .addTopping("Mozzarella")
            .addTopping("Tomatoes")
            .addTopping("Bell Peppers")
            .addTopping("Onions")
            .addTopping("Olives")
            .build();

        System.out.println("Veggie Pizza: " + veggie);
    }
}
