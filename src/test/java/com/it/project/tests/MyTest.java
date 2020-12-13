package com.it.project.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest extends BaseTest {
    @Test
    public void test() throws InterruptedException {
        app.login.login("evgen.zhmurko", "Password1+");
        Assert.assertEquals(app.dashboard.getLbEmail(), "evgen.zhmurko@i.ua");
    }
}
