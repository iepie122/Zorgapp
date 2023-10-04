import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


class Patient {
   static final int RETURN      = 0;
   static final int SURNAME     = 1;
   static final int FIRSTNAME   = 2;
   static final int DATEOFBIRTH = 3;
   static final int AGE         = 4;
   static final int HEIGHT      = 5;
   static final int WEIGHT      = 6;
   static final int BMI         = 7;
   static final int MEDICATION  = 8;


   int       id;
   String    surname;
   String    firstName;
   LocalDate dateOfBirth;
   double    height;
   int       weight;
   String    medication;



    /**
     * Constructor
     */
    Patient(int id, String surname, String firstName, String medication, LocalDate dateOfBirth, double height, int weight) {
        this.id = id;
        this.surname = surname;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.height = height;
        this.weight = weight;
        this.medication = medication;


    }

    String getSurname() {return surname;}
    LocalDate getDateOfBirth() {return dateOfBirth;}

    double getHeight() {return height;}
    int getWeight() {return weight;}

    String getFirstName() {
        return firstName;
    }
    String getMedication() {
        return medication;
    }








    /**
     * Display patient data.
     */
    void viewData() {
        var scanner = new Scanner(System.in);
        System.out.format("===== Patient id=%d ==============================\n", id);
        System.out.format("%-17s %s\n", "Surname:", surname);
        System.out.format("%-17s %s\n", "firstName:", firstName);
        System.out.format("%-17s %s\n", "Date of birth:", dateOfBirth);
        System.out.format("%-17s %s\n", "Age:", calcAge());
        System.out.format("%-17s %s\n", "Height (m):", height);
        System.out.format("%-17s %s\n", "Weight (kg):", weight);
        System.out.format("%-17s %s\n", "BMI:", CalcBmi());
        System.out.format("%-17s %s\n", "Medication:", medication);


    }

    void EditData() {
        var scanner = new Scanner(System.in);
        System.out.format("Wat wilt u veranderen?");
        System.out.format("%-17s %s\n", "Surname:", surname);
        System.out.format("%-17s %s\n", "firstName:", firstName);
        System.out.format("%-17s %s\n", "Date of birth:", dateOfBirth);
        System.out.format("%-17s %s\n", "Age:", calcAge());
        System.out.format("%-17s %s\n", "Height (m):", height);
        System.out.format("%-17s %s\n", "Weight (kg):", weight);
        System.out.format("%-17s %s\n", "BMI:", CalcBmi());
        System.out.format("%-17s %s\n", "Medication:", medication);


        scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    String surname;
                    System.out.print("Nieuwe achternaam: ");
                    Scanner input = new Scanner(System.in);
                    surname = input.next();
                    System.out.println();
                    System.out.println("Achternaam: " + surname);
                    break;





                // Add more cases if necessary
                case 2:

                    String firstName;
                    System.out.print("New First Name: ");
                    input = new Scanner(System.in);
                    firstName = input.next();
                    System.out.println("first name " + firstName);
                    System.out.println();
                    System.out.println(firstName);
                    break;


                default:
                    System.out.println("Invalid choice");

            }

            // Close the scanner when done





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
