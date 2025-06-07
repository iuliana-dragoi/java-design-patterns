package crode.ConcreteDecorators;

import crode.Coffee;
import crode.Decorator.CoffeeDecorator;

public class ExtraShotDecorator extends CoffeeDecorator {

    public ExtraShotDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Extra Shot";
    }
}
