import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;

/**
 * class Administration represents the core of the application by showing
 * the main menu, from where all other functionality is accessible, either
 * directly or via sub-menus.
 * An Administration instance needs a User as input, which is passed via the
 * constructor to the data member 'currentUser'.
 * The patient data is available via the data member currentPatient.
 */
class Administration {

    List<Patient> patientList = new ArrayList<>();

public void patientData() {
    System.out.println("Patientenlijst:");

    for (Patient patient : patientList) {
        System.out.println(patient.toString());

    }
menu();

}

    Patient Pierre = new Patient(1, "Van Puffelen", "Pierre", "Paracetamol", LocalDate.of(2000, 2, 29), 1.75, 80);
    Patient Bart = new Patient(23, "Bartels", "Bart", "Pijnstiller", LocalDate.of(1980, 9, 12), 1.80, 100);
    Patient Sebastian = new Patient(5, "Vettel", "Sebastian", "No meds", LocalDate.of(1987, 7, 3), 1.75, 62);
    Patient Max = new Patient(33, "Verstappen", "Max", "No meds", LocalDate.of(1997, 9, 30), 1.81, 72);
    Patient Nicholas = new Patient(6, "Latifi", "Nicholas", "No meds", LocalDate.of(1995, 6, 29), 1.85, 73);
    User Huisarts = new User(1, "Huisarts");
    User Tandarts = new User(2, "Tandarts");

    static final int STOP = 0;
    static final int Puffelen = 1;
    static final int Bartels = 2;
    static final int Vettel = 3;
    static final int Verstappen = 4;
    static final int Latifi = 5;

    /**
     * Constructor
     */

    User currentUser;
    Administration(User user) {
        currentUser = user;
        System.out.format("Current user: [%d] %s\n", user.getUserID(), user.getUserName());

    }

    void menu() {
        var scanner = new Scanner(System.in);  // User input via this scanner.
        boolean nextCycle = true;
        while (nextCycle) {
            System.out.format("%s\n", "=".repeat(80));
            System.out.format("Current patient: %s\n", Pierre, Bart, Sebastian, Max, Nicholas.fullName());

            System.out.format("%d:  STOP\n", STOP);
            System.out.format("%d:  View Pierre van Puffelen data\n", Puffelen);
            System.out.format("%d:  View Bart Bartels data\n", Bartels);
            System.out.format("%d:  View Sebastian Vettel data\n", Vettel);
            System.out.format("%d:  View Max Verstappen data\n", Verstappen);
            System.out.format("%d:  View Nicholas Latifi data\n", Latifi);

        List<User> Userlist = new ArrayList<>();

        Userlist.add(Huisarts);
        Userlist.add(Tandarts);

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

            case 6:
                Pierre.EditData();
                break;

            case 7:
                Bart.EditData();
                break;

            case 8:
                Sebastian.EditData();
                break;

            case 9:
                Max.EditData();
                break;

            case 10:
                Nicholas.EditData();
                break;

            default:
                System.out.println("Please enter a *valid* digit");
                break;

            }
        }
    }

    static final int HuisArts = 11;
    static final int TandArts = 12;
    void menu2() {
        var scanner = new Scanner(System.in);
        boolean nextCycle = true;

    while (nextCycle) {
        System.out.format("%s\n", "=".repeat(80));
        System.out.format("Current user: %s\n", currentUser.getUserName());

        System.out.println("Enter 11 to view the patientlist (HuisArts)");
        System.out.println("Enter 12 to view the patientlist (TandArts)");
        System.out.println("Enter 0 to STOP");

            int choice = scanner.nextInt();
            switch (choice) {

                case STOP: // interrupt the loop
                    nextCycle = false;
                    break;

                case HuisArts:
                    this.patientData();

                case TandArts:
                    this.patientData();
                    break;
            }
        }
    }
}
