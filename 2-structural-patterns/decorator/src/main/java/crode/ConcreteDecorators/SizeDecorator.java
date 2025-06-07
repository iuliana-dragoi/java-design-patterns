package crode.ConcreteDecorators;

import crode.Coffee;
import crode.Decorator.CoffeeDecorator;

public class SizeDecorator extends CoffeeDecorator {

    private String size;
    private double multiplier;

    public SizeDecorator(Coffee coffee, String size) {
        super(coffee);
        this.size = size;
        this.multiplier = getSizeMultiplier(size);
    }

    private double getSizeMultiplier(String size) {
        switch (size.toLowerCase()) {
            case "small": return 0.8;
            case "medium": return 1.0;
            case "large": return 1.3;
            case "extra large": return 1.6;
            default: return 1.0;
        }
    }

    @Override
    public double getCost() {
        return super.getCost() * multiplier;
    }

    @Override
    public String getDescription() {
        return size + " " + super.getDescription();
    }
}
