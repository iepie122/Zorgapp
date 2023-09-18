import java.time.LocalDate;

class Patient {
   static final int RETURN      = 0;
   static final int SURNAME     = 1;
   static final int FIRSTNAME   = 2;
   static final int DATEOFBIRTH = 3;
   static final int HEIGHT      = 4;
   static final int WEIGHT      = 5;
   static final int BMI         = 6;

   int       id;
   String    surname;
   String    firstName;
   LocalDate dateOfBirth;
   double    height;
   int       weight;

    /**
     * Constructor
     */
    Patient(int id, String surname, String firstName, LocalDate dateOfBirth, double height, int weight) {
        this.id = id;
        this.surname = surname;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.weight = weight;
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
        System.out.format("===== Patient id=%d ==============================\n", id);
        System.out.format("%-17s %s\n", "Surname:", surname);
        System.out.format("%-17s %s\n", "firstName:", firstName);
        System.out.format("%-17s %s\n", "Date of birth:", dateOfBirth);
        System.out.format("%-17s %s\n", "Height (m):", height);
        System.out.format("%-17s %s\n", "Weight (kg):", weight);
        System.out.format("%-17s %s\n", "BMI:", CalcBmi());
    }

    /**
     * Shorthand for a Patient's full name
     */
    String fullName() {
        return String.format("%s %s [%s]", firstName, surname, dateOfBirth.toString());
    }
    double CalcBmi() {
        double bmi = weight / (height * height);
        double roundedBmi = Math.round(bmi* 100.0) / 100.0;
        // Rounds to two decimals
        return roundedBmi;
    }
}
