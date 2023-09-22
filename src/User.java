import java.util.Scanner;

class User {
    String userName;
    UserJob userJob;
    int userID;

    public User(int id, String name, UserJob job) {
        this.userID = id;
        this.userName = name;
        this.userJob = job;
    }
    String getUserName() {
        return userName;
    }
    int getUserID() {
        return userID;
    }
    UserJob getUserJob() {
        return userJob;
    }


}
