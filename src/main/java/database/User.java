package database;

public class User {
    private String userName;
    private String password;
    private String number;

    public User(String userName, String password, String number) {
        this.userName = userName;
        this.password = password;
        this.number = number;
    }

    public User() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
