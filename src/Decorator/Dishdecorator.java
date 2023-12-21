package Decorator;

public abstract class Dishdecorator implements Dish { // Decorator
    protected Dish decoratedDish;

    public Dishdecorator(Dish decoratedDish) {
        this.decoratedDish = decoratedDish;
    }

    @Override
    public void prepare() {
        decoratedDish.prepare();
    }
}
