package com.it.project.helpers;

import com.it.project.pages.LoginPage;
import com.it.project.users.Athlete;
import com.it.project.users.User;

public class LoginHelper extends LoginPage {

    public void login(User user) throws InterruptedException {
       login(user.email,user.password);
    }
    public void loginAthlete(Athlete athlete) throws InterruptedException {
        login(athlete.emailAthlete,athlete.password);
    }

}
