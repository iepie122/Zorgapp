import java.time.LocalDate;
import java.util.Scanner;

/**
 * class Administration represents the core of the application by showing
 * the main menu, from where all other functionality is accessible, either
 * directly or via sub-menus.
 * An Administration instance needs a User as input, which is passed via the
 * constructor to the data member 'currentUser'.
 * The patient data is available via the data member currentPatient.
 */
class Administration {
    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }


    static final int Puffelen = 1;
    static final int Tiegelaar = 2;
    static final int Kiezelsteen = 3;
    static final int Bootsman = 4;
    static final int Anderson = 5;


    Patient Pierre;            // The currently selected patient
    Patient Bart;            // The currently selected patient
    Patient Kees;
    Patient Sandra;
    Patient Natasha;
    User currentUser;               // the current user of the program.

    /**
     * Constructor
     */
    Administration(User user) {
        currentUser = user;
        Pierre = new Patient(1, "Van Puffelen", "Pierre", LocalDate.of(2000, 2, 29), "paracetemol", "Leeg");
        Bart = new Patient(3, "Tiegelaar", "Bart", LocalDate.of(2001, 6, 18), "Antibiotica", "Pfeiffer");
        Kees = new Patient(4, "Kiezelsteen", "Kees", LocalDate.of(1995, 12, 30), "Aurobindo", "Depression");
        Sandra = new Patient(5, "Bootsman", "Sandra", LocalDate.of(1999, 7, 17), "Anticonceptie, Paracetemol, Ibuprofen", "Menstruatie klachten");
        Natasha = new Patient(6, "Anderson", "Natasha", LocalDate.of(1982, 4, 16), "Anticonceptie, Ibuprofen", "Hoofdpijn");

        System.out.format("Current user: [%d] %s\n", user.getUserID(), user.getUserName(), user.getUserJob());
    }

    void patientenlijst() {
        var scanner = new Scanner(System.in);  // User input via this scanner.
        System.out.format("%s\n", "=".repeat(80));
        System.out.format("patiëntenlijst:\n", Pierre, Bart, Kees, Sandra, Natasha.fullName());
        System.out.format("%s\n", "=".repeat(80));
        System.out.format("%d: Pierre van Puffelen\n", Puffelen);
        System.out.format("%s\n", "-".repeat(80));
        System.out.format("%d: Bart Tiegelaar\n", Tiegelaar);
        System.out.format("%s\n", "-".repeat(80));
        System.out.format("%d: Kees Kiezelsteen\n", Kiezelsteen);
        System.out.format("%s\n", "-".repeat(80));
        System.out.format("%d: Sandra Bootsman\n", Bootsman);
        System.out.format("%s\n", "-".repeat(80));
        System.out.format("%d: Natasha Anderson\n", Anderson);
        System.out.format("%s\n", "=".repeat(80));

        int choice = scanner.nextInt();
        switch (choice) {

            case Puffelen:
                Pierre.viewData();
                break;

            case Tiegelaar:
                Bart.viewData();
                break;

            case Kiezelsteen:
                Kees.viewData();
                break;

            case Bootsman:
                Sandra.viewData();
                break;

            case Anderson:
                Natasha.viewData();
                break;


            default:
                System.out.println("Please enter a *valid* digit");
                break;
        }
    }

    void geenToegang() {
        System.out.format("%s\n", "=".repeat(80));
        System.out.println("Sorry, u heeft geen toegang tot een patiëntenlijst");
        System.out.format("%s\n", "=".repeat(80));
    }

    static final int Huisarts = 1;
    static final int Apotheker = 2;
    static final int Fysiotherapeut = 3;
    static final int Tandarts = 4;
    static final int GeenVanBovenstaande = 0;

    void startMenu() {
        var scanner = new Scanner(System.in);  // User input via this scanner.
        System.out.format("%s\n", "=".repeat(80));
        System.out.println("Wat is uw beroep?");
        System.out.format("%s\n", "=".repeat(80));


        System.out.format("%d: Huisarts\n", Huisarts);
        System.out.format("%s\n", "-".repeat(80));

        System.out.format("%d: Apotheker\n", Apotheker);
        System.out.format("%s\n", "-".repeat(80));

        System.out.format("%d: Fysiotherapeut\n", Fysiotherapeut);
        System.out.format("%s\n", "-".repeat(80));

        System.out.format("%d: Tandarts\n", Tandarts);
        System.out.format("%s\n", "-".repeat(80));

        System.out.format("%d: Geen van bovenstaande\n", GeenVanBovenstaande);
        System.out.format("%s\n", "=".repeat(80));


        int choice = scanner.nextInt();
        switch (choice) {

            case Huisarts:
                patientenlijst();
                break;

            case Apotheker:
                patientenlijst();
                break;

            case Fysiotherapeut:
                patientenlijst();
                break;

            case Tandarts:
                patientenlijst();
                break;

            case GeenVanBovenstaande:
                geenToegang();
                break;

            default:
                System.out.println("Please enter a *valid* digit");
                break;
        }
    }

    static final int STOP = 0;
    static final int StartMenu = 1;

    void menu() {
        var scanner = new Scanner(System.in);  // User input via this scanner.

        boolean nextCycle = true;
        while (nextCycle) {
            System.out.format("%s\n", "=".repeat(80));

            System.out.format("%d:  Exit\n", STOP);
            System.out.format("%d: Open Start Menu \n", StartMenu);
            System.out.println("Type choice:");
            System.out.format("%s\n", "=".repeat(80));
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case STOP: // interrupt the loop
                        nextCycle = false;
                        break;
                    case StartMenu:
                        this.startMenu();
                        break;
                    default:
                        System.out.println("Please enter a *valid* digit");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Input doesn't match expected input, please try again");
                wait(2000);
                scanner.nextLine();
                continue;
            }
        }
    }
}