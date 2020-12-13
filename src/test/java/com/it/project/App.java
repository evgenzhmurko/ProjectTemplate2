package com.it.project;

import com.it.project.helpers.CommonHelper;
import com.it.project.helpers.DashboadrHelper;
import com.it.project.helpers.LoginHelper;
import com.it.project.pages.DashboardPage;

public class App {
   public CommonHelper common;
   public DashboardPage dashboard;
   public LoginHelper login;
    public App(){
        common = new CommonHelper();
        dashboard = new DashboadrHelper();
        login = new LoginHelper();
    }
}
