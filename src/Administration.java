import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Administration {
    User currentUser;
    List<Patient> patients;
    Administration(User user) {
        currentUser = user;
        patients = new ArrayList<>();
        patients.add(new Patient(1, "Van Puffelen", "Pierre", LocalDate.of(2000, 2, 29)));
        patients.add(new Patient(2, "Smith", "John", LocalDate.of(1995, 8, 15)));
        patients.add(new Patient(3, "Johnson", "Alice", LocalDate.of(1982, 4, 7)));
        patients.add(new Patient(4, "Mohamed", "Loul", LocalDate.of(2001, 1, 1)));
        patients.add(new Patient(5, "Adam", "Hlal", LocalDate.of(1995, 4, 1)));
        System.out.format("Current user: [%d] %s %s\n", user.getUserID(), user.getUserName(), user.getUserJob());
    }
    private void displayPatients() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Patient List:");
        for (Patient patient : patients) {
            System.out.format("[%d] %s, %s, %s, %n",
                    patient.getId(),
                    patient.getSurname(),
                    patient.getFirstName(),
                    patient.getDateOfBirth()
                    );
            calcAge(patient);
        }
        boolean runen = true;
        while (runen){
            System.out.println("===================================\n");
            System.out.printf("Enter your choice (%d-%d): \n", SelectPatient, Stop);
            System.out.format("%d  Select Patient \n", SelectPatient);
            System.out.format("%d  Back to the start menu \n", Stop);
            int choice = scanner.nextInt();
            switch (choice) {
                case Stop:
                    runen=false;
                    break;
                case SelectPatient:
                    this.selectPatient();
                    break;
                default:
                    System.out.println("Dit is de default case.");
                    break;
            }
        }
    }
    static final int SelectPatient = 1;
    static final int Stop = 2;
    private void calcAge(Patient patient){
            LocalDate currentDate = LocalDate.now();
            LocalDate dateOfBirth = patient.getDateOfBirth();
            Period age = Period.between(dateOfBirth, currentDate);
            System.out.format("Age: %s%n",age.getYears());
        }
    private void selectPatient() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the patient you want to view:");
        int selectedID = scanner.nextInt();
        for (Patient patient : patients) {
            if (patient.getId() == selectedID) {
                System.out.println("Selected Patient Information:");
                System.out.format("ID: %d%n", patient.getId());
                System.out.format("Last Name: %s%n", patient.getSurname());
                System.out.format("First Name: %s%n", patient.getFirstName());
                System.out.format("Birth Date: %s%n", patient.getDateOfBirth());
                calcAge(patient);
                return;
            }
        }
        System.out.println("Patient with the specified ID not found.");
    }
    private int getUserChoice(Scanner scanner, Enum<?>[] enumValues) {
        int choice;
        int minValue = 1;
        int maxValue = enumValues.length;
        System.out.format("%s\n", "=".repeat(80));
        do {
            System.out.printf("Enter your choice (%d-%d): ", minValue, maxValue);
            while (!scanner.hasNextInt()) {
                System.out.printf("Invalid input. Enter your choice (%d-%d): ", minValue, maxValue);
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (choice < minValue || choice > maxValue);
        return choice;
    }
    private void startMenu(){
        var scanner = new Scanner(System.in);
        System.out.format("%s\n", "=".repeat(80));
        System.out.println("Select what kind of user are you?");
        for(UserJob userJob : UserJob.values()){
            System.out.format("[%d] %s%n", userJob.ordinal() + 1, userJob.name());
        }
        int choiceStartMenu = getUserChoice(scanner, UserJob.values());
        switch (UserJob.values()[choiceStartMenu - 1]) {
            case HuisArts:
                this.huisArtsView();
                break;
            case Tandart:
                this.tandartView();
                break;
            case Fysiotherapeut:
                this.fysiotherapeutView();
                break;
            case Apotheker:
                this.apothekerView();
                break;
            default:
                System.out.println("Error: Invalid choice");
                break;
        }
    }
    static final int STOP = 1;
    static final int StartMenu = 2;
    public void menu() {
        var scanner = new Scanner(System.in);  // User input via this scanner.
        boolean nextCycle = true;
        while (nextCycle) {
            System.out.format("%s\n", "=".repeat(80));
            System.out.format("%d:  STOP\n", STOP);
            System.out.format("%d:  Start Menu\n", StartMenu);
            System.out.print("enter #choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case STOP:
                    nextCycle = false;
                    break;
                case StartMenu:
                    this.startMenu();
                    break;
                default:
                    System.out.println("Please enter a *valid* digit");
                    break;
            }
        }
    }
    static final int displayPatients = 1;
    private void patientsInfo(){
        var scanner = new Scanner(System.in);  // User input via this scanner.
        System.out.format("%s\n", "=".repeat(80));
        System.out.print("enter #choice: \n");
        System.out.format("[%d]  Patient Data \n", displayPatients);
        int choiceStartMenu = scanner.nextInt();
        switch (choiceStartMenu) {
            case displayPatients:
                this.displayPatients();
                break;
            default:
                System.out.println("Please enter a *valid* digit");
                break;
        }
    }
    private void huisArtsView(){
        System.out.println("Welkome bij huisArts home page");
        this.patientsInfo();
    }
    private void tandartView(){
        System.out.println("Welkome bij Tandart home page");
        this.patientsInfo();
    }
    private void fysiotherapeutView(){
        System.out.println("Welkome bij Fysiotherapeut home page");
        this.patientsInfo();
    }
    private void apothekerView(){
        System.out.println("Welkome bij Apotheker home page");
        this.patientsInfo();
    }
}
