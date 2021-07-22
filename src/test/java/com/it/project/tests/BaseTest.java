package com.it.project.tests;

import com.it.project.App;
import com.it.project.users.Athlete;
import com.it.project.users.User;
import com.it.project.users.UserFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class BaseTest {
    static App app = new App();
    static User validUser= UserFactory.getValidUser();
    static Athlete validAthlete= UserFactory.getValidAthlete();


    @AfterTest
        public void afterTest(){
        app.common.close();
    }
    @AfterSuite
        public void afterSuite(){
        app.common.close();
    }
}
