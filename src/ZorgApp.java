import java.time.LocalDate;

class ZorgApp {
    public static void main(String[] args) {
        User user = new User(1, "Mart El Camera");
        Administration administration = new Administration(user);

        administration.menu2();
    }
}