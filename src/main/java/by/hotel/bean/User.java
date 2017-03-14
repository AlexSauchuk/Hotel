package by.hotel.bean;

/**
 * Created by SK on 16.02.2017.
 */
public class User {
    private int id;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User() {
    }

    public String getName() {
        return username;

    }

    @Override
    public String toString() {
        return "id: " + id + " username: " + username + " password: " + password;
    }

    public void setName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
