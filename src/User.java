//import java.awt.*;
//import java.util.Scanner;
//import java.time.LocalDate;

class User {
    static final int USERNAME = 1;
    static final int USERID = 2;
    String userName;
    int userID;

    public User(int id, String name) {
        this.userID = id;
        this.userName = name;
    }

    String getUserName() {
        return userName;
    }

    int getUserID() {
        return userID;
    }
}