package crode.ConcreteDecorators;

import crode.Coffee;
import crode.Decorator.CoffeeDecorator;

public class VanillaSyrupDecorator extends CoffeeDecorator {

    public VanillaSyrupDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.6;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Vanilla Syrup";
    }
}
