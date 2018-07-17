package com.flamezz.creditmanagementapp;

public class Profile {

    String name,email;
    String phone,currentcredit;

    Profile()
    {

    }


    public void setName(String name)
    {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCurrentcredit() {
        return currentcredit;
    }

    public void setCurrentcredit(String currentcredit) {
        this.currentcredit = currentcredit;
    }
}
