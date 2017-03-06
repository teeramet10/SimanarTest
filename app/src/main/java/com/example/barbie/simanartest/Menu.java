package com.example.barbie.simanartest;

/**
 * Created by barbie on 2/2/2017.
 */

public class Menu {
    String title;
    Class classmenu;

    public Menu(String title, Class classmenu) {
        this.title = title;
        this.classmenu = classmenu;
    }

    public Class getClassmenu() {
        return classmenu;
    }

    public void setClassmenu(Class classmenu) {
        this.classmenu = classmenu;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
