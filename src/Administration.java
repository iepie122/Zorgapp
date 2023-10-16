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

    Patient Pierre = new Patient(1, "Van Puffelen", "Pierre", "Hydrochloorthiazide", LocalDate.of(2000, 2, 29), 1.75, 80, "Hypertensie", "Toets [6]");
    Patient Bart = new Patient(23, "Bartels", "Bart", "Ibuprofen", LocalDate.of(1980, 9, 12), 1.80, 100, "Migraine", "Toets [7]");
    Patient Sebastian = new Patient(5, "Vettel", "Sebastian", "Geen medicatie", LocalDate.of(1987, 7, 3), 1.75, 62, "Geen historie", "Toets [8]");
    Patient Max = new Patient(33, "Verstappen", "Max", "Geen medicatie", LocalDate.of(1997, 9, 30), 1.81, 72, "Geen historie", "Toets [9]");
    Patient Nicholas = new Patient(6, "Latifi", "Nicholas", "Geen medicatie", LocalDate.of(1995, 6, 29), 1.85, 73, "Geen historie", "Toets [10]");
    User Huisarts = new User(1, "Huisarts");
    User Tandarts = new User(2, "Tandarts");
    User Apotheker = new User(3, "Apotheker");
    User Fysiotherapeut = new User(4, "Fysiotherapeut");
    User Internist = new User(5, "Internist");

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
            System.out.format("[1] Pierre van Puffelen\n", Puffelen, Pierre.fullName());
            System.out.format("[2] Bart Bartels\n", Bartels, Bart.fullName());
            System.out.format("[3] Sebastian Vettel\n", Vettel, Sebastian.fullName());
            System.out.format("[4] Max Verstappen\n", Verstappen, Max.fullName());
            System.out.format("[5] Nicholas Latifi\n", Latifi, Nicholas.fullName());
            System.out.format("Toets [0] om naar het vorige menu te gaan\n", STOP);

        List<User> Userlist = new ArrayList<>();

        Userlist.add(Huisarts);
        Userlist.add(Tandarts);
        Userlist.add(Apotheker);
        Userlist.add(Fysiotherapeut);
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
            System.out.format("Wat wilt u aanpassen voor dossier %s ?\n", patient.fullName());
            System.out.println("[1] VOORNAAM");
            System.out.println("[2] ACHTERNAAM");
            System.out.println("[3] GEBOORTEDATUM");
            System.out.println("[4] LENGTE");
            System.out.println("[5] GEWICHT");
            System.out.println("[6] MEDICATIE");
            System.out.println("[7] HISTORIE");
            System.out.println("Toets [0] om naar het vorige menu te gaan");

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
                    System.out.print("Nieuwe geboortedatum (yyyy-MM-dd): ");
                    LocalDate newBirthdate = LocalDate.parse(scanner.next());
                    patient.setDateOfBirth(newBirthdate);
                    break;
                case 4:
                    System.out.print("Nieuwe lengte (in meters): ");
                    double newHeight = scanner.nextDouble();
                    patient.setHeight(newHeight);
                    break;
                case 5:
                    System.out.print("Nieuw gewicht (in kilogram): ");
                    int newWeight = (int) scanner.nextDouble();
                    patient.setWeight((int) newWeight);
                    break;
                case 6:
                    System.out.print("Nieuwe medicatie: ");
                    scanner.nextLine();  // Consume newline
                    String newMedication = scanner.nextLine();
                    patient.setMedication(newMedication);
                    break;
                case 7:
                    System.out.print("Nieuwe historie: ");
                    scanner.nextLine();  // Consume newline
                    String newHistory = scanner.nextLine();
                    patient.setHistory(newHistory);
                    break;
                default:
                    System.out.println("Ongeldig, toets een geldige waarde in a.u.b.");
                    break;
            }
        }
    }

    static final int HuisArts = 1;
    static final int TandArts = 2;
    static final int ApoTheker = 3;
    static final int FysioTherapeut = 4;
    static final int InterNist = 5;
    void menu2() {
        var scanner = new Scanner(System.in);
        boolean nextCycle = true;

    while (nextCycle) {
        System.out.format("%s\n", "=".repeat(80));
        System.out.format("Current user: %s\n", currentUser.getUserName());

        System.out.format("Wat is uw functie?\n");
        System.out.println("[1] HUISARTS");
        System.out.println("[2] TANDARTS");
        System.out.println("[3] APOTHEKER");
        System.out.println("[4] FYSIOTHERAPEUT");
        System.out.println("[5] INTERNIST");
        System.out.println("Toets [0] om te stoppen");

            int choice = scanner.nextInt();
            switch (choice) {

                case STOP: // interrupt the loop
                    nextCycle = false;
                    break;

                case HuisArts:
                    this.patientData();
                    break;

                case TandArts:
                    this.patientData();
                    break;

                case ApoTheker:
                    this.patientData();
                    break;

                case FysioTherapeut:
                    this.patientData();
                    break;

                case InterNist:
                    this.patientData();
                    break;
            }
        }
    }
}