package com.example.bryan.studybuddies;

/**
 * Created by Puma on 11/24/17.
 */

public class contact {
    private String name;
    private int icon;
    public contact(String name,int icon) {
        this.name=name;
        this.icon=icon;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIcon() {
        return icon;
    }
    public void setIcon(int img) {
        this.icon = img;
    }
}
