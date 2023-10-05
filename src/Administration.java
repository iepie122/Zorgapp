import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

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

    Patient Pierre = new Patient(1, "Van Puffelen", "Pierre", "Hydrochloorthiazide voor hoge bloeddruk", LocalDate.of(2000, 2, 29), 1.75, 80, "Toets 6 om dit dossier te wijzigen");
    Patient Bart = new Patient(23, "Bartels", "Bart", "Ibuprofen voor rugpijn", LocalDate.of(1980, 9, 12), 1.80, 100, "Toets 7 om dit dossier te wijzigen");
    Patient Sebastian = new Patient(5, "Vettel", "Sebastian", "Geen historie beschikbaar", LocalDate.of(1987, 7, 3), 1.75, 62, "Toets 8 om dit dossier te wijzigen");
    Patient Max = new Patient(33, "Verstappen", "Max", "Geen historie beschikbaar", LocalDate.of(1997, 9, 30), 1.81, 72, "Toets 9 om dit dossier te wijzigen");
    Patient Nicholas = new Patient(6, "Latifi", "Nicholas", "Geen historie beschikbaar", LocalDate.of(1995, 6, 29), 1.85, 73, "Toets 10 om dit dossier te wijzigen");
    User Huisarts = new User(1, "Huisarts");
    User Internist = new User(2, "Internist");

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
            System.out.format("%d:  Toon dossier Pierre van Puffelen\n", Puffelen);
            System.out.format("%d:  Toon dossier Bart Bartels\n", Bartels);
            System.out.format("%d:  Toon dossier Sebastian Vettel\n", Vettel);
            System.out.format("%d:  Toon dossier Max Verstappen\n", Verstappen);
            System.out.format("%d:  Toon dossier Nicholas Latifi\n", Latifi);

        List<User> Userlist = new ArrayList<>();

        Userlist.add(Huisarts);
        Userlist.add(Internist);

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
                editMenu(Pierre);
                break;

            case 7:
                editMenu(Bart);
                break;

            case 8:
                editMenu(Sebastian);
                break;

            case 9:
                editMenu(Max);
                break;

            case 10:
                editMenu(Nicholas);
                break;

            default:
                System.out.println("Toets een geldige waarde in a.u.b.");
                break;

            }
        }
    }

    void editMenu(Patient patient) {
        var scanner = new Scanner(System.in);
        boolean editCycle = true;

        while (editCycle) {
            System.out.format("%s\n", "=".repeat(80));
            System.out.format("Editing patient data for %s:\n", patient.fullName());
            System.out.println("0: STOPPEN");
            System.out.println("1: Wijzig voornaam");
            System.out.println("2: Wijzig achternaam");
            System.out.println("3: Wijzig historie");
            System.out.println("4: Wijzig geboortedatum");
            System.out.println("5: Wijzig lengte");
            System.out.println("6: Wijzig gewicht");

            int editChoice = scanner.nextInt();
            switch (editChoice) {
                case 0:
                    editCycle = false;
                    break;
                case 1:
                    System.out.print("Nieuwe voornaam: ");
                    scanner.nextLine();  // Consume newline
                    String newName = scanner.nextLine();
                    patient.setFirstname(newName);
                    break;
                case 2:
                    System.out.print("Nieuwe achternaam: ");
                    scanner.nextLine();  // Consume newline
                    String newSurname = scanner.nextLine();
                    patient.setSurname(newSurname);
                    break;
                case 3:
                    System.out.print("Nieuwe historie: ");
                    scanner.nextLine();  // Consume newline
                    String newMedication = scanner.nextLine();
                    patient.setMedication(newMedication);
                    break;
                case 4:
                    System.out.print("Nieuwe geboortedatum (yyyy-MM-dd): ");
                    LocalDate newBirthdate = LocalDate.parse(scanner.next());
                    patient.setDateOfBirth(newBirthdate);
                    break;
                case 5:
                    System.out.print("Nieuwe lengte (in meters): ");
                    double newHeight = scanner.nextDouble();
                    patient.setHeight(newHeight);
                    break;
                case 6:
                    System.out.print("Nieuw gewicht (in kilogram): ");
                    int newWeight = (int) scanner.nextDouble();
                    patient.setWeight((int) newWeight);
                    break;
                default:
                    System.out.println("Ongeldig. Toets een geldige waarde in a.u.b.");
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

        System.out.println("Toets 11 als u HUISARTS wilt doorgaan");
        System.out.println("Toets 12 als u INTERNIST wilt doorgaan");
        System.out.println("Toets 0 om te STOPPEN");

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
