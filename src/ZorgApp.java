class ZorgApp {
    public static void main(String[] args) {
        User user = new User(1 , "Mart ElCamera" ,UserJob.HuisArts);
        Administration administration = new Administration(user);
        administration.menu();
    }
}
