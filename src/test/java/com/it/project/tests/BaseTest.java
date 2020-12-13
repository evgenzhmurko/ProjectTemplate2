package com.it.project.tests;

import com.it.project.App;
import org.testng.annotations.AfterSuite;

public class BaseTest {
    static App app = new App();
    @AfterSuite
    public void afterSuite(){
        app.common.close();
    }
}
