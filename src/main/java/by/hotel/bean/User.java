package by.hotel.bean;

import by.hotel.builder.UserBuilder;

public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String mobilePhone;
    private String login;
    private String passportNumber;
    private String password;
    private Role role;

    public User(){super();}

    public User(UserBuilder userBuilder){
        this.id = userBuilder.getId();
        this.name = userBuilder.getName();
        this.surname = userBuilder.getSurname();
        this.mobilePhone = userBuilder.getMobilePhone();
        this.login = userBuilder.getLogin();
        this.passportNumber = userBuilder.getPassportNumber();
        this.password = userBuilder.getPassword();
        this.role = userBuilder.getRole();
        this.email = userBuilder.getEmail();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /*

     */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!name.equals(user.name)) return false;
        if (!surname.equals(user.surname)) return false;
        if (!mobilePhone.equals(user.mobilePhone)) return false;
        if (!login.equals(user.login)) return false;
        if (!passportNumber.equals(user.passportNumber)) return false;
        if (!password.equals(user.password)) return false;
        return role.equals(user.role);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + mobilePhone.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + passportNumber.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }
}
