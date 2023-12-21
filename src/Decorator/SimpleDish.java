package Decorator;

import Decorator.Dish;

public class SimpleDish implements Dish { // Konkret komponentklass

    private String dishType;

    public SimpleDish(String dishType) {
        this.dishType = dishType;
    }

    @Override
    public void prepare() {
        System.out.println(dishType + " är redo att serveras.");
    }
}
