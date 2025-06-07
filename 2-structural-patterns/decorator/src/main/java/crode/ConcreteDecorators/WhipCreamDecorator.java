package crode.ConcreteDecorators;

import crode.Coffee;
import crode.Decorator.CoffeeDecorator;

public class WhipCreamDecorator extends CoffeeDecorator {

    public WhipCreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.7;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Whip Cream";
    }
}
