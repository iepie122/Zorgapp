import java.time.*;
import java.util.Scanner;

class Patient {
    static final int RETURN = 0;
    static final int SURNAME = 1;
    static final int FIRSTNAME = 2;
    static final int DATEOFBIRTH = 3;

    int id;
    String surname;
    String firstName;
    LocalDate dateOfBirth;
    double weight;
    double length;
    /**
     * Constructor
     */
    Patient(int id, String surname, String firstName, LocalDate dateOfBirth,
            double weight, double length) {
        this.id = id;
        this.surname = surname;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.length = length;

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
        System.out.format("%-17s %s\n", "Achternaam:", surname);
        System.out.format("%-17s %s\n", "Voornaam:", firstName);
        System.out.format("%-17s %s\n", "Geboortedatum:", dateOfBirth);
        System.out.format("%-17s %s\n", "Gewicht:", weight);
        System.out.format("%-17s %s\n", "Lengte:", length);
        System.out.format("%-17s %s\n", "Leeftijd:", calcAge());
        System.out.format("%-17s %s\n", "BMI:", calcBmi());
    }


    /**
     * Shorthand for a Patient's full name
     */
    String fullName() {
        return String.format("%s %s [%s]", firstName, surname, dateOfBirth.toString());
    }

    Integer calcAge() {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateOfBirth, currentDate);
        return (period.getYears());
        //Dit is leeftijd berekening
    }
    double calcBmi() {
        double bmi = weight / (length * length);
        double roundedBmi = Math.round(bmi * 100.0) / 100.0;
        return roundedBmi;
        //Dit is BMI berekening na het afronden
    }
}


