import java.time.LocalDate;
import java.time.Period;

class Patient {
   int       id;
   String    surname;
   String    firstName;
   LocalDate dateOfBirth;
    Patient(int id, String surname, String firstName, LocalDate dateOfBirth ) {
        this.id = id;
        this.surname = surname;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
    }
    public int getId() {
        return id;
    }
    String getSurname() {
        return surname;
    }
    String getFirstName() {
        return firstName;
    }
    LocalDate getDateOfBirth() { return dateOfBirth; }
//    String fullName() {
//        return String.format("%s %s [%s]", firstName, surname, dateOfBirth.toString());
//    }
}
