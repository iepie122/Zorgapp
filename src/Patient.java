import javax.swing.text.EditorKit;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.*;


class Patient {
   static final int RETURN      = 0;
   static final int SURNAME     = 1;
   static final int FIRSTNAME   = 2;
   static final int DATEOFBIRTH = 3;



   int       id;
   String    surname;
   String    firstName;
   LocalDate dateOfBirth;
   String mediHistory;
   String diagnoses;



    /**
     * Constructor
     */
    Patient(int id, String surname, String firstName, LocalDate dateOfBirth, String mediHistory, String diagnoses) {
        this.id = id;
        this.surname = surname;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.mediHistory = mediHistory;
        this.diagnoses = diagnoses;
    }

    String getSurname() {
        return surname;
    }

    String getFirstName() {
        return firstName;
    }

    /**
     * Display patient data.
     */
    void viewData() {
        var scanner = new Scanner(System.in);  // User input via this scanner.
        System.out.format("===== Patient id=%d ==============================\n", id);
        System.out.format("%-17s %s\n", "Surname:", surname);
        System.out.format("%-17s %s\n", "firstName:", firstName);
        System.out.format("%-17s %s\n", "Date of birth:", dateOfBirth);
        System.out.format("%-17s %s\n", "Medicine History:", mediHistory);
        System.out.format("%-17s %s\n","Eerdere diagnoses:", diagnoses);

        int choice = scanner.nextInt();
        switch (choice) {
            case 0:
                Edit

            case 1:

        }


    }


    /**
     * Shorthand for a Patient's full name
     */
    String fullName() {
        return String.format("%s %s [%s] %s %s", firstName, surname, dateOfBirth, mediHistory, diagnoses);

    }
}
