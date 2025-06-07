package crode;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String size;
    private String crust;
    private String sauce;
    private List<String> toppings;
    private boolean extraCheese;
    private boolean stuffedCrust;

    // Private Constructor - only Builder can create Pizza
    private Pizza(Builder builder) {
        this.size = builder.size;
        this.crust = builder.crust;
        this.sauce = builder.sauce;
        this.toppings = builder.toppings;
        this.extraCheese = builder.extraCheese;
        this.stuffedCrust = builder.stuffedCrust;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pizza [")
        .append("Size: ").append(size)
        .append(", Crust: ").append(crust)
        .append(", Sauce: ").append(sauce)
        .append(", Toppings: ").append(toppings)
        .append(", Extra Cheese: ").append(extraCheese)
        .append(", Stuffed Crust: ").append(stuffedCrust)
        .append("]");
        return sb.toString();
    }

    public static class Builder {

        // Mandatory Parameters
        private String size;
        private String crust;

        // Optional Parameters - with default values
        private String sauce = "Tomato";
        private List<String> toppings = new ArrayList<>();
        private boolean extraCheese = false;
        private boolean stuffedCrust = false;

        // Constructor with Mandatory Parameters
        public Builder(String size, String crust) {
            this.size = size;
            this.crust = crust;
        }

        public Builder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public Builder addTopping(String topping) {
            this.toppings.add(topping);
            return this;
        }

        public Builder extraCheese() {
            this.extraCheese = true;
            return this;
        }

        public Builder stuffedCrust() {
            this.stuffedCrust = true;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }



}
