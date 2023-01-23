package jdi.objects;

public class User {

    public static final User ROMAN = new User("Roman", "Jdi1234", "ROMAN IOVLEV");

    private final String login;
    private final String password;
    private final String fullName;

    public User(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }

    public String getName() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }
}
