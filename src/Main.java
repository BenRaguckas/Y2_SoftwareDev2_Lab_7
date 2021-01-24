/**
 * Overall issues :
 * 1. Interacting with text boxes seems to overlap JPanel above JMenuBar until a tab is changed.
 * 2. Interfaces could be moved under a single file.
 */
public class Main {
    public static void main(String[] args) {
        /*
        System.out.println(new Building());
        System.out.println(new Building(5, "Hip"));

        System.out.println(new House());
        System.out.println(new House(6, "Dutch", 3));

        System.out.println(new ApartmentBlock());
        System.out.println(new ApartmentBlock(4, "Flat", 20));

        System.out.println(new OfficeBlock());
        System.out.println(new OfficeBlock(5, "M Shaped", 14));
        */
        new Manager();
    }
}

class Manager {
    public Manager() {
        Window display = new Window(480,270, "Structure Manager");
        display.addTab(new Tab(new Building()));
    }
}