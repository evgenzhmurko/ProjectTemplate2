package com.it.project;

import com.it.project.helpers.CommonHelper;
import com.it.project.helpers.LoginHelper;
import com.it.project.helpers.MerchHelper;
import com.it.project.users.User;

public class App {
   public CommonHelper common;
   public LoginHelper login;
    public LoginHelper loginAthlete;

    public MerchHelper merch;
    public App(){
        common = new CommonHelper();
        login = new LoginHelper();
        merch = new MerchHelper();
    }

}
