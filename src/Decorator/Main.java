package Decorator;

import Decorator.Dish;
import Decorator.GarnishDecorator;
import Decorator.SimpleDish;
import Singleton.Chef;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Chef chef = Chef.getInstance();
        chef.greetCustomer();

        Map<String, List<String>> garnishesMap = GarnishDecorator.garnishesMap;

        int totalDishes = 0; // Räknare för antalet lagade rätter

        String input = "";
        while (!input.equalsIgnoreCase("notan")) {
            System.out.println("Här är våra tillgängliga rätter:");
            for (String dish : garnishesMap.keySet()) {
                System.out.println("- " + dish);
            }

            // Användarinteraktion för att välja maträtt och garnering
            System.out.print("Vilken typ av rätt vill du ha? ");
            String dishType = scanner.nextLine();

            System.out.println("Möjliga garneringar för " + dishType + ":");
            List<String> garnishes = GarnishDecorator.garnishesMap.getOrDefault(dishType, Collections.emptyList());
            for (String garnish : garnishes) {
                System.out.println("- " + garnish);
            }

            System.out.print("Vad vill du garnera " + dishType + " med? ");
            String selectedGarnish = scanner.nextLine();

            // Skapa vald rätt och garnering
            Dish dish = new SimpleDish(dishType);
            Dish garnishedDish = new GarnishDecorator(dish, selectedGarnish);

            // Förbered och visa den dekorerade rätten
            System.out.println("\nBeställningen är klar!");
            garnishedDish.prepare();

            totalDishes++; // Öka räknaren för varje lagad rätt

            System.out.println("Är du nöjd med din maträtt? (Svara med 'ja' eller 'nej')");
            String satisfaction = scanner.nextLine();
            if (satisfaction.equalsIgnoreCase("nej")) {
                System.out.println("Vad tråkigt att höra, jag bjuder gärna på kaffe och en kaka som plåster på såren!");
            } else {
                System.out.println("Underbart, vad glad jag blir!");
            }

            System.out.println("Vill du fortsätta beställa mat eller ta in notan?");
            System.out.println("Skriv 'notan' om du vill avsluta eller annars tryck Enter för att fortsätta.");
            input = scanner.nextLine();

        }
        System.out.println("Antal lagade rätter idag: " + totalDishes); // Skriv ut totalen av lagade rätter
        scanner.close();
    }
}
