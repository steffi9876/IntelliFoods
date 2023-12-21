package Singleton;

public class Chef { // Singleton mönster
    private static Chef instance;

    private Chef() {
        // Privat konstruktor förhindrar instansiering utanför klassen
    }
    public static Chef getInstance() {
        if (instance == null) {
            instance = new Chef();
        }
        return instance;
    }

    public void greetCustomer() {
        System.out.println("Välkommen till restaurang IntelliFood! \nJag heter Monica och jag är din kock för kvällen! \n ");
    }
}
