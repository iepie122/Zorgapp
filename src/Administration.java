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
    static final int VIEW = 1;

    Patient Adam;// The currently selected patient
    Patient Natasha;
    Patient Anton;
    Patient Shannon;
    Patient Daisy;

    User currentUser;               // the current user of the program.

    /**
     * Constructor
     */
    Administration(User user) {
        currentUser = user;
        Adam  = new Patient(1, "Hlal", "Adam", LocalDate.of(
                1995, 7, 1), 65, 1.78);
        Natasha = new Patient(2,"Anderson", "Natasha",LocalDate.of(
                2000,8,25),55,1.65);
        Anton   = new Patient(3,"De Vries","Anton",LocalDate.of(
                1996,1,6),75,1.85);
        Shannon = new Patient(4,"Sahertian","Shannon",LocalDate.of(
                1985,12,26),67,1.73);
        Daisy   = new Patient(5,"Dai","Daisy",LocalDate.of(
                1998,5,15),51,1.67);


        System.out.format("Current user: [%d] %s\n", user.getUserID(), user.getUserName());
    }


    void menu() {
        var scanner = new Scanner(System.in);  // User input via this scanner.

        boolean nextCycle = true;
        while (nextCycle) {
            System.out.format("%s\n", "=".repeat(80));
            System.out.format("Patient 1: %s\n", Adam.fullName());
            System.out.format("Patient 2: %s\n", Natasha.fullName());
            System.out.format("Patient 3: %s\n", Anton.fullName());
            System.out.format("Patient 4: %s\n", Shannon.fullName());
            System.out.format("Patient 5: %s\n", Daisy.fullName());


            /*
             Print menu on screen
            */
            System.out.format("%d:  STOP\n", STOP);
            System.out.format("%d:  View patient data\n", VIEW);

            System.out.print("enter #choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case STOP: // interrupt the loop
                    nextCycle = false;
                    break;

                case VIEW:
                    Adam.viewData();
                    Natasha.viewData();
                    Anton.viewData();
                    Shannon.viewData();
                    Daisy.viewData();
                    break;

                default:
                    System.out.println("Please enter a *valid* digit");
                    break;
            }
        }
    }
}
