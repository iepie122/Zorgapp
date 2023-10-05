import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;


class Patient {
//   static final int RETURN      = 0;
//   static final int SURNAME     = 1;
//   static final int FIRSTNAME   = 2;
//   static final int DATEOFBIRTH = 3;
//   static final int AGE         = 4;
//   static final int HEIGHT      = 5;
//   static final int WEIGHT      = 6;
//   static final int BMI         = 7;
//   static final int MEDICATION  = 8;


   int       id;
   String    surname;
   String    firstName;
   LocalDate dateOfBirth;
   double    height;
   int       weight;
   String    medication;
   String    editData;



    /**
     * Constructor
     */
    Patient(int id, String surname, String firstName, String medication, LocalDate dateOfBirth, double height, int weight, String editData) {
        this.id = id;
        this.surname = surname;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.weight = weight;
        this.medication = medication;
        this.editData = editData;

    }

//    String getSurname() {return surname;}
//    LocalDate getDateOfBirth() {return dateOfBirth;}
//    double getHeight() {return height;}
//    int getWeight() {return weight;}
//    String getFirstName() {
//        return firstName;
//    }
//    String getMedication() {
//        return medication;
//    }

    /**
     * Display patient data.
     */
    void viewData() {
        var scanner = new Scanner(System.in);
        System.out.format("===== Patient id=%d ==============================\n", id);
        System.out.format("%-17s %s\n", "Achternaam:", surname);
        System.out.format("%-17s %s\n", "Voornaam:", firstName);
        System.out.format("%-17s %s\n", "Geboortedatum:", dateOfBirth);
        System.out.format("%-17s %s\n", "Leeftijd:", calcAge());
        System.out.format("%-17s %s\n", "Lengte (m):", height);
        System.out.format("%-17s %s\n", "Gewicht (kg):", weight);
        System.out.format("%-17s %s\n", "BMI:", CalcBmi());
        System.out.format("%-17s %s\n", "Historie:", medication);
        System.out.format("%-17s %s\n", "Dossier wijzigen?", editData);


    }

    public void setFirstname(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    /**
     * Shorthand for a Patient's full name
     */
    String fullName() {
        return String.format("%s %s [%s]", firstName, surname, dateOfBirth, medication.toString());
    }
    double CalcBmi() {
        // This calculates the patient's BMI
        double bmi = weight / (height * height);
        double roundedBmi = Math.round(bmi* 100.0) / 100.0;
        return roundedBmi;
    }
    Integer calcAge() {
        // This calculates the patient's age
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(dateOfBirth, currentDate);
        return (period.getYears());
        }
    }