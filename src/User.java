class User {
    String userName;

    String userJob;

    int userID;

    public User(int id, String name, String job) {
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
    String getUserJob() {return userJob; }
}
