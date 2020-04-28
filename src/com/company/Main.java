package com.company;

import com.company.controller.Controller;
import com.company.modul.user.User;

public class Main {

    public static void main(String[] args) {
        User user = new User();
        Controller.start(user);
    }
}
