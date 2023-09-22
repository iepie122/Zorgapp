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
    static final int STOP = 0;
    static final int Puffelen = 1;
    static final int Bartels = 2;
    static final int Vettel = 3;
    static final int Verstappen = 4;
    static final int Latifi = 5;

    Patient Pierre;         // The currently selected patient
    Patient Bart;           // The currently selected patient
    Patient Sebastian;      // The currently selected patient
    Patient Max;            // The currently selected patient
    Patient Nicholas;       // The currently selected patient
    User currentUser;       // the current user of the program.

    /**
     * Constructor
     */
    Administration(User user) {
        currentUser = user;
        Pierre = new Patient(1, "Van Puffelen", "Pierre", "Paracetamol", LocalDate.of(2000, 2, 29), 1.75, 80);
        Bart = new Patient(23, "Bartels", "Bart", "Zetpil", LocalDate.of(1980, 9, 12), 1.80, 100);
        Sebastian = new Patient(5, "Vettel", "Sebastian", "None", LocalDate.of(1987, 7, 3), 1.75, 62);
        Max = new Patient(33, "Verstappen", "Max", "None", LocalDate.of(1997, 9, 30), 1.81, 72);
        Nicholas = new Patient(6, "Latifi", "Nicholas", "None", LocalDate.of(1995, 6, 29), 1.85, 73);

        System.out.format("Current user: [%d] %s\n", user.getUserID(), user.getUserName());
    }

    void menu() {
        var scanner = new Scanner(System.in);  // User input via this scanner.

        boolean nextCycle = true;
        while (nextCycle) {
            System.out.format("%s\n", "=".repeat(80));
            System.out.format("Current patient: %s\n", Pierre, Bart, Sebastian, Max, Nicholas.fullName());

            /*
             Print menu on screen
            */
            System.out.format("%d:  STOP\n", STOP);
            System.out.format("%d:  View Pierre van Puffelen data\n", Puffelen);
            System.out.format("%d:  View Bart Bartels data\n", Bartels);
            System.out.format("%d:  View Sebastian Vettel data\n", Vettel);
            System.out.format("%d:  View Max Verstappen data\n", Verstappen);
            System.out.format("%d:  View Nicholas Latifi data\n", Latifi);

            System.out.print("enter #choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case STOP: // interrupt the loop
                    nextCycle = false;
                    break;

                case Puffelen:
                    Pierre.viewData();
                    break;

                case Bartels:
                    Bart.viewData();
                    break;

                case Vettel:
                    Sebastian.viewData();
                    break;

                case Verstappen:
                    Max.viewData();
                    break;

                case Latifi:
                    Nicholas.viewData();
                    break;

                default:
                    System.out.println("Please enter a *valid* digit");
                    break;
            }
        }
    }
}
