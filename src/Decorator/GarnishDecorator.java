package Decorator;

import Decorator.Dishdecorator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GarnishDecorator extends Dishdecorator {

    private String garnish;

    public static final Map<String, List<String>> garnishesMap = new HashMap<>();
    static {
        garnishesMap.put("Pasta Arrabiata", Arrays.asList("Parmesan", "Basilika", "Burrata"));
        garnishesMap.put("Ceasar Sallad", Arrays.asList("Kyckling", "Krutonger", "Parmesan"));
        garnishesMap.put("Fisk Wallenbergare", Arrays.asList("Citron", "Svartpeppar", "Gräddsås"));
        garnishesMap.put("Hummersoppa", Arrays.asList("Krutonger", "Persilja", "Grädde"));
    }

    public GarnishDecorator(Dish decoratedDish, String garnish) {
        super(decoratedDish);
        this.garnish = garnish;
    }

    @Override
    public void prepare() {
        super.prepare();
        addGarnish();
    }

    private void addGarnish() {
        if (garnishesMap.containsKey(decoratedDish.getClass().getSimpleName())) {
            List<String> garnishes = garnishesMap.get(decoratedDish.getClass().getSimpleName());
            if (garnishes.contains(garnish)) {
                System.out.println("Added garnish: " + garnish);
            }
        }
    }
}
