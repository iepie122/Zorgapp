class ZorgApp {
    public static void main(String[] args) {
        User user = new User(1, "Mark ElCamera");
        Administration administration = new Administration(user);

        administration.menu();
    }
}
