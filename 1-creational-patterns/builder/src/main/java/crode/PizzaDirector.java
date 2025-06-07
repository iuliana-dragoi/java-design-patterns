package crode;

public class PizzaDirector {

    public static Pizza margherita() {
        return new Pizza.Builder("Medium", "Thin")
                .sauce("Tomato")
                .addTopping("Mozzarella")
                .addTopping("Basil")
                .build();
    }

    public static Pizza pepperoni() {
        return new Pizza.Builder("Large", "Thick")
                .sauce("Tomato")
                .addTopping("Mozzarella")
                .addTopping("Pepperoni")
                .extraCheese()
                .build();
    }

    public static Pizza supreme() {
        return new Pizza.Builder("Large", "Stuffed")
                .sauce("BBQ")
                .addTopping("Mozzarella")
                .addTopping("Pepperoni")
                .addTopping("Mushrooms")
                .addTopping("Bell Peppers")
                .addTopping("Olives")
                .extraCheese()
                .stuffedCrust()
                .build();
    }
}
