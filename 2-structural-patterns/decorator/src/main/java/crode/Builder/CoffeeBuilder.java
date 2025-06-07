package crode.Builder;

import crode.Coffee;
import crode.ConcreteDecorators.*;

public class CoffeeBuilder {

    private Coffee coffee;

    public CoffeeBuilder(Coffee baseCoffee) {
        this.coffee = baseCoffee;
    }

    public CoffeeBuilder addMilk() {
        coffee = new MilkDecorator(coffee);
        return this;
    }

    public CoffeeBuilder addSugar() {
        coffee = new SugarDecorator(coffee);
        return this;
    }

    public CoffeeBuilder addWhipCream() {
        coffee = new WhipCreamDecorator(coffee);
        return this;
    }

    public CoffeeBuilder addVanillaSyrup() {
        coffee = new VanillaSyrupDecorator(coffee);
        return this;
    }

    public CoffeeBuilder addExtraShot() {
        coffee = new ExtraShotDecorator(coffee);
        return this;
    }

    public CoffeeBuilder makeSize(String size) {
        coffee = new SizeDecorator(coffee, size);
        return this;
    }

    public Coffee build() {
        return coffee;
    }
}
