package com.it.project.users;

import java.util.Objects;

public class User {
    public String facebookPhone;
    public   String facebookPassword;
    public String userName;
    public String password;
    public String email;
    public String gmailEmail;

    public User(String userName, String password, String email, String facebookPhone, String facebookPassword, String gmailEmail) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.facebookPhone= facebookPhone;
        this.facebookPassword = facebookPassword;
        this.gmailEmail = gmailEmail;
    }



    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", email='" + facebookPhone + '\'' +
                ", email='" + facebookPassword + '\'' +
                ", email='" + gmailEmail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) && Objects.equals(password, user.password) && Objects.equals(email, user.email)&& Objects.equals(facebookPhone, user.facebookPhone)&& Objects.equals(facebookPassword, user.facebookPassword)&& Objects.equals(gmailEmail, user.gmailEmail);

    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password, email);
    }
}
